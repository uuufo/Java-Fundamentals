package labs_examples.datastructures.queue.labs;

import java.util.Arrays;

/**
 * Queues - Exercise_02
 * <p>
 * Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 * rather than the LinkedList as in the example we have already seen.
 * <p>
 * Your custom Queue class must also do the following:
 * <p>
 * 1) throw a custom exception when trying to pop  an element from an empty Queue
 * 2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 * 3) resize the Queue (the underlying array) to be half the size when the Queue is more than 3/4 empty
 * 4) contain the methods peekFirst() and peekLast()
 * 5) contain a size() method
 * 6) contain a method to print out the data of all elements in the Queue
 */

class Exercise_02 {
    public static void main(String[] args) throws EmptyQueueException {
        MyQueue<Integer> queue = new MyQueue<>(1, 2, 3, 4, 5, 6);
        queue.add(7);
        queue.add(8);
        queue.print();
        queue.remove();
        queue.print();
        int y = queue.remove();
        queue.print();
        queue.poll();
        queue.print();
        int x = queue.poll();
        System.out.println(x + " " + y);

        for (int i = 1; i < 101; i++) {
            queue.add(i + 100);
        }
        queue.print();
        System.out.println("First item in queue: " + queue.peakFirst());
        System.out.println("Last item in queue: " + queue.peakLast());
        for (int i = queue.size(); i > 0; i--) {
            queue.remove();
        }
    }
}

class MyQueue<T> {

    private T[] queue;
    private T[] tempQueue;
    private boolean isEmpty;

    @SuppressWarnings("unchecked")
    public MyQueue(T... data) {
        if (data.length < 6) {
            queue = (T[]) new Object[8];
        } else {
            int a = (data.length / 8) * 8;
            int b = a + 8;
            int x = (data.length - a > b - data.length) ? b : a;
            queue = (T[]) new Object[x];
        }
        for (T item : data) {
            add(item);
        }
    }

    public void add(T data) {
        int count = 0;
        System.out.println(data);
        while (queue[count] != null) {
            count++;
            if (count + 1 >= queue.length - (queue.length / 4)) {
                tempQueue = Arrays.copyOf(queue, queue.length * 2);
                queue = Arrays.copyOf(tempQueue, tempQueue.length);
                System.out.println("Current items in array: " + (size() + 1));
                System.out.println("New Queue size: " + queue.length);
            }
        }
        queue[count] = data;
    }

    public T remove() throws EmptyQueueException {
        if (queue[0] == null) {
            throw new EmptyQueueException();
        } else {
            return dequeue();
        }
    }

    public T poll() {
        if (queue[0] == null) {
            return null;
        } else {
            return dequeue();
        }
    }

    private T dequeue() {
        T data = queue[0];
        System.out.println(data);
        System.arraycopy(queue, 1, queue, 0, queue.length - 1);

        int count = 0;
        while (queue[count] != null) {
            count++;
        }
        if (count <= queue.length / 4 && count > 2) {
            tempQueue = Arrays.copyOf(queue, queue.length / 2);
            queue = Arrays.copyOf(tempQueue, tempQueue.length);
            System.out.println("Current items in array: " + size());
            System.out.println("New Queue size: " + queue.length);
        }
        return data;
    }

    public int size() {
        int count = 0;
        for (T s : queue) {
            if (s != null) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        for (T s : queue) {
            if (s != null) {
                System.out.println(s.toString());
            }
        }
        System.out.println("Current items in array: " + size());
        System.out.println("Current queue length: " + queue.length);
    }

    public T peakLast() {
        if (queue[0] == null) {
            return null;
        }
        int count = 0;
        while (queue[count] != null) {
            count++;
        }
        return queue[count - 1];
    }

    public T peakFirst() {
        return queue[0];
    }
}

class EmptyQueueException extends Exception {
    @Override
    public String toString() {
        return "EmptyQueueException - There is nothing to remove();";
    }
}

