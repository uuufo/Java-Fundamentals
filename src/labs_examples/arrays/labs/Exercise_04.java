package labs_examples.arrays.labs;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        String[][] names = {
                {"Johnny", "Sally"},
                {"Betty", "Bobby", "Billy"},
                {"Tommy"}
        };

        for (String[] firstDim : names) {
            for (String name : firstDim) {
                System.out.println(name);
            }
        }

        for (int i = 0; i < names.length; i++) {
            for (int o = 0; o < names[i].length; o++) {
                System.out.print(names[i][o] + " ");
            }
            System.out.println();
        }

        //another way

        int[][] nums = new int[3][];
        nums[0] = new int[2];
        nums[1] = new int[10];
        nums[2] = new int[5];
        for (int i = 0; i < nums.length; i++) {
            for (int o = 0; o < nums[i].length; o++) {
                nums[i][o] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int o = 0; o < nums[i].length; o++) {
                System.out.print(nums[i][o] + " ");
            }
            System.out.println();
        }
    }

}
