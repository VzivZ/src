package leetcode.map;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        for (Map.Entry<String, Integer> item : map.entrySet()){
            System.out.println(item.getKey());
        }
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> item = it.next();
            it.remove();
        }
        for (Map.Entry<String, Integer> item : map.entrySet()){
            System.out.println(item.getKey());
            System.out.println("aaa");
        }
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream() // 创建流
                .filter(s -> s.startsWith("c")) // 执行过滤，过滤出以 c 为前缀的字符串
                .map(String::toUpperCase) // 转换成大写
                .sorted() // 排序
                .forEach(System.out::println); // for 循环打印
        List<String> aaa =  myList.stream().sorted().collect(Collectors.toList());
        for (String s : aaa) {
            System.out.print(s+",");
        }
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        String result = String.join(",", list);
        System.out.println(result);
    }
}
