package demo001;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: VzivZ
 * @date: 2019-10-29 16:16
 **/
public class BoolenTest {
    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

        items.keySet().removeIf(key -> !key.equals("A"));
    }

}
