package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

class Exercise_02 {
    public static void main(String[] args) {

        ThreadTest thread1 = new ThreadTest("Thread 1");
        ThreadTest thread2 = new ThreadTest("Thread 2");

    }
}

class ThreadTest extends Thread {

    String name;
    public ThreadTest(String name) {
        super(name);
        start();
    }
    @Override
    public void run() {
        System.out.println(getName() + " starting.");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(getName() + " count " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted!");
        }
    }
}