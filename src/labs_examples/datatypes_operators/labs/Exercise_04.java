package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all relational operators below. These include:
 *
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 *
 */
class Exercise_04 {

    public static void main(String[] args) {

        // example of "less than"
        // int a = 1;
        // int b = 2;
        // if (a < b){
            // System.out.println("a is less than b");
        // }

        // write your code below

        int x = 10;
        int y = 20;
        if (x < y) {
            System.out.println(x + " is less than " + y);
        } else {
            System.out.println(y + " is less than " + x);
        }
        if (x > y) {
            System.out.println(x + " is greater than " + y);
        } else {
            System.out.println(y + " is greater than " + x);
        }
        if (x <= y) {
            System.out.println(x + " is less than or equal to " + y);
        }
        if (x >= y) {
            System.out.println(x + " is greater than or equal to " + y);
        }
        if (x == y) {
            System.out.println(x + " = " + y);
        }
        if (x != y) {
            System.out.println(x + " does not equal " + y);
        }

    }
}

