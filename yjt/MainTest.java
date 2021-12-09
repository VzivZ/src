package yjt;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: f
 * @Author VzivZ
 * @Date 2021/3/4 9:38
 */
public class MainTest {
    public static void main(String[] args) {
        Demo004<String> demo004 = new Demo004<>("aaa");
        demo004.show(888);
        demo004.show("asa00000");
        demo004.showSize(0.000001d);
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("sss");
        Map<Integer,List<String>> map = new ConcurrentHashMap<>();
        map.put(1,list);
        System.out.println(map.get(1));
    }
}
