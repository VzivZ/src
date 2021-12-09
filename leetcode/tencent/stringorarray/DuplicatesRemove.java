package leetcode.tencent.stringorarray;

/**
 * @ClassName DuplicatesRemove
 * @Description 删除排序数组中的重复项
 * @Author VzivZ
 * @Date 2018/10/29 16:00
 */
public class DuplicatesRemove {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int j = 0;
		for (int i=0; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				nums[++j] = nums[i];
			}
		}
		return j+1;
	}

	public static void main(String[] args) {
		int [] nums =  {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
}
