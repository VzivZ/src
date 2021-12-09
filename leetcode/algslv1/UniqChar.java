package leetcode.algslv1;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UniqChar
 * @Description 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 * @Author HeZhe
 * @Date 2018/11/15 14:32
 */
public class UniqChar {
	public static int firstUniqChar(String s) {
		if (s.length() == 1) {
			return 0;
		}
		for (int i = 0; i < s.length(); i++) {
			Set<Character> set = new HashSet<>();
			for (int j = i + 1; j < s.length(); j++) {
				Character c = s.charAt(j);
				set.add(c);
			}
			boolean isOK = set.size() > 0 && !set.contains(s.charAt(i));
			if (isOK) {
				return i;
			}
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		if (s == "" || s == null)
			return -1;
		int[] record = new int[26];
		char[] ch = s.toCharArray();
		for (char c : ch) {
			record[c - 'a']++;
		}
		for (int i = 0; i < ch.length; i++) {
			if (record[ch[i] - 'a'] == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar2(s));
	}
}
