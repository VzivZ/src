package demo001;

import java.util.*;

/**
 * @description: 入参
 * @author: VzivZ
 * @date: 2019-10-16 14:25
 **/
public class Test001 {
    public static void main(String[] args) {
//        ArrayList<String> list = new ArrayList<>();
//        String val = null;
//        setVal(val);
//        writeVal(val);
        test();
    }

    public static void setVal(String val) {
        val = "dddddddddddddddddddddddddd";
        System.out.println(val);
    }

    private static void writeVal(String val) {
        System.out.println(val);
    }

    private static void test() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        map.put("1", list);
        map.forEach((k, v) -> System.out.println(v));
        map.get("1").add("2");
        map.forEach((k, v) -> System.out.println(v));
    }


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
