package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {

        BlackjackController controller = new BlackjackController();
        controller.playBlackJack();
    }

    public void playBlackJack() {

        Deck deck;

        System.out.println("Let's Play Some Blackjack!");

        Player humanPlayer = newPlayer(true);
        Player cpuPlayer = newPlayer(false);

        System.out.println("Welcome " + humanPlayer.getName() + ", you are now playing against " + cpuPlayer.getName() + ".");
        System.out.println("Winner takes the pot.");

        do {
            deck = new Deck();

            freshGame(humanPlayer, cpuPlayer);
            dealFirstCards(humanPlayer, cpuPlayer, deck);

            takeBets(humanPlayer, cpuPlayer);
            while (hitMe(humanPlayer, cpuPlayer, deck)) {
                takeBets(humanPlayer, cpuPlayer);
            }
            endGame(humanPlayer, cpuPlayer);

        } while (playAgain());
    }

    private void freshGame(Player user, Player cpu) {
        System.out.println("Game #" + Deck.getDecksPopulated());
        System.out.println();
        if (Deck.getDecksPopulated() > 1) {
            System.out.println(user.getGamesWon() + " games won by " + user.getName() + ".");
            System.out.println(cpu.getGamesWon() + " games won by " + cpu.getName() + ".");
            System.out.println();
        }
        user.getHand().getCards().clear();
        cpu.getHand().getCards().clear();
        user.setDone(false);
        cpu.setDone(false);
        user.setBust(false);
        cpu.setBust(false);
        user.setBet(0);
        cpu.setBet(0);
        user.setBetCount(0);
        cpu.setBetCount(0);
        user.setAllIn(false);
        cpu.setAllIn(false);
    }

    private void endGame(Player user, Player cpu) {
        int humanValue = user.getHand().getHandValue();
        int cpuValue = cpu.getHand().getHandValue();
        int moneyPot = (user.getBet() + cpu.getBet());

        System.out.println();
        System.out.println("Your final hand:");
        user.getHand().printHand();
        System.out.println("Total: " + user.getHand().getHandValue());

        System.out.println();
        System.out.println(cpu.getName() + "'s final hand:");
        cpu.getHand().printHand();
        System.out.println("Total: " + cpu.getHand().getHandValue());
        System.out.println();

        if (humanValue > cpuValue && !user.isBust()) {
            System.out.println(user.getName() + " won the game, and WINS $" + moneyPot + "!");
            user.setPotValue(user.getPotValue() + moneyPot);
            user.setGamesWon(user.getGamesWon() + 1);
        } else if (humanValue < cpuValue && !cpu.isBust()) {
            System.out.println(cpu.getName() + " won the game, and WINS $" + moneyPot + "!");
            cpu.setPotValue(cpu.getPotValue() + moneyPot);
            cpu.setGamesWon(cpu.getGamesWon() + 1);
        } else if (humanValue == cpuValue) {
            System.out.println("It's a push!  All bets returned.");
            user.setPotValue(user.getPotValue() + user.getBet());
            cpu.setPotValue(cpu.getPotValue() + cpu.getBet());
        }

        if (!user.isBust() && cpu.isBust()) {
            System.out.println(cpu.getName() + " went bust!");
            System.out.println(user.getName() + " won the game, and WINS $" + moneyPot + "!");
            user.setPotValue(user.getPotValue() + moneyPot);
            user.setGamesWon(user.getGamesWon() + 1);
        } else if (user.isBust() && !cpu.isBust()) {
            System.out.println(user.getName() + " went bust!");
            System.out.println(cpu.getName() + " won the game, and WINS $" + moneyPot + "!");
            cpu.setPotValue(cpu.getPotValue() + moneyPot);
            cpu.setGamesWon(cpu.getGamesWon() + 1);
        } else if (user.isBust() & cpu.isBust()) {
            System.out.println("Both players hands went bust, losers!  All bets returned.");
            user.setPotValue(user.getPotValue() + user.getBet());
            cpu.setPotValue(cpu.getPotValue() + cpu.getBet());
        }

        System.out.println(user.getName() + " has $" + user.getPotValue() + " now.");
        System.out.println(cpu.getName() + " has $" + cpu.getPotValue() + " now.");
        System.out.println();
    }

    private boolean hitMe(Player user, Player cpu, Deck deck) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String[] acceptedValues = {"y", "n"};

        if (!cpu.isDone() || !user.isDone()) {
            if (!user.isDone()) {
                do {
                    System.out.print("Do you want another card? y/n: ");
                    answer = scanner.next().toLowerCase();
                } while (!validateInput(answer, acceptedValues));
                if (answer.equals("y")) {
                    deck.deal(user);
                    System.out.println();
                    System.out.println("Your current hand:");
                    user.getHand().printHand();
                    System.out.println("Total: " + user.getHand().getHandValue());
                    System.out.println();
                    if (user.isBust()) {
                        System.out.println("Well, looks like we went bust... So we aren't going to place any more bets.");
                    }
                } else {
                    user.setDone(true);
                }
            }
            if (cpu.computerAI()) {
                deck.deal(cpu);
                System.out.println(cpu.getName() + " was dealt another card.");
                cpu.isBust();
            } else {
                System.out.println(cpu.getName() + " did not take another card.");
                cpu.setDone(true);
            }
            return true;
        }
        return false;
    }

    private void takeBets(Player user, Player cpu) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String[] acceptedValues = {"y", "n"};

        if (!user.isDone()) {
            System.out.println("You currently have $" + user.getPotValue() + " left.");
            if (!user.isAllIn() && user.getBetCount() < 2) {
                do {
                    System.out.print("Would you like to place a bet? y/n: ");
                    answer = scanner.next().toLowerCase();
                } while (!validateInput(answer, acceptedValues));
                if (answer.equals("y")) {
                    user.placeBet();
                }
            }
        }

        if (cpu.isDone()) {
            System.out.println(cpu.getName() + " does not place a bet.");
        } else {
            if (!cpu.isAllIn() && cpu.getBetCount() < 2) {
                cpu.placeBet();
            }
        }
        System.out.println("The pot is now at $" + (user.getBet() + cpu.getBet()));
        System.out.println();
    }

    private void dealFirstCards(Player user, Player cpu, Deck deck) {
        deck.deal(user);
        deck.deal(cpu);
        deck.deal(user);
        deck.deal(cpu);
        System.out.println("Your current hand:");
        user.getHand().printHand();
        System.out.println("Total: " + user.getHand().getHandValue());
        System.out.println();
        System.out.println("Computer Player's current hand:");
        cpu.getHand().getCards().get(0).printCard();
        System.out.println("(Face Down)");
        System.out.println();
    }

    private Player newPlayer(boolean human) {
        Player player;
        if (human) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            player = new Player(scanner.next(), 100, true);
        } else {
            player = new Player("Computer Player", 100, false);
        }
        return player;
    }

    private boolean playAgain() {
        String answer;
        Scanner scanner = new Scanner(System.in);
        String[] acceptedValues = {"y", "n"};

        do {
            System.out.println("Play again? y/n: ");
            answer = scanner.next().toLowerCase();
        } while (!validateInput(answer, acceptedValues));

        if (answer.equals("y")) {
            return true;
        } else {
            System.out.println("See ya! Thanks for playing!");
            return false;
        }
    }

    public boolean validateInput(String userInput, String... expected) {
        for (String s : expected) {
            if (userInput.equalsIgnoreCase(s)) {
                return true;
            }
        }
        System.out.print(userInput + " is not a recognized input");
        System.out.println();
        return false;
    }

}
