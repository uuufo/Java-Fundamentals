package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {

        int s = 0;
        int a = 0;
        int[] nums = new int[10];

        Scanner prompt = new Scanner(System.in);
        System.out.println("I'm going to prompt you to enter 10 numbers.");

        for (int i = 0; i < nums.length; i++) {
            System.out.print("Please enter number " + (i + 1) + ": ");
            nums[i] = prompt.nextInt();
        }

        for (int x : nums) {
            s += x;
            a = s / nums.length;
        }

        System.out.println("The sum of all 10 numbers is: " + s);
        System.out.println("The average of all 10 numbers is: " + a);


    }


}