package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards = new ArrayList<Card>();
    int handValue;

    public boolean isBust(Hand hand) {
        if (getHandValue() > 21) {
            return true;
        } else {
            return false;
        }
    }

    public int getHandValue() {
        handValue = 0;
        for (Card card : cards) {
            handValue += card.cardValue;
        }
        return handValue;
    }

    public void deal(Deck deck) {
        // for (int i = 0; i < 52; i++) {
            cards.add(deck.cards[deck.randomCard(deck)]);
        // }  was to test and make sure the entire deck was being dealt correctly
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println((card.cardValue) + " " + (card.suit));
        }
    }

    public Hand(Deck deck) {
        deal(deck);
    }
}
