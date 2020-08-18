package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private Card[] cards = new Card[52];
    private ArrayList<Integer> usedCards = new ArrayList<Integer>();
    char[] suits = new char[]{'♠', '♦', '♥', '♣'};
    private static int decksPopulated;

    private void populateDeck() {
        for (int x = 0; x < suits.length; x++) {
            for (int i = 0; i < 13; i++) {
                cards[(x * 13) + i] = new Card(suits[x], i + 1);
            }
        }
    }

    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card.getFaceValue() + " " + card.getSuit() + " " + card.getCardValue());
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

    public void deal(Player player) {
        // for (int i = 0; i < 52; i++) {
        player.getHand().getCards().add(cards[randomCard()]);

        // }  was to test and make sure the entire deck was being dealt correctly
    }

    public Deck() {
        populateDeck();
        decksPopulated++;
    }

    public Card[] getCards() {
        return cards;
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }

    public static int getDecksPopulated() {
        return decksPopulated;
    }

}
