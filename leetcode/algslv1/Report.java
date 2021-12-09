package leetcode.algslv1;

/**
 * @ClassName Report
 * @Description 报数
 * 报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 * @Author VzivZ
 * @Date 2018/11/16 9:37
 */
public class Report {
	public static String countAndSay(int n) {
		String oldString = "1";
		while (--n > 0) {
			StringBuilder sb = new StringBuilder();
			char[] oldChars = oldString.toCharArray();
			for (int i = 0; i < oldChars.length; i++) {
				int count = 1;
				while ((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]) {
					count++;
					i++;
				}
				sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
			}
			oldString = sb.toString();
		}
		return oldString;
	}

	public static void main(String[] args) {
		String a = countAndSay(4);
		System.out.println(a);
	}
}
