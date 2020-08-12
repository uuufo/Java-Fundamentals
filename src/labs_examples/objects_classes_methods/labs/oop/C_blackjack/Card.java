package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
    char suit;
    int cardValue;
    String faceValue;

    public String getFaceValue() {
        if(cardValue == 1){
            return "Ace";
        } else if (cardValue >= 2 &&  cardValue <= 10){
            return Integer.toString(cardValue);
        } else if (cardValue == 11){
            return "Jack";
        }else if (cardValue == 12){
            return "Queen";
        }else {
            return "King";
        }
    }
}
