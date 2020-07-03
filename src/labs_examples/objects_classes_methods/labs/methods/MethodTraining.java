package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;

public class MethodTraining {

    public static void main(String[] args) {

        //Method #1 & 3
        System.out.println("------ Method #1 & 3 ------");
        int[] test = {1, 4, 568, 400, 8, 15, 567};
        double[] test2 = {3.45, 1.2, 40.5, 32.9};
        System.out.println(getLargeArr(test));
        System.out.println(getLargeArr(test2));

        System.out.println(getLarge(3769, 645, 6345, 874));

        //Method #2
        System.out.println("------ Method #2 ------");
        int x = 5;
        int y = 10;
        passVal(x, y);
        System.out.println("Back in Main, x still equals " + x);
        System.out.println("Back in Main, y still equals " + y);
        testObj obj = new testObj("Object1", 32);
        passRef(obj);
        System.out.println(obj.toString());

        //Method #4
        System.out.println("------ Method #4 ------");
        System.out.println(getConst("test"));
        System.out.println(getConst2("test"));

        //Method #5
        System.out.println("------ Method #5 ------");
        printBart();

        //Method #6
        System.out.println("------ Method #6 ------");
        System.out.println(isPrime(11));

        //Method #7
        System.out.println("------ Method #7 ------");
        int[] hiLo = new int[2];
        hiLo = getHiLo(test);
        System.out.println("Low: " + hiLo[0] + ", High: " + hiLo[1]);

        //Method #8
        System.out.println("------ Method #8 ------");
        ArrayList<Integer> testList = new ArrayList<Integer>();
        testList = numList(100, 2, 25);
        System.out.println(testList);
        System.out.println(testList.size());

        //Method #9
        System.out.println("------ Method #9 ------");
        int[] arrNine = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        revArray(arrNine);
        for (int i = 0; i < arrNine.length; i++) {
            System.out.print(arrNine[i] + ", ");
        }
    }

    static void passRef(testObj obj){
        obj.name = "Changed Inside Method";
    }

    static void passVal(int x, int y){
        x *= 45;
        y *= 65;
        System.out.println("Inside passVal, x now equals " + x);
        System.out.println("Inside passVal, y now equals " + y);

    }

    static int[] revArray(int[] arr) {
        int t = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
        return arr;
    }

    static ArrayList numList(int maxNum, int divisor1, int divisor2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= maxNum; i++) {
            if (i % divisor1 == 0 && i % divisor2 == 0) {
                result.add(i);
            }
        }
        return result;
    }

    static boolean isPrime(int x) {
        int y = 2;
        while (y < x) {
            if (x % y == 0) {
                return false;
            } else {
                y++;
            }
        }
        return true;
    }

    static int[] getHiLo(int[] arr) {
        int h = 0;
        int l = 0;
        int[] m = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > h) {
                h = arr[i];
            }
        }
        l = h;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < l) {
                l = arr[i];
            }
        }
        m[0] = l;
        m[1] = h;
        return m;
    }

    static int getLargeArr(int[] arr) {
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    static double getLargeArr(double[] arr) {
        double m = 0.0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    static int getLarge(int a, int b, int c, int d) {
        int m = a;
        if (b > m) {
            m = b;
        }
        if (c > m) {
            m = c;
        }
        if (d > m) {
            m = d;
        }
        return m;
    }

    static int getConst(String s) {
        String c = "bcdfghjklmnpqrstvwxyzBCDGHJKLMNPQRSTFWXYZ";
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int x = 0; x < c.length(); x++) {
                if (s.charAt(i) == c.charAt(x)) {
                    result++;
                }
            }
        }
        return result;
    }

    static int getConst2(String s) {
        String v = "aeiouAEIOU";
        int result = s.length();
        for (int i = 0; i < s.length(); i++) {
            for (int x = 0; x < v.length(); x++) {
                if (s.charAt(i) == v.charAt(x)) {
                    result--;
                }
            }
        }
        return result;
    }

    static void printBart() {
        System.out.println(" |\\/\\/\\/|");
        System.out.println(" |      |");
        System.out.println(" | (o)(o)");
        System.out.println(" C      _) ");
        System.out.println("  | ,___|");
        System.out.println("  |   /");
        System.out.println(" /____\\ ");
        System.out.println("/      \\");

    }

    static class testObj {
        String name;
        int size;
        public testObj(String name, int size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public String toString() {
            return "testObj{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }

}
