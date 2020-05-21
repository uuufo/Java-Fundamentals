package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()

        System.out.println(multiply(5, 5));

        System.out.println(divide(25, 5));

        joke();

        System.out.println(seconds(5));

        int varargs[] = new int[3];

        System.out.println(varargs(varargs));


    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b


    // 3) Create a static void method that will print of joke of your choice to the console


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents


    // 5) Create a varargs method that will return the length of the varargs array passed in

    public static int multiply(int a, int b) {
        return(a * b);
    }

    public static int divide(int a, int b) {
        return(a / b);
    }

    public static void joke(){
        System.out.println("Did you hear about the mathematician who's afraid of negative numbers?\n" +
                "He'll stop at nothing to avoid them.");
    }

    public static int seconds(int years) {
        return(years * 31536000);
    }

    public static int varargs(int[] varargs) {
        return(varargs.length);
    }



}
