package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 *  More labs_examples.arrays
 *
 *      Using the array below, take in a number from 1-10 from the user and print out the index of that
 *      element.
 *
 */

public class Exercise_02 {

    public static void main(String[] args) {

        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // write code here

        Scanner prompt = new Scanner(System.in);

        System.out.print("Please enter a number between 1 and 10: ");
        int n = prompt.nextInt();
        System.out.println("index " + n + " contains the number " + array[n]);

        // or did you mean this?

        for (int i : array) {
            if (i == n) {
                System.out.println("number " + n + " is contained in index " + array[i]);
                break;
            }
        }

    }
}