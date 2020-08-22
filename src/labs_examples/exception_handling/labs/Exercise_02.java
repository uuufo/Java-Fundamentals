package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        try {
            nums[3] = nums[10];
        } catch (ArithmeticException e) {
            System.out.println("Error, you can't divide by 0.");
        } catch (ArrayIndexOutOfBoundsException arExc) {
            System.out.println("Error, array index out of bounds.");
        }
    }
}
