package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Run the class below and study the output. What prints and why?
 *
 * Your answer:  10 prints, although the actual type of 'a' is 'B', the declared type is 'A'.  So code inside 'A' is ran when the variable is declared? need clarity
 *
 */
class A {
    int i = 10;
}

class B extends A{
    int i = 20;
    public void testMethod() {
        System.out.println("test");
    }
}

public class Exercise_02 {

    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.i);
    }
}