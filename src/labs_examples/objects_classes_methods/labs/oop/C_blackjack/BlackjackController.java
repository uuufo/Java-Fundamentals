package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {
        // RYAN:
        BlackjackController controller = new BlackjackController();
        do {
            playBlackJack();
        } while (controller.playAgain());
    }

    public static void playBlackJack() {


        /*
        player = createPlayer()
        ...
        while(){
            deal()
            score()
            bet()
            deal()
            ...
       }
       sout("goodbye")
         */

        int moneyPot = 0;
        boolean humanDone;  // is initialized when we check if human went bust after initial deal
        boolean cpuDone = false;  // we don't need to check if they went bust until later because the user won't know until the game is over
        Deck deck = new Deck();

        Scanner scanner = new Scanner(System.in);

        Player humanPlayer = newPlayer(true);
        Player cpuPlayer = newPlayer(false);

        System.out.println("Welcome " + humanPlayer.name + ", you are now playing against " + cpuPlayer.name + ".");
        System.out.println("Winner takes the pot.");
        System.out.println();

        // RYAN: I would deal like in the line below
        //deck.deal(humanPlayer)
        humanPlayer.hand = new Hand(deck);
        cpuPlayer.hand = new Hand(deck);

        humanPlayer.hand.deal(deck);
        cpuPlayer.hand.deal(deck);

        System.out.println("Your current hand:");
        humanPlayer.hand.printHand();
        System.out.println("Total: " + humanPlayer.hand.getHandValue());
        System.out.println();

        // check if human already went bust
        humanDone = humanPlayer.hand.isBust();
        if (humanDone) {
            System.out.println("Well, looks like we went bust... So we aren't going to place any more bets.");
            System.out.println("Lets see how " + cpuPlayer.name + " does.");
            System.out.println();
        }

        // if we didn't bust, place initial bet
        if (!humanDone) {
            System.out.print("Place a bet? y/n: ");
            String answer = scanner.next().toLowerCase();
            if (answer.equals("y")) {
                moneyPot += humanPlayer.placeBet(humanPlayer);
            }
        }

        // if cpu didn't bust, it places a bet as well
        if (cpuPlayer.hand.isBust()) {
            System.out.println(cpuPlayer.name + " does not place a bet.");
        } else {
            moneyPot += cpuPlayer.placeBet(cpuPlayer);
        }
        System.out.println("The pot is now at $" + moneyPot);

        // deal cards until both are done or bust
        while (!cpuDone || !humanDone) {
            if (!humanDone) {

                // RYAN:
                //promptNextCard(human); - casual idea
                System.out.print("Do you want another card? y/n: ");
                String answer = scanner.next().toLowerCase();
                if (answer.equals("y")) {
                    humanPlayer.hand.deal(deck);
                    System.out.println();
                    System.out.println("Your current hand:");
                    humanPlayer.hand.printHand();
                    System.out.println("Total: " + humanPlayer.hand.getHandValue());
                    System.out.println();
                    humanDone = humanPlayer.hand.isBust(); // check if human went bust, if so they are done
                    if (humanDone) {
                        System.out.println("Well, looks like we went bust... So we aren't going to place any more bets.");
                        System.out.println("Lets see how " + cpuPlayer.name + " does.");
                        System.out.println();
                    } else {
                        System.out.print("Place a bet? y/n: ");
                        answer = scanner.next().toLowerCase();
                        if (answer.equals("y")) {
                            moneyPot += humanPlayer.placeBet(humanPlayer);
                            System.out.println("The pot is now at $" + moneyPot);
                        }
                    }
                } else {
                    humanDone = true;
                }
            }
            if (cpuPlayer.computerAI()) {
                cpuPlayer.hand.deal(deck);
                System.out.println(cpuPlayer.name + " was dealt another card.");
                cpuDone = cpuPlayer.hand.isBust(); // check if cpu went bust, if so they are done
            } else {
                System.out.println(cpuPlayer.name + " did not take another card.");
                cpuDone = true;
            }
            if (!cpuPlayer.hand.isBust()) {
                moneyPot += cpuPlayer.placeBet(cpuPlayer);
                System.out.println("The pot is now at $" + moneyPot);
            } else {
                System.out.println(cpuPlayer.name + " does not place a bet.");
            }
        }

        int humanValue = humanPlayer.hand.getHandValue();
        int cpuValue = cpuPlayer.hand.getHandValue();
        boolean cpuBust = cpuPlayer.hand.isBust();
        boolean humanBust = humanPlayer.hand.isBust();

        System.out.println();
        System.out.println("Your final hand:");
        humanPlayer.hand.printHand();
        System.out.println("Total: " + humanValue);

        System.out.println();
        System.out.println(cpuPlayer.name + "'s final hand:");
        cpuPlayer.hand.printHand();
        System.out.println("Total: " + cpuValue);
        System.out.println();

        System.out.println(humanPlayer.name + " started the game with $20 and has $" + humanPlayer.potValue + " remaining.");
        System.out.println(cpuPlayer.name + " started the game with $20 and has $" + cpuPlayer.potValue + " remaining.");

        // RYAN:
        // scoreGame(human, cpu)
            if (humanValue > cpuValue && !humanBust) {
                System.out.println(humanPlayer.name + " won the game, and WINS $" + moneyPot + "!");
            } else if (humanValue < cpuValue && !cpuBust) {
                System.out.println(cpuPlayer.name + " won the game, and WINS $" + moneyPot + "!");
            } else if (humanValue == cpuValue) {
                System.out.println("It's a push!  All bets returned.");
            }

            if (!humanBust && cpuBust) {
                System.out.println(cpuPlayer.name + " went bust!");
                System.out.println(humanPlayer.name + " won the game, and WINS $" + moneyPot + "!");
            } else if (humanBust && !cpuBust) {
                System.out.println(humanPlayer.name + " went bust!");
                System.out.println(cpuPlayer.name + " won the game, and WINS $" + moneyPot + "!");
            } else if (humanBust & cpuBust) {
                System.out.println("Both players hands went bust, losers!  All bets returned.");
            }
        // END scoreGame(human, cpu)

    }

    private static Player newPlayer(boolean isHuman) {
        Player player;
        if (isHuman) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Let's Play Some Blackjack!");
            System.out.print("Please enter your name: ");
            player = new Player(scanner.next(), 15);
        } else {
            player = new Player("Freddy Faz", 15);
        }
        return player;
    }

    public boolean playAgain() {
//        System.out.print("Play again? y/n: ");
//        Scanner scanner = new Scanner(System.in);
        String answer = "";
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
        boolean retVal = false;

        for(String s : expected){
            if(userInput.equalsIgnoreCase(s)){
                return true;
            }
        }
        System.out.print(userInput + " is not a recognized input");

        return retVal;
    }
}
