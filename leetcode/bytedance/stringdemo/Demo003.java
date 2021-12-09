package leetcode.bytedance.stringdemo;

/**
 * @ClassName Demo003
 * @Description 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * @Author HeZhe
 * @Date 2018/12/14 14:56
 */
public class Demo003 {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) return "0";
		int len1 = num1.length();
		int len2 = num2.length();
		int product, carry, i, j;
		int[] num = new int[len1 + len2];
		for (i = len1 - 1; i >= 0; i--) {
			carry = 0;
			for (j = len2 - 1; j >= 0; j--) {
				product = carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + num[i + j + 1];
				num[i + j + 1] = product % 10;
				carry = product / 10;
			}
			num[i + j + 1] = carry;
		}
		i = 0;
		while (i < len1 + len2 && num[i] == 0) {
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while (i < len1 + len2) {
			sb.append(num[i]);
			i++;
		}

		return sb.toString();
	}
}
