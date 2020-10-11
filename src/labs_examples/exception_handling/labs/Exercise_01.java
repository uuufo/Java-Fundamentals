package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */

public class Exercise_01 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        try {
            nums[3] = nums[1] / nums[0];
        } catch (ArithmeticException e) {
            System.out.println("Error, you can't divide by 0.");
        }
    }
}