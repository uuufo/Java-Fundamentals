package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

public class Exercise_01 {
    public static void main(String[] args) {

        Computer<String, Integer> ridersComputer = new Computer<>("Alienware", 500);
        Computer<String, String> jaredsComputer = new Computer<>("Mac", "Fast");
        Computer<String, Integer> talonsComputer = new Computer<>("Dell", 500);

        System.out.println(ridersComputer.toString());
        System.out.println(jaredsComputer.toString());
        System.out.println(talonsComputer.toString());

    }
}


class Computer<T, K> {
    T brand;
    K speed;

    public Computer(T brand, K speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public T getBrand() {
        return brand;
    }

    public void setBrand(T brand) {
        this.brand = brand;
    }

    public K getSpeed() {
        return speed;
    }

    public void setSpeed(K speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Speed: " + speed;
    }
}

