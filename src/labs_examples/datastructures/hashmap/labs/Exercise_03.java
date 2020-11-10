package labs_examples.datastructures.hashmap.labs;

import java.util.*;

/**
 *      HashMaps Exercise_03
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */

class Exercise_03 {
    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashMap<Integer, Integer> h = new HashMap<>();

        long lStart = System.currentTimeMillis();

        long lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            l.add(i + 5000);
        }
        long ltf = System.currentTimeMillis();
        long lt1 = ltf - lts;
        System.out.println("LinkedList Add: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            l.set(i, i + 2000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("LinkedList Update: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            l.get(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("LinkedList Search: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            l.remove(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        lt1 *= 2;
        System.out.println("LinkedList Delete: " + lt1);

        long lFinish = System.currentTimeMillis();
        long totalTime = lFinish - lStart;
        System.out.println("LinkedList Total: " + totalTime);



        lStart = System.currentTimeMillis();

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s.add(i + 5000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Stack Add: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s.set(i, i + 2000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Stack Update: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s.get(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Stack Search: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            s.remove(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        lt1 *= 2;
        System.out.println("Stack Delete: " + lt1);

        lFinish = System.currentTimeMillis();
        totalTime = lFinish - lStart;
        System.out.println("Stack Total: " + totalTime);




        lStart = System.currentTimeMillis();

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            q.add(i + 5000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Queue Add: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            q.add(i + 2000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Queue Update: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            q.peek();
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("Queue Search: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            q.poll();
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        lt1 *= 2;
        System.out.println("Queue Delete: " + lt1);

        lFinish = System.currentTimeMillis();
        totalTime = lFinish - lStart;
        System.out.println("Queue Total: " + totalTime);



        lStart = System.currentTimeMillis();

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            h.put(i, i + 5000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("HashMap Add: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            h.put(i, i + 2000);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("HashMap Update: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            h.get(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        System.out.println("HashMap Search: " + lt1);

        lts = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            h.remove(i);
        }
        ltf = System.currentTimeMillis();
        lt1 = ltf - lts;
        lt1 *= 2;
        System.out.println("HashMap Delete: " + lt1);

        lFinish = System.currentTimeMillis();
        totalTime = lFinish - lStart;
        System.out.println("HashMap Total: " + totalTime);

    }
}