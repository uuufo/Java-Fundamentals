package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameGenerator {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        NameGenerator generator = new NameGenerator();
        Numbers numbers = new Numbers();
        Topics topics = new Topics();
        ArrayList<String> topicList1 = new ArrayList<String>();
        ArrayList<String> topicList2 = new ArrayList<String>();

        System.out.println("Welcome to the username generator!");

        topics.getUserTopics(generator);
        topics.readTopicFile(topics.getTopic1(), topicList1);
        topics.readTopicFile(topics.getTopic2(), topicList2);
        String userName = topicList1.get(numbers.randomDigits(topicList1.size()));
        userName += topicList2.get(numbers.randomDigits(topicList2.size()));

        int userNums = numbers.makeUserNumbers(generator);
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

    public void doSpinner() throws InterruptedException {
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
        System.out.println();
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
