package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    int handValue;

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public int getHandValue() {
        handValue = 0;
        for (Card card : cards) {
            handValue += card.cardValue;
        }
        return handValue;
    }

    public ArrayList<Card> getCards() {
        //if (user.isAuthenticated())
            // return cards
        return cards;
        // else
            // throw new authorizationException
    }

    /*
        RYAN: i would put the deal() method in the Deck class and pass it the player
         */
    public void deal(Deck deck) {
        // for (int i = 0; i < 52; i++) {
            cards.add(deck.cards[deck.randomCard()]);
        // }  was to test and make sure the entire deck was being dealt correctly
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println((card.cardValue) + " " + (card.suit));
        }
    }

    public Hand(Deck deck) {
        // RYAN: I wouldn't call the bad deal() method here - you may not even need this constructor
        deal(deck);
    }
}
