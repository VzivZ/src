package leetcode.interview.no0101;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * @author: VzivZ
 * @date: 2020-08-11 09:57
 **/
public class Solution {
    //最简单的方式
    public static boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            set.add(c);
        }
        return set.size() == astr.length();
    }

    public static boolean isUnique02(String astr) {
        return astr.chars().distinct().count() == astr.length();
    }


    public static void main(String[] args) {
        System.out.println(isUnique02("god"));
//        System.out.println(isUnique02("good"));

    }
}
