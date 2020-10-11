package labs_examples.lambdas.labs;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 *
 *
 *
 *
 */

@FunctionalInterface
interface VoidInterface {
    public void test();
}

@FunctionalInterface
interface OneParamInterface {
    public int test(int x);
}

@FunctionalInterface
interface TwoParamInterface {
    public String test(String x, String y);
}

class Exercise_01 {
    public static void main(String[] args) {

        VoidInterface v1 = () -> System.out.println("Void Lambda Test");
        v1.test();

        VoidInterface v2 = new VoidInterface() {
            @Override
            public void test() {
                System.out.println("Void Anon Test");
            }
        };
        v2.test();

        OneParamInterface o1 = (int x) -> x * 5;
        System.out.println("5 * 5 = " + o1.test(5));

        OneParamInterface o2 = new OneParamInterface() {
            @Override
            public int test(int x) {
                return x * 5;
            }
        };
        System.out.println("5 * 5 = " + o2.test(5));

        TwoParamInterface t1 = (String x, String y) -> x + " " + y;
        System.out.println(t1.test("Hello", "World"));

        TwoParamInterface t2 = new TwoParamInterface() {
            @Override
            public String test(String x, String y) {
                return x + " " + y;
            }
        };
        System.out.println(t2.test("Hello", "World"));

        Predicate<Integer> isEven = i -> (i % 2 == 0);
        System.out.println(isEven.test(12) + ", " + isEven.test(33) + ", " + isEven.test(24));

        Function<String, String> addPeriod = s -> (s += ".");
        System.out.println(addPeriod.apply("Hello World"));

    }
}