package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameGenerator {
    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        Numbers numbers = new Numbers();
        Topics topics = null;
        try {
            topics = new Topics();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("Welcome to the username generator!");

        String userName = topics.getTopicList1().get(numbers.randomDigits(topics.getTopicList1().size()));
        userName += topics.getTopicList2().get(numbers.randomDigits(topics.getTopicList2().size()));

        int userNums = numbers.makeUserNumbers();
        if (userNums != 0) {
            System.out.println("Cool!  Your numbers are: " + userNums);
            userName += userNums;
        } else {
            System.out.println("We don't need no stinkin' numbers!");
        }

        System.out.println("Now magically calculating your perfect username.");
        generator.doSpinner();

        System.out.println(userName);
        System.out.println("**********");
        System.out.println("Hope you like it!");
    }

    public void doSpinner() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print('/');
                Thread.sleep(100);
                System.out.print('\b');
                System.out.print('-');
                Thread.sleep(100);
                System.out.print('\b');
                System.out.print('\\');
                Thread.sleep(100);
                System.out.print('\b');
                System.out.print("*");
            }
        } catch (Exception e) {
            // do nothing
        }

        System.out.println();
    }
}
