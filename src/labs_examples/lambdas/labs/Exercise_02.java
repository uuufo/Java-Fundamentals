package labs_examples.lambdas.labs;

import java.time.LocalTime;
import java.util.function.*;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

class Exercise_02 {
    public static void main(String[] args) {

        Supplier<LocalTime> time = LocalTime::now;
        System.out.println("Current Time: " + time.get());

        Predicate<Integer> p = i -> (i > 10);
        System.out.println("Is 20 greater than 10? " + p.test(20));

        BiPredicate<Integer, Integer> p2 = (x, y) -> x < y;
        System.out.println("Is 20 less than 10? " + p2.test(20, 10));

        BinaryOperator<Integer> b1 = (x, y) -> x * y;
        System.out.println(b1.apply(5, 7));

        Function<Integer, String> f1 = String::valueOf;
        String test2 = f1.apply(500);
        System.out.println(test2);

        BiFunction<Integer, Integer, String> f2 = (x, y) -> String.valueOf(x + y);
        String test3 = f2.apply(500, 500);
        System.out.println(test3);

        Consumer<String> c1 = System.out::println;
        c1.accept("Hello World!");

        BiConsumer<String, String> c2 = (s1, s2) -> System.out.println(s1 + " " + s2);
        c2.accept("Hello", "World!");

        ToDoubleBiFunction<Integer, Integer> multiply = (x, y) -> (x * y);
        System.out.println(multiply.applyAsDouble(5, 7));

        UnaryOperator<Integer> half = x -> (x / 2);
        System.out.println(half.apply(500));

    }
}