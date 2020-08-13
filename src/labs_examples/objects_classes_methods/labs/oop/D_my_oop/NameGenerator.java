package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class NameGenerator {
    public static void main(String[] args) throws InterruptedException {

        NameGenerator generator = new NameGenerator();
        Numbers numbers = new Numbers();
        Topics topics = new Topics();
        int userDigits;

        System.out.println("Welcome to the username generator!");

        topics.getUserTopics(generator);
        System.out.println("Those are two awesome topics.");

        userDigits = numbers.getUserNumbers(generator);
        if (userDigits != 0) {
            System.out.println("Cool!  Your numbers are: " + userDigits);
        } else {
            System.out.println("We don't need no stinkin' numbers!");
        }

        System.out.println("Now magically calculating your perfect username.");
        generator.doSpinner();


    }

    public void doSpinner() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
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
    }

    public boolean checkInput(String userInput, String... expected){
        for(String s : expected){
            if(userInput.equalsIgnoreCase(s)){
                return true;
            }
        }
        System.out.println(userInput + " is not a valid selection, please try again!");
        return false;
    }


}
