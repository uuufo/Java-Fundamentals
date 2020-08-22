package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Topics {

    private String topic1;
    private String topic2;
    private ArrayList<String> topicList1 = new ArrayList<String>();
    private ArrayList<String> topicList2 = new ArrayList<String>();


    public Topics() throws FileNotFoundException {
        getUserTopics();
        readTopicFile(topic1, 1);
        readTopicFile(topic2, 2);
    }

    public void getUserTopics() {

        String[] topics = {"music", "outdoors", "movies", "fashion"};
        Scanner scanner = new Scanner(System.in);
        Util util = new Util();

        System.out.println("Please type a topic of interest from the following options: ");
        do {
            System.out.println("music | outdoors | movies | fashion");
            topic1 = scanner.next();
        } while (!util.checkInput(topic1, topics));

        System.out.println("Excellent, please select one more topic: ");
        do {
            System.out.println("music | outdoors | movies | fashion");
            topic2 = scanner.next();
        } while (!util.checkInput(topic2, topics));

        topic1 += "1";
        topic2 += "2";
        System.out.println("Those are two awesome topics.");
    }

    public void readTopicFile(String topic, int i) throws FileNotFoundException {

        File file = new File(System.getProperty("user.dir") + "/src/labs_examples/objects_classes_methods/labs/oop/D_my_oop/topic-files/" + topic + ".txt");
        Scanner fileScanner = new Scanner(file);
        if (i == 1) {
            while (fileScanner.hasNextLine()) {
                topicList1.add(fileScanner.nextLine());
            }
        } else if (i == 2) {
            while (fileScanner.hasNextLine()) {
                topicList2.add(fileScanner.nextLine());
            }
        }

    }

    public ArrayList<String> getTopicList1() {
        return topicList1;
    }

    public ArrayList<String> getTopicList2() {
        return topicList2;
    }

    public String getTopic1() {
        return topic1;
    }

    public String getTopic2() {
        return topic2;
    }
}
