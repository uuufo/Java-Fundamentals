package labs_examples.datastructures.linkedlist.labs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */

class Exercise_01 {
    public static void main(String[] args) {

        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();

        Collections.addAll(list1, "Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "William", "Sophia");
        list2.addAll(list1);
        Collections.shuffle(list2);

        LinkedList<String> list3 = new LinkedList<>(list2);

        list1.add("Jared");
        list2.add(list1.getLast());
        list3.addFirst("Jared");
        list3.addLast("Jared");
        list1.addFirst(list3.getFirst());
        list1.set(3, "Jared");
        list2.addFirst(list1.get(3));
        list1.push("Jared");
        list1.pop();
        list1.remove(3);
        if (list2.contains("Jared")) {
            System.out.println("Yep");
        }
        ListIterator<String> lit = list1.listIterator(0);
        while (lit.hasNext()) {
            System.out.println(lit.next());
            System.out.println(lit.nextIndex());
        }
        System.out.println("- - - - - - - -");

        list3.clear();

        for (String s : list1) {
            System.out.println(s);
        }
        System.out.println("- - - - - - - -");
        for (String s : list2) {
            System.out.println(s);
        }
        System.out.println("- - - - - - - -");
        for (String s : list3) {
            System.out.println(s);
        }
    }
}













