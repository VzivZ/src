package leetcode.algslv1;

/**
 * @ClassName StrIndex
 * @Description 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @Author VzivZ
 * @Date 2018/11/16 9:13
 */
public class StrIndex {
	/**
	 * 循环遍历
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		if (needle == null || "".equals(needle)) {
			return 0;
		}
		int jump = needle.length();
		int hLen = haystack.length();
		int len = hLen - jump;
		for (int i = 0; i <= len; i++) {
			String tmp = haystack.substring(i, i + jump);
			if (needle.equals(tmp)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 这™也可以？！！！
	 *
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr2(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static void main(String[] args) {
		String haystack = "hello", needle = "lo";
		System.out.println(strStr(haystack, needle));
	}
}
