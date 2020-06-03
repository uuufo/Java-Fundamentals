package labs_examples.objects_classes_methods.labs.methods;

public class MethodTraining {

    public static void main(String[] args) {
        int[] test = {1, 4, 568, 400, 8, 15, 567};
        double[] test2 = {3.45, 1.2, 40.5, 32.9};
        System.out.println(getLarge(test));
        System.out.println(getLarge(test2));

        System.out.println(getConst("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        printBart();

        System.out.println(isPrime(2));
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

    static int getLarge(int[] arr) {
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    static double getLarge(double[] arr) {
        double m = 0.0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    static String getConst(String s) {
        String c = "bcdfghjklmnpqrstvwxyzBCDGHJKLMNPQRSTFWXYZ";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int x = 0; x < c.length(); x++) {
                if (s.charAt(i) == c.charAt(x)) {
                    result += s.charAt(i);
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
