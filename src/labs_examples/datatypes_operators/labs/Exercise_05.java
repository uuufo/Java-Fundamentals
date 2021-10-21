package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class Exercise_05 {

    public static void main(String[] args) {

        // example of "OR"

        // if (a | b){
        //    System.out.println("a or b is true");
        // }

        // write your code below

        boolean a = true;
        boolean b = false;

        if (a) {
            System.out.println("a is true");
        } else {
            System.out.println("a is false");
        }
        if (b) {
            System.out.println("b is true");
        } else {
            System.out.println("b is false");
        }
        if (a & b) {
            System.out.println("a and b are true");
        }
        if (a && b) {
            System.out.println("a and b are true");
        }
        if (a | b) {
            System.out.println("a or b are true");
        }
        if (a || b) {
            System.out.println("a or b are true");
        }
        if (a ^ b) {
            System.out.println("either a or b are true, but not both");
        }
        if (!a) {
            System.out.println("a is false");
        }
        if (!b) {
            System.out.println("b is false");
        }
    }
}

