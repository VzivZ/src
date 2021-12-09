package leetcode.dict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DictDemo01
 * @Description
 * @Author HeZhe
 * @Date 2018/9/12 10:44
 */
public class DictDemo01 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0){
            int [] a = new int[]{};
            return a;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> a = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                a.add(nums1[i]);
                i++;
                j++;
            }
        }
        if(a.size()==0){
            return new int[]{};
        }
        int [] ans = new int[a.size()];
        int k = 0;
        for(Integer val : a){
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
