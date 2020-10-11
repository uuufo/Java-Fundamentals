package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String name;
    private Hand hand = new Hand();
    private int potValue; // (the amount of money they have)
    private int bet;
    private boolean isDone;
    private boolean isBust;
    private boolean allIn;
    private final boolean human;
    private int betCount;
    private int gamesWon;

    public boolean computerAI() {
        return hand.getHandValue() < 16;
    }

    public int computerBetAI() {
        Random rand = new Random();
        int r;
        if (hand.getHandValue() >= 17) {
            r = rand.nextInt((potValue / 2) + 1) + (potValue / 2);
        } else {
            r = rand.nextInt((potValue / 2) + 1) + 1;
        }
        return r;
    }

    public void placeBet() {
        int currentBet;
        if (potValue == 0) {
            System.out.println("You don't have any money left to bet!");
            return;
        }
        if (this.isHuman()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much?");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number!");
                System.out.println("How much would you like to bet?");
                scanner.next();
            }
            currentBet = scanner.nextInt();
        } else {
            currentBet = computerBetAI();
        }
        if (currentBet >= potValue) {
            currentBet = potValue;
            this.allIn = true;
            System.out.println(this.name + " is all in.");
        }
        potValue -= currentBet;
        bet += currentBet;
        betCount++;
        System.out.println(this.name + " places a " + "$" + currentBet + " bet.");
    }

    public Player(String name, int potValue, boolean human) {
        this.name = name;
        this.potValue = potValue;
        this.human = human;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getBetCount() {
        return betCount;
    }

    public void setBetCount(int betCount) {
        this.betCount = betCount;
    }

    public boolean isBust() {
        isBust = hand.getHandValue() > 21;
        isDone = isBust;
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public boolean isAllIn() {
        return allIn;
    }

    public void setAllIn(boolean allIn) {
        this.allIn = allIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getPotValue() {
        return potValue;
    }

    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public boolean isHuman() {
        return human;
    }
}
