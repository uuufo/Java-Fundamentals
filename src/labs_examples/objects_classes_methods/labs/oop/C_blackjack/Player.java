package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    String name;
    Hand hand;
    int potValue; // (the amount of money they have)

    public boolean computerAI() {
        return hand.getHandValue() < 16;
    }

    public int placeBet(Player player) {
        if (potValue > 0) {
            System.out.println(player.name + " places a $5 bet.");
            potValue -= 5;
            return 5;
        } else {
            System.out.println(player.name + " is out of money and cannot bet.");
            return 0;
        }
    }

    public Player(String name, int potValue) {
        this.name = name;
        this.potValue = potValue;
    }
}
