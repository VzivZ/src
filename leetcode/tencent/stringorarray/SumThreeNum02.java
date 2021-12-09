package leetcode.tencent.stringorarray;

import java.util.Arrays;

/**
 * @ClassName SumThreeNum02
 * @Description 最接近的三数之和
 * @Author VzivZ
 * @Date 2018/10/29 10:52
 */
public class SumThreeNum02 {
	public static int threeSumClosest(int[] nums, int target) {
		int result = 0;
		Arrays.sort(nums);
		int i,j,k,sum;
		int diff = Integer.MAX_VALUE;
		for(i=0;i<nums.length-2;i++){
			j = i +1;
			k = nums.length - 1;
			while (j<k){
				sum = nums[i]+nums[j]+nums[k];
				int tempDiff = Math.abs(sum - target);
				if(tempDiff < diff){
					result = sum;
					diff = tempDiff;
				}
				if(sum < target){
					j++;
				}else if(sum > target){
					k--;
				}else {
					return sum;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = {-1,2,1,-4};
		int t = 1;
		int a = threeSumClosest(nums,t);
		System.out.println(a);
	}
}
