package leetcode.algslv1;

import java.util.Arrays;

/**
 * @ClassName SameChar
 * @Description 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @Author HeZhe
 * @Date 2018/11/15 16:23
 */
public class SameChar {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		String[] sChar = s.split("");
		String[] tChar = t.split("");
		Arrays.sort(sChar);
		Arrays.sort(tChar);
		for (int i = 0; i < sChar.length; i++) {
			if (!sChar[i].equals(tChar[i])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "anagram@", t = "nagaram@";
		System.out.println(isAnagram(s, t));
	}
}
