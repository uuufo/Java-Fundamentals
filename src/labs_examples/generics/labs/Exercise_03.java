package labs_examples.generics.labs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

class Exercise_03 {
    public static void main(String[] args) {

        System.out.println((int) getSum(5, 5));
        System.out.println(getSum(5.5, 5.5));

        ArrayList<String> words = new ArrayList<>();
        words.add("this");
        words.add("test");
        words.add("hello");
        words.add("racecar");
        words.add("not");
        words.add("noon");
        words.add("palindrome");
        words.add("mom");
        System.out.println("There are " + getCount(words) + " palindromes.");

        String[] s = {"this", "is", "a", "test"};
        mixArray(s, 0, 3);
        mixArray(s, 0, 2);
        mixArray(s, 1, 2);
        for (String value : s) {
            System.out.print(value + " ");
        }
        System.out.println();

        ArrayList<Double> dbAr = new ArrayList<>(Arrays.asList(24.21, 67.3, 89.23, 29.85));
        ArrayList<Integer> intAr = new ArrayList<>(Arrays.asList(1, 9, 3, 34, 24, 3, 65, 15, 4));
        System.out.println(getLarge(dbAr));
        System.out.println((int) getLarge(intAr));

    }

    public static <V extends Number, T extends List<V>> double getLarge(T t) {
        double high = 0;
        for (V v : t) {
            if (v.doubleValue() > high) {
                high = v.doubleValue();
            }
        }
        return high;
    }

    public static <T> T[] mixArray(T[] t, int a, int b) {
        T temp = t[a];
        t[a] = t[b];
        t[b] = temp;
        return t;
    }

    public static <T extends Number, V extends Number> double getSum(T t, V v) {
        return t.doubleValue() * v.doubleValue();
    }

    public static <T> int getCount(Collection<T> c) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (T s : c) {
            builder.append(s);
            if (s.equals(builder.reverse().toString())) {
                count++;
            }
            builder.setLength(0);
        }
        return count;
    }

}