package leetcode.algslv1;

/**
 * @ClassName NumberPlusOne
 * @Description 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * @Author VzivZ
 * @Date 2018/11/15 9:17
 */
public class NumberPlusOne {
	/**
	 * 丑陋的代码
	 *
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		int up = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + up;
			if (sum < 10) {
				up = 0;
			} else {
				up = 1;
				sum = sum % 10;
			}
			digits[i] = sum;
		}
		if (up == 1) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}

		return digits;
	}

	/**
	 * 较为优雅的代码
	 *
	 * @param digits
	 * @return
	 */
	public static int[] plusOne2(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int tmp = digits[i] + carry;
			carry = tmp / 10;
			tmp = tmp % 10;
			digits[i] = tmp;
		}
		if (carry != 0) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits = {1, 2, 3};
		plusOne(digits);
	}
}
