package labs_examples.generics.labs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList
 */

class Exercise_02 {
    public static void main(String[] args) {

        ArrayList<Long> longArr = new ArrayList<>(Arrays.asList(23429874552345L, 987389453723L, 373658465653226L, 3642893746758L));
        ArrayList<Double> doubleArr = new ArrayList<>(Arrays.asList(84.13, 24.85, 35.91, 32.11, 17.34));
        ArrayList<Integer> intArr = new ArrayList<>(Arrays.asList(3, 5, 6, 10, 32, 100));

        System.out.println(sumNum(longArr));
        System.out.println(sumNum(doubleArr));
        System.out.println(sumNum(intArr));
        
    }

    public static <T extends Number> float sumNum (ArrayList<T> ar) {
        float result = 0;
        for (T t : ar) {
            result += t.floatValue();
        }
        return result;
    }
}