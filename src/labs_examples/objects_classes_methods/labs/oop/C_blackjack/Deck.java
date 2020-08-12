package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    Card[] cards = new Card[52];
    ArrayList<Integer> usedCards = new ArrayList<Integer>();
    char[] suits = new char[]{'♠', '♦', '♥', '♣'};

    public void populateDeck() {
        for (int x = 0; x < suits.length; x++) {
            for (int i = 0; i < 13; i++) {
                cards[(x * 13) + i] = new Card();
                cards[(x * 13) + i].cardValue = i + 1;
                cards[(x * 13) + i].suit = suits[x];
            }
        }
    }

    public void printDeck() {
        for (Card card : cards) {
            System.out.println((card.cardValue) + " " + (card.suit));
        }
    }

    public int randomCard() {
        Random rand = new Random();
        int r = rand.nextInt(52);
        while (usedCards.contains(r)) {
                r = rand.nextInt(52);
        }
        usedCards.add(r);
        return r;
    }

    public Deck() {
        populateDeck();
    }

//    public void deal(Player player) {
//        player.hand.cards.add(cards[randomCard()]);
//    }
}


