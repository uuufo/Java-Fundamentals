package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */

public class Exercise_04 {
    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3};
        System.out.println("Lets handle some exceptions!");
        try {
            try {
                nums[3] = nums[1] / nums[0];
            } catch (ArithmeticException e) {
                System.out.println("Error, you can't divide by 0.");
            }
            nums[3] = nums[10];
        } catch (ArrayIndexOutOfBoundsException arExc) {
            System.out.println("Error, array index out of bounds.");
        } catch (Exception exc) {
            System.out.println("Some type of error occurred.");
        } finally {
            System.out.println("We are finally done handling exceptions.");
        }
    }
}