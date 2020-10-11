package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

public class Exercise_03 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        System.out.println("Lets handle some exceptions!");
        try {
            nums[3] = nums[10];
        } catch (ArithmeticException e) {
            System.out.println("Error, you can't divide by 0.");
        } catch (ArrayIndexOutOfBoundsException arExc) {
            System.out.println("Error, array index out of bounds.");
        } finally {
            System.out.println("We are finally done handling exceptions.");
        }
    }
}
