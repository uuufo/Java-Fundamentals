package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 *
 *      Write the necessary code to calculate the volume and surface area of a cylinder
 *      with a radius of 3.14 and a height of 5. Print out the result.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {

        double r = 3.14; // radius of cylinder
        double h = 5;   // height of cylinder

        double v;
        double s;

        v = 3.14159 * (r * r) * h;
        s = ((2 * 3.14159) * (r * r)) + ((2 * 3.14159) * (r * h));

        System.out.println("Volume of the cylinder is: " + v);
        System.out.println("Surface area of the cylinder is: " + s);

    }
}