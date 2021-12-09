package leetcode.tencent.stringorarray;

/**
 * @ClassName Median
 * @Description
 * @Author HeZhe
 * @Date 2018/10/9 8:48
 */
public class Median {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0.0d;
		int[] nums = new int[nums1.length+nums2.length];
		int num1index = 0;
		int num2index = 0;
		int index = 0;
		if (nums1.length == 0 && nums2.length == 0){
			return result;
		}
		if (nums1.length == 0){
			return getResult(nums2);
		}
		if (nums2.length == 0){
			return getResult(nums1);
		}
		while(num1index < nums1.length && num2index < nums2.length){
			if (nums1[num1index] < nums2[num2index]){
				nums[index]= nums1[num1index];
				num1index++;
			}else{
				nums[index]= nums2[num2index];
				num2index++;
			}
			index++;
		}

		while (num1index < nums1.length){
			nums[index] = nums1[num1index++];
			index++;
		}

		while (num2index < nums2.length){
			nums[index] = nums2[num2index++];
			index++;
		}
		result = getResult(nums);
		return result;
	}

	private double getResult(int[] nums){
		double result;
		if (nums.length%2==0)
		{
			result = (nums[nums.length/2]+nums[nums.length/2-1])/2.0;
		}
		else{
			result = nums[nums.length/2];
		}
		return result;
	}
}

