package leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Demo03
 * @Description 两个数组中是否包含相同元素
 * @Author VzivZ
 * @Date 2018/9/11 15:14
 */
public class Demo03 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0){
            int [] a = new int[]{};
            return a;
        }
        Set<Integer> a = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            a.add(nums1[i]);
        }
        Set<Integer> temp = new HashSet<>();
        for(int i = 0;i<nums2.length;i++){
            if(a.contains(nums2[i])){
                temp.add(nums2[i]);
            }
        }
        int [] ans = new int[temp.size()];
        int k = 0;
        for(Integer val : temp){
            ans[k] = val;
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums1 = new int[]{4,9,5};
        int [] nums2 = new int[]{9,4,9,8,4};
        int [] a = intersection(nums1, nums2);
        for(int k : a){
            System.out.println(k);
        }
    }
}
