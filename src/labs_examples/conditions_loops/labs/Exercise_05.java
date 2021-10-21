package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 5: Calculator
 *
 *      Take two numbers from the user, an upper and lower bound. Using a "for-loop", calculate the sum
 *      of numbers from the lower bound to the upper bound. Also, calculate the average of numbers.
 *      Print the results to the console.
 *
 *      For example, if a user enters 1 and 100, the output should be:
 *
 *      The sum is: 5050
 *      The average is: 50.5
 *
 *
 */

public class Exercise_05 {

    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);
        System.out.print("Enter the first (lower) number: ");
        int x = prompt.nextInt();
        System.out.print("Enter the second (higher) number: ");
        int y = prompt.nextInt();

        double z = x;
        int intBetween = 1;

        for (int i = x + 1; i <= y; i++) {
            z += i;
            intBetween++;
        }

        System.out.println("Lower range: " + x);
        System.out.println("Upper range: " + y);
        System.out.println("The sum is: " + z);
        System.out.println("The average is: " + z / intBetween);
    }
}
