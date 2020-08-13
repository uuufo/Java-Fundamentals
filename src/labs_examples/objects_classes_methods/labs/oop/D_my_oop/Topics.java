package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class Topics {

    public void getUserTopics(NameGenerator generator) {
        String topic1;
        String topic2;
        String[] topics = {"music", "gaming", "outdoors", "sports"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type a topic of interest from the following options: ");
        do {
            System.out.println("music | gaming | outdoors | sports");
            topic1 = scanner.next();
        } while (!generator.checkInput(topic1, topics));

        System.out.println("Excellent, please select one more topic: ");
        do {
            System.out.println("music | gaming | outdoors | sports");
            topic2 = scanner.next();
        } while (!generator.checkInput(topic2, topics));

    }
}
