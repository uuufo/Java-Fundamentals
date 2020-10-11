package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

class Exercise_06 {
    public static void main(String[] args) {

        NumberWork numberWork = new NumberWork();
        NumberThread thread1 = new NumberThread(numberWork, "Thread 1", true);
        NumberThread thread2 = new NumberThread(numberWork, "Thread 2", false);

    }
}

class NumberThread implements Runnable {
    NumberWork numberWork;
    Thread thread;
    String name;
    boolean odd;

    public NumberThread(NumberWork obj, String name, boolean odd) {
        this.numberWork = obj;
        this.name = name;
        this.odd = odd;
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        numberWork.printNumbers(odd);
    }
}

class NumberWork {
    public synchronized void printNumbers(boolean odd) {
        if (odd) {
            for (int i = 1; i <= 100; i += 2) {
                notifyAll();
                System.out.println(i);
                if (i != 99) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            for (int i = 2; i <= 100; i += 2) {
                notifyAll();
                System.out.println(i);
                if (i != 100) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}