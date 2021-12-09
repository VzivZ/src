package leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Demo04
 * @Description 快乐数
 * @Author HeZhe
 * @Date 2018/9/11 16:25
 */
public class Demo04 {
    public static boolean isHappy(int n) {
        Set<Integer> ss = new HashSet<>();
        while (true){
            if(n==1){
                return true;
            }
            int total = 0;
            while (n>=1){
                total += (n%10)*(n%10);
                n = n/10;
            }
            if(ss.contains(total)){
                return false;
            }
            ss.add(total);
            n=total;
        }
    }

    public static void main(String[] args) {
        boolean a = isHappy(19);
        System.out.println(a);
    }
}
