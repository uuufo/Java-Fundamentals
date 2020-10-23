package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */

class Exercise_01 {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("Add");
        String s = q.peek();
        q.remove();
        q.add("Add");
        s = q.poll();
        Boolean b = q.contains("Queue");
        q.add("Add");
        System.out.println(q.size());
        q.clear();


    }
}