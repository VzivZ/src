package leetcode.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 类测试
 * @author: VzivZ
 * @date: 2019-07-01 11:48
 **/
public class Transaction {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Map<Integer,String> treeMap = new TreeMap<>();
        Map<Integer,String> hashMap = new HashMap<>();
        treeMap.put(200,"c2");
        treeMap.put(100,"a1");
        treeMap.put(300,"c1");

        hashMap.put(200,"c2");
        hashMap.put(100,"a1");
        hashMap.put(300,"c1");
        System.out.println("treeMap");
        for(Map.Entry<Integer,String> entry : treeMap.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println("hashMap");
        for(Map.Entry<Integer,String> entry : hashMap.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println(1<<3);
    }
}
