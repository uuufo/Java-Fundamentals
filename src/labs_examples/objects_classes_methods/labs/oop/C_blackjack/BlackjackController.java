package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {

        playBlackJack();
/*

    // deck.printDeck();

    jared.hand = new Hand(deck);
    jared.hand.printHand();


    jared.hand.deal(deck);

    jared.hand.printHand();

    System.out.println(jared.hand.getHandValue());

*/

    }

    public static void playBlackJack() {

        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's Play Some Blackjack!");
        System.out.print("Please enter your name: ");
        Player humanPlayer = new Player(scanner.next());
        Player cpuPlayer = new Player("Optimus Prime");

        System.out.println("Welcome " + humanPlayer.name + ", you are now playing against " + cpuPlayer.name + ".");

        humanPlayer.hand = new Hand(deck);
        cpuPlayer.hand = new Hand(deck);

        humanPlayer.hand.deal(deck);
        cpuPlayer.hand.deal(deck);

        System.out.println("Your current hand:");
        humanPlayer.hand.printHand();
        System.out.println("Total: " + humanPlayer.hand.getHandValue());

        boolean humanDone = false;
        boolean cpuDone = false;

        while (!humanPlayer.hand.isBust(humanPlayer.hand) || !humanDone) {

            System.out.print("Do you want another card? Y/N: ");
            String answer = scanner.next().toLowerCase();
            if (answer.equals("y")) {
                humanPlayer.hand.deal(deck);
                System.out.println("Your current hand:");
                humanPlayer.hand.printHand();
                System.out.println("Total: " + humanPlayer.hand.getHandValue());
            } else {
                humanDone = true;
            }
        }

        while (!cpuPlayer.hand.isBust(cpuPlayer.hand) || !cpuDone) {
            if (cpuPlayer.computerAI()) {
                cpuPlayer.hand.deal(deck);
                System.out.println(cpuPlayer.name + " was dealt another card.");
            } else {
                cpuDone = true;
            }
        }

        if (humanPlayer.hand.isBust(humanPlayer.hand)) {
            System.out.println(humanPlayer.name + " went bust!");
        }
        System.out.println("Your final hand:");
        humanPlayer.hand.printHand();
        System.out.println("Total: " + humanPlayer.hand.getHandValue());

        if (cpuPlayer.hand.isBust(cpuPlayer.hand)) {
            System.out.println(cpuPlayer.name + " went bust!");
        }
        System.out.println(cpuPlayer.name + "'s final hand:");
        cpuPlayer.hand.printHand();
        System.out.println("Total: " + cpuPlayer.hand.getHandValue());

        if (humanPlayer.hand.getHandValue() > cpuPlayer.hand.getHandValue() && !humanPlayer.hand.isBust(humanPlayer.hand)) {
            System.out.println(humanPlayer.name + " won the game!!!");
        } else if (cpuPlayer.hand.getHandValue() > humanPlayer.hand.getHandValue() && !cpuPlayer.hand.isBust(cpuPlayer.hand)) {
            System.out.println(cpuPlayer.name + " won the game!!!");
        } else {
            System.out.println("Both players hands went bust, losers!");
        }



    }


}
