package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate you're mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */

class Exercise_01 {
    public static void main(String[] args) {
        HashMap<Integer, String> m = new HashMap<>();
        m.put(1, "Test");
        System.out.println(m.get(1));
        HashMap<Integer, String> m2 = new HashMap<>();
        m2.put(2, "Test2");
        m.putAll(m2);
        System.out.println(m2);
        System.out.println(m);
        System.out.println(m.size());
        if (m.containsKey(2)) {
            System.out.println("Yes");
        }
        Set<Integer> s = m.keySet();
        Set<Map.Entry<Integer, String>> e = m.entrySet();
        System.out.println(s);
        System.out.println(e);
        m.putIfAbsent(3, "Test3");
        m.putIfAbsent(3, "TestPut");
        System.out.println(m);
        m.remove(3);
        System.out.println(m);
        m.replace(2, "TestNew");
        System.out.println(m);
        m.forEach((k, v) -> System.out.println(k + " " + v));
        m.clear();
        System.out.println(m);

    }
}