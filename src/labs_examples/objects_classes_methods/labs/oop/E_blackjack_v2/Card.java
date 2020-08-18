package labs_examples.objects_classes_methods.labs.oop.E_blackjack_v2;

public class Card {
    private char suit;
    private int cardValue;
    private String faceValue;

    public Card(char suit, int cardValue) {
        this.suit = suit;
        this.faceValue = setFaceValue(cardValue);
        if (cardValue > 10) {
            this.cardValue = 10;
        } else {
            this.cardValue = cardValue;
        }
    }

    public String setFaceValue(int cardValue) {
        if(cardValue == 1){
            return "Ace";
        } else if (cardValue >= 2 &&  cardValue <= 10){
            return Integer.toString(cardValue);
        } else if (cardValue == 11){
            return "Jack";
        } else if (cardValue == 12){
            return "Queen";
        } else {
            return "King";
        }
    }

    public String getFaceValue() {
        return faceValue;
    }

    public void printCard() {
        System.out.println(faceValue + " " + suit);
    }

    public char getSuit() {
        return suit;
    }

    public int getCardValue() {
        return cardValue;
    }




}
