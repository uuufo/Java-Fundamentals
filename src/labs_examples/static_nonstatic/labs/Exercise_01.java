package labs_examples.static_nonstatic.labs;

public class Exercise_01 {
    public static void main(String[] args) {

        staticMethod1();

    }

    public static void staticMethod1() {
        System.out.println("staticMethod1");
        staticMethod2();
        Exercise_01 staticClass = new Exercise_01();
        staticClass.nonStaticMethod1();
        anotherClass.staticMethod3();
        anotherClass another = new anotherClass();
        another.nonStaticMethod2();
    }

    public static void staticMethod2() {
        System.out.println("staticMethod2");
    }

    public void nonStaticMethod1() {
        System.out.println("nonStaticMethod1");
        nonStaticMethod3();
        anotherClass another = new anotherClass();
        another.nonStaticMethod2();
        staticMethod2();
        anotherClass.staticMethod3();
    }

    public void nonStaticMethod3() {
        System.out.println("nonStaticMethod3");
    }
}

class anotherClass {

    public static void staticMethod3() {
        System.out.println("staticMethod3");
    }

    public void nonStaticMethod2() {
        System.out.println("nonStaticMethod2");
    }
}
