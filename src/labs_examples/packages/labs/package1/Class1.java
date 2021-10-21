package labs_examples.packages.labs.package1;

import labs_examples.packages.labs.package2.Class2;

public class Class1 {
    public static void main(String[] args) {

        Class1 class1 = new Class1();
        if (!class1.printPublic()) {
            System.out.println("Can't access that.");
        }
        if (!class1.printPrivate()) {
            System.out.println("Can't access that.");
        }
        if (!class1.printProtected()) {
            System.out.println("Can't access that.");
        }

        Class2 class2 = new Class2();
        if (!class2.printPublic()) {
            System.out.println("Can't access that.");
        }
        if (!class2.printPrivate()) {
            System.out.println("Can't access that.");
        }
//        if (!class2.printProtected()) {
//            System.out.println("Can't access that.");
//        }

    }

    public boolean printPublic() {
        System.out.println("Package 1 Public Printing");
        return true;
    }

    public boolean printPrivate() {
        System.out.println("Package 1 Private Printing");
        return true;
    }

    protected boolean printProtected() {
        System.out.println("Package 1 Protected Printing");
        return true;
    }
}
