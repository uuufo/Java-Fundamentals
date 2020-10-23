package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Map;

public class RyanDemo {

    public static void main(String[] args) {
        String[] values = new String[10];
        HashMap<String, Integer> cityPop = new HashMap<>();
        cityPop.put("Valencia", 34345);
        cityPop.put("Kings Beach", 37580);
        int valPop = cityPop.get("Valencia");
        System.out.println(valPop);
        hashdemo("Jared");
    }

    public static void hashdemo(String s) {
        String[] values = new String[10];
        int hashCode = s.hashCode();
        System.out.println(hashCode);
        int index = hashCode % values.length;
        values[index] = s;
    }
}
