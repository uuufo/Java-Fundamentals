package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 5:
 * <p>
 * Demonstrate how to throw an exception.
 */

public class Exercise_05 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        System.out.println("Lets handle some exceptions!");
        try {
            throw new ArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("Error, you can't divide by 0.");
        }
    }
}

