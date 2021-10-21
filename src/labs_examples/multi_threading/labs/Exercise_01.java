package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

class Exercise_01 {
    public static void main(String[] args) {

        TestRunnable runnable1 = new TestRunnable("Thread 1");
        TestRunnable runnable2 = new TestRunnable("Thread 2");

        TestRunnable runnable3 = new TestRunnable();
        runnable3.setName("Thread 3");
        Thread thread3 = new Thread(runnable3);
        thread3.start();

        System.out.println(runnable1.toString());
        System.out.println(runnable3.toString());
        System.out.println(runnable1.thread.toString());
        System.out.println(thread3.toString());

    }
}

class TestRunnable implements Runnable {

    String name;
    Thread thread;

    public TestRunnable(String name) {
        this.name = name;
        thread = new Thread(this, name);
        thread.start();
    }

    public TestRunnable() {
    }

    @Override
    public void run() {
        System.out.println(name + " starting.");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
                System.out.println(name + " count " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}