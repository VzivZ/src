package leetcode.dict;

import java.util.Arrays;

/**
 * @ClassName DictDemo02
 * @Description
 * @Author VzivZ
 * @Date 2018/9/12 13:47
 */
public class DictDemo02 {
    public static boolean isAnagram(String s, String t) {
        String [] a = s.split("");
        String [] b = t.split("");
        if(a.length!=b.length){
            return false;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0;i<a.length;i++){
            if(!a[i].equals(b[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "asdfghjkl";
        String t = "lkjhgfdsa";
        boolean a = isAnagram(s,t);
        System.out.println(a);
    }
}
