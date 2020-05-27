package labs_examples.objects_classes_methods.labs.objects;

public class Exercise_03 {

    public static void main(String[] args) {

        Trailer trailer1 = new Trailer();
        Trailer trailer2 = new Trailer("Venture", "Sonic");
        Trailer trailer3 = new Trailer("SportTrek", "28VBH", "Bunk House", 32);

        System.out.println("Trailer 1 is " + trailer1.make + ".");
        System.out.println("Trailer 2 is a " + trailer2.make + " " + trailer2.model + ".");
        System.out.println("Trailer 3 is a " + trailer3.make + " " + trailer3.model + " " + trailer3.layout + " model and is " + trailer3.length + " feet long.");
        System.out.println(trailer1.toString());
        System.out.println(trailer2.toString());
        System.out.println(trailer3.toString());

    }
}

class Trailer {
    String make;
    String model;
    String layout;
    int length;

    public Trailer() {
    }

    public Trailer(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Trailer(String make, String model, String layout, int length) {
        this.make = make;
        this.model = model;
        this.layout = layout;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", layout='" + layout + '\'' +
                ", length=" + length +
                '}';
    }
}