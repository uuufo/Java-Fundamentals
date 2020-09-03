package labs_examples.multi_threading.labs;

import java.io.*;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

class Exercise_04 {
    public static void main(String[] args) {

        File file = new File("src/labs_examples/multi_threading/labs/Exercise_04.dat");
        ThreadObject threadObject = new ThreadObject();
        // it only works if you create the object here, and pass it into the thread, rather than creating it in the thread

        if (file.delete()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ThreadDo thread1 = new ThreadDo("Thread 1", file, threadObject);
        ThreadDo thread2 = new ThreadDo("Thread 2", file, threadObject);
    }
}

class ThreadDo implements Runnable {
    String name;
    Thread thread;
    File file;
    final ThreadObject threadObject;

    public ThreadDo(String name, File file, ThreadObject obj) {
        this.name = name;
        this.file = file;
        this.threadObject = obj;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        threadObject.testPrint(thread);
        synchronized (threadObject) {
            threadObject.write(thread, file);
        }
    }

    public String getName() {
        return name;
    }


}

class ThreadObject {
    // synchronized block
    public void write(Thread thread, File file) {
        try (BufferedWriter bufferOut = new BufferedWriter(new java.io.FileWriter(file, true))) {
            for (int i = 0; i < 10; i++) {
                bufferOut.write(thread.getName() + " write #" + (i + 1));
                bufferOut.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public synchronized void testPrint(Thread thread) {
        // synchronized method
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(thread.getName() + " count " + (i + 1));
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName() + " interrupted!");
        }
    }
}