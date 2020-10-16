package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Create and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
<<<<<<< HEAD
        int[][] twoDArray = new int[5][5];
        int lastCount = 0;
        // use 2 for loops to populate the 2d array
        // first for loop
        for (int i = 0; i < twoDArray.length; i++){
            for (int o = 0; o < twoDArray[i].length; o++){
                twoDArray[i][o] = lastCount + o * 3 + 3;
                System.out.print(twoDArray[i][o] + " ");
                if (o == 4) {
                    lastCount = twoDArray[i][o];
                }
            }
            System.out.println();
        }
=======
        
>>>>>>> fc36c4b1b8c5d2bc07ff287dc39939c4a3926817
    }
}
