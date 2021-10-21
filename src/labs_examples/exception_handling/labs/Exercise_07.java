package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 7:
 * <p>
 * 1) Create a custom exception.
 * 2) Demonstrate a method throwing your custom exception.
 */

public class Exercise_07 {
    public static void main(String[] args) {

        System.out.println("Lets handle a custom exception!");
        try {
            makeRightTurn(false);
        } catch (WrongWayException e) {
            System.out.println("Error, wrong way.");
            System.out.println(e.toString());
        }
    }

    public static void makeRightTurn(boolean right) throws WrongWayException {
        if (!right) {
            throw new WrongWayException();
        }
    }
}

class WrongWayException extends Exception {
    @Override
    public String toString() {
        return "WrongWayException{ You went the wrong way }";
    }
}