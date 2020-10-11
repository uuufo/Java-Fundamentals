package labs_examples.arrays.labs;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        int nums[][] = new int[3][7];

        for (int i = 0; i < nums.length; i++) {
            for (int o = 0; o < nums[i].length; o++) {
                nums[i][o] = (i + 8) * 2 * o;
            }
        }

        for (int i = nums.length; i > 0; i--) {
            for (int o = nums[i - 1].length; o > 0; o--) {
                System.out.print(nums[i - 1][o - 1] + " ");
            }
            System.out.println();
        }

        //better way
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int o = nums[i].length - 1; o >= 0; o--) {
                System.out.print(nums[i][o] + " ");
            }
            System.out.println();
        }


    }

}
