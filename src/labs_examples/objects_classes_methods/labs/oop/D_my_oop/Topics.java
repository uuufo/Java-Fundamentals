package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Topics {

    private String topic1;
    private String topic2;

    public void getUserTopics(NameGenerator generator) {

        String[] topics = {"music", "outdoors", "movies", "fashion"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type a topic of interest from the following options: ");
        do {
            System.out.println("music | outdoors | movies | fashion");
            topic1 = scanner.next();
        } while (!generator.checkInput(topic1, topics));

        System.out.println("Excellent, please select one more topic: ");
        do {
            System.out.println("music | outdoors | movies | fashion");
            topic2 = scanner.next();
        } while (!generator.checkInput(topic2, topics));

        topic1 += "1";
        topic2 += "2";
        System.out.println("Those are two awesome topics.");
    }

    public void readTopicFile(String topic, ArrayList<String> list) throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir") + "/src/labs_examples/objects_classes_methods/labs/oop/D_my_oop/topic-files/" + topic + ".txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            list.add(fileScanner.nextLine());
        }
    }

    public String getTopic1() {
        return topic1;
    }

    public String getTopic2() {
        return topic2;
    }
}
