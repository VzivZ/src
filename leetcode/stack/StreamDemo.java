package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 流
 * @author: HeZhe
 * @date: 2019-07-18 16:30
 **/
public class StreamDemo {
    public static void main(String[] args) {
        String aaa2 = "efficiency-0";
        System.out.println(underscoreName(aaa2));
        String aaa = "cooooool";
        String[] bbb = aaa.split("_");
        for (String s : bbb) {
            System.out.println(s);
        }
    }
    private static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toLowerCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0)) && !"-".equals(s)) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toLowerCase());
            }
        }
        return result.toString();
    }
}
