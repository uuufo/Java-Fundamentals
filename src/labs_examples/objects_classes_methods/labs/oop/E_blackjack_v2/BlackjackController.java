package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

import java.util.Scanner;

public class BlackjackControllerV2 {
    public static void main(String[] args) {

        BlackjackControllerV2 controller = new BlackjackControllerV2();
        do {
            controller.playBlackJack();
        } while (controller.playAgain());

    }

    public void playBlackJack() {


    }

    public boolean playAgain() {
        String answer;
        Scanner scanner = new Scanner(System.in);
        String[] acceptedValues = {"y", "n"};

        do{
            System.out.println("Play again? y/n: ");
            answer = scanner.next().toLowerCase();
        } while(!validateInput(answer, acceptedValues));

        if(answer.equals("y")){
            return true;
        } else {
            System.out.println("See ya! Thanks for playing!");
            return false;
        }
    }

    public boolean validateInput(String userInput, String... expected){
        for(String s : expected){
            if(userInput.equalsIgnoreCase(s)){
                return true;
            }
        }
        System.out.print(userInput + " is not a recognized input");
        return false;
    }

}
