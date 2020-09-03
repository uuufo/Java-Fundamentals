package labs_examples.multi_threading.labs.Exercise_05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

class Exercise_05 {
    public static void main(String[] args) {

        File file = new File("src/labs_examples/multi_threading/labs/Exercise_05/Exercise_05.dat");
        ThreadObject threadObject = new ThreadObject();
        // it only works if you create the object here, and pass it into the thread, rather than creating it in the thread

        checkFile(file);

        ThreadWrite thread1 = new ThreadWrite("Thread 1", file, threadObject);
        ThreadPrint thread2 = new ThreadPrint("Thread 2", file, threadObject);
        try {
            thread1.thread.join();
            thread2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadWrite thread3 = new ThreadWrite("Thread 3", file, threadObject);
        ThreadPrint thread4 = new ThreadPrint("Thread 4", file, threadObject);
    }

    public static void checkFile(File file) {
        if (file.delete()) {
            try {
                if(!file.createNewFile()) {
                    System.out.println("Couldn't create file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadWrite implements Runnable {
    String name;
    Thread thread;
    File file;
    final ThreadObject threadObject;

    public ThreadWrite(String name, File file, ThreadObject obj) {
        this.name = name;
        this.file = file;
        this.threadObject = obj;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (threadObject) {
            threadObject.write(thread, file);
        }
    }

    public String getName() {
        return name;
    }
}

class ThreadPrint implements Runnable {
    String name;
    Thread thread;
    File file;
    ThreadObject threadObject;

    public ThreadPrint(String name, File file, ThreadObject obj) {
        this.name = name;
        this.file = file;
        this.threadObject = obj;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        threadObject.testPrint(thread);
    }

    public String getName() {
        return name;
    }
}

class ThreadObject {
    boolean printDone = false;
    // synchronized block
    public void write(Thread thread, File file) {
        while (!printDone) {
            try {
                System.out.println(thread.getName() + " is going to wait here for a testPrint to finish.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ok, now " + thread.getName() + " is writing file.");
        try (BufferedWriter bufferOut = new BufferedWriter(new java.io.FileWriter(file, true))) {
            for (int i = 0; i < 10; i++) {
                bufferOut.write(thread.getName() + " write #" + (i + 1));
                bufferOut.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printDone = false;
    }

    public synchronized void testPrint(Thread thread) {
        // synchronized method
        System.out.println(thread.getName() + " is printing.");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(thread.getName() + " count " + (i + 1));
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " interrupted!");
        }
        printDone = true;
        notifyAll();
    }
}
