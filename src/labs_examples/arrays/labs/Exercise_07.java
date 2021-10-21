package labs_examples.arrays.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        Scanner prompt = new Scanner(System.in);

        System.out.print("Please enter a name: ");
        String firstName = prompt.nextLine();
        names.add(firstName + " Joe");
        names.add(firstName + " Smith");
        names.add(firstName + " Larsen");
        names.add(firstName + " Vion");
        names.add(firstName + " Rutherford");

        for (String fullName : names) {
            System.out.println(fullName);
        }

        names.remove(0);

        if (names.size() == 4) {
            System.out.println("A few more!");
            names.add(firstName + " McIntyre");
            names.add(firstName + " Morgan");
            names.add(firstName + " Gilberg");
        }

        Collections.sort(names);

        for (String fullName : names) {
            System.out.println(fullName);
        }
    }
}
