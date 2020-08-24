package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

public class Exercise_06 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        System.out.println("Lets handle some exceptions!");
        try {
            testMethod(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error, you can't divide by 0.");
        }
    }

    // try without throws
    public static int testMethod(int x, int y) {
        return x/y;
    }
}
