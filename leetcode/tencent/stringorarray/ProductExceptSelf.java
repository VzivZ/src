package leetcode.tencent.stringorarray;

/**
 * @ClassName ProductExceptSelf
 * @Description 除自身以外数组的乘积
 * @Author VzivZ
 * @Date 2018/10/31 16:22
 */
public class ProductExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		int s = 1;
		int rs = 1;
		int n = nums.length;
		int[] pre = new int[n];
		int[] after = new int[n];
		int[] output = new int[n];
		for (int i = 1; i <= n - 1; i++) {
			rs = rs * nums[n - i];
			after[n - i - 1] = rs;
			s = s * nums[i - 1];
			pre[i] = s;
		}
		after[n - 1] = 1;
		pre[0] = 1;
		for (int i = 0; i <= n - 1; i++) {
			output[i] = pre[i] * after[i];
		}
		return output;
	}
	public static int[] productExceptSelf2(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		int i;
		res[len-1]=1;
		for(i=len-1;i>0;i--)
			res[i-1]=res[i]*nums[i];

		int left=1;//左边的乘积
		for(i=0;i<len;i++)
		{
			res[i]*=left;
			left=left*nums[i];
		}
		return res;
	}

	//输入: [1,2,3,4]
	//输出: [24,12,8,6]
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4};
		productExceptSelf2(a);
	}
}
