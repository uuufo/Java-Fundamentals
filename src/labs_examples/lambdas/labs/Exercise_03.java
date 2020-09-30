package labs_examples.lambdas.labs;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

@FunctionalInterface
interface ConsolePrinter {
    <T> void print(T t);
}

@FunctionalInterface
interface AnimalPrinter {
    void print(Animal a);
}

class Exercise_03 {
    public static void main(String[] args) {

        ConsolePrinter console = System.out::println;
        console.print("Printing to Console");
        console.print(100);

        Exercise_03 obj = new Exercise_03();
        ConsolePrinter c2 = obj :: InstanceMethod;
        c2.print("Instance Method Printing!");

        AnimalPrinter animalPrinter = Animal :: toConsole;
        Animal miley = new Animal("Dog", "United States");
        animalPrinter.print(miley);

    }

    private <T> void InstanceMethod(T t) {
        System.out.println(t);
    }
}

class Animal {
    String type;
    String location;

    public Animal(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public void toConsole() {
        System.out.println("Animal{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}');
    }
}