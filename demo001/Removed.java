package demo001;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-03-05 15:11
 **/
public class Removed {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("key1",1);
        hashMap.put("key2",2);
        hashMap.put("key3",3);
        hashMap.put("key4",4);
        hashMap.put("key5",5);
        hashMap.put("key6",6);

        Iterator<Map.Entry<String, Integer>> iterator  = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getKey().contains("3")){
                iterator.remove();
            }
            System.out.println("当前HashMap是"+hashMap+" 当前entry是"+entry);
        }

    }
}
