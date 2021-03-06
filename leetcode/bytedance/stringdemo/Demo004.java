package leetcode.bytedance.stringdemo;

/**
 * @ClassName Demo004
 * @Description 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * <p>
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 说明:
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 * @Author VzivZ
 * @Date 2018/12/14 15:08
 */
public class Demo004 {
	public static String reverseWords(String s) {
		String[] items = s.trim().split(" +");
		StringBuffer ans = new StringBuffer();
		for (int i = items.length - 1; i >= 0; i--) {
			ans.append(items[i] + " ");
		}
		return ans.toString().trim();
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
}
