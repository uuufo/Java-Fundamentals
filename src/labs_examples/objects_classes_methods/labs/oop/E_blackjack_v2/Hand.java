package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int handValue;

    public int getHandValue() {
        handValue = 0;
        for (Card card : cards) {
            handValue += card.getCardValue();
        }
        return handValue;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println((card.getFaceValue()) + " " + (card.getSuit()));
        }
    }
}