package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Random;
import java.util.Scanner;

public class Numbers {

    public int makeUserNumbers() {

        String answer;
        Scanner scanner = new Scanner(System.in);
        String[] answers = {"y", "n", "yes", "no"};
        Util util = new Util();

        System.out.println("Do you want numbers included at the end of the username also?");
        do {
            answer = scanner.next();
        } while (!util.checkInput(answer, answers));

        if (answer.startsWith("y")) {
            do {
                System.out.println("Please enter your favorite number, or type 'random': ");
                if (scanner.hasNextInt()) {
                    return scanner.nextInt();
                }
                answer = scanner.next();
            } while (!util.checkInput(answer, "random"));
            return randomDigits(999);
        }
        return 0;
    }

    public int randomDigits(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
}
