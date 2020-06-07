package labs_examples.objects_classes_methods.labs.methods;

public class MethodTraining {

    public static void main(String[] args) {

        int[] test = {1, 4, 568, 400, 8, 15, 567};
        double[] test2 = {3.45, 1.2, 40.5, 32.9};
        System.out.println(getLargeArr(test));
        System.out.println(getLargeArr(test2));

        System.out.println(getLarge(3769, 645, 6345, 874));

        int[] hiLo = new int[2];
        hiLo = getHiLo(test);
        System.out.println("Low: " + hiLo[0] + ", High: " + hiLo[1]);

        System.out.println(getConst("test"));
        System.out.println(getConst2("test"));

        printBart();

        System.out.println(isPrime(11));
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

}
