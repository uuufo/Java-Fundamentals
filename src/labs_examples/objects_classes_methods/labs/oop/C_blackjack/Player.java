package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand;
    int potValue; // (the amount of money they have)

    public boolean computerAI() {
        if (hand.getHandValue() < 16) {
            return true;
        } else {
            return false;
        }
    }

    public Player(String name) {
        this.name = name;
    }
}
