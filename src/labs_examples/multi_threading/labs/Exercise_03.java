package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 3:
 *
 *      In one of the previous exercises, demonstrate changing the priority of a thread
 */

class Exercise_03 {
    public static void main(String[] args) {

        ThreadTest2 thread1 = new ThreadTest2("Thread 1", 10);
        ThreadTest2 thread2 = new ThreadTest2("Thread 2", 8);
        ThreadTest2 thread3 = new ThreadTest2("Thread 3", 2);
        ThreadTest2 thread4 = new ThreadTest2("Thread 4", 1);

    }
}

class ThreadTest2 extends Thread {

    String name;
    public ThreadTest2(String name, int priority) {
        super(name);
        setPriority(priority);
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
        System.out.println(getName() + " finished.");
    }
}