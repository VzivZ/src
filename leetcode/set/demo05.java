package leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName demo05
 * @Description 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 * @Author HeZhe
 * @Date 2018/9/12 9:34
 */
public class demo05 {
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length<2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()<nums.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] a = {1,1,1,3,3,4,3,2,4,2};
        boolean b =containsDuplicate(a);
        System.out.println(b);
    }
}
