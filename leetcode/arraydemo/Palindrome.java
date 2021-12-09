package leetcode.arraydemo;

/**
 * @ClassName Palindrome
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 * 输入: 121
 * 输出: true
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:你能不将整数转为字符串来解决这个问题吗？
 * @Author VzivZ
 * @Date 2019/2/20 13:44
 */
public class Palindrome {
	public static boolean isPalindrome(int x) {
		String reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString();
		return reverseNumber.equals(String.valueOf(x));
	}
	public static boolean isPalindrome02(int x) {
		int a = x, h = 1;

		if (a < 0) return false;

		while (a / h >= 10) {
			h = h * 10;
		}

		while (a > 0) {
			if (a / h != a % 10) return false;
			a = a % h;
			a = a / 10;
			h = h / 100;
		}

		return true;
	}

	public static void main(String[] args) {
		int a = 10;
		System.out.println(isPalindrome02(a));
	}
}
