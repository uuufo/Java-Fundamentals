package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a seperate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a seperate class.
 */


class Exercise_01 {
    public static void main(String[] args) {

        Grocery.Dairy curDairy = Grocery.Dairy.CHEESE;
        getDairyType(curDairy);
        curDairy = Grocery.Dairy.YOGURT;
        getDairyType(curDairy);

        Grocery.Produce curProduce = Grocery.Produce.APPLE;
        System.out.println("Current produce: " + curProduce.name() + " is a " + curProduce.getType());
        curProduce = Grocery.Produce.CARROT;
        System.out.println("Current produce: " + curProduce.name() + " is a " + curProduce.getType());
    }

    public static void getDairyType(Grocery.Dairy dairy) {
        switch (dairy) {
            case CHEESE:
                System.out.println("Cheese is selected.");
                break;
            case YOGURT:
                System.out.println("Yogurt is selected.");
                break;
            case MILK:
                System.out.println("Milk is selected.");
                break;
        }
    }
}

class Grocery {
    enum Produce {

        CORN("Vegetable"),
        WATERMELON("Fruit"),
        CARROT("Vegetable"),
        APPLE("Fruit");

        private final String type;

        Produce(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    enum Dairy {
        MILK, CHEESE, YOGURT;

    }
}