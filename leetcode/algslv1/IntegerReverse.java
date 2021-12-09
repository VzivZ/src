package leetcode.algslv1;

/**
 * @ClassName IntegerReverse
 * @Description 颠倒整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * @Author VzivZ
 * @Date 2018/11/15 13:40
 */
public class IntegerReverse {
	public static int reverse(int x) {
		String resStr = "";
		int x_abs = Math.abs(x);
		while (x_abs > 0) {
			int tmp = x_abs % 10;
			x_abs = x_abs / 10;
			resStr += tmp;
		}
		try {
			int res = Integer.parseInt(resStr);
			return x < 0 ? -res : res;
		} catch (Exception e) {
			return 0;
		}
	}

	public static int reverse2(int x) {
		int res = 0;
		while (x != 0) {
			int tmp = x % 10 + res * 10;
			// 因为都是用int型的，如果超出了范围，其除以10的结果就不会跟之前的结果一致，通过这点也可以进行区分
			if (tmp / 10 != res) {
				return 0;
			}
			res = tmp;
			x = x / 10;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(reverse2(-123));
	}
}
