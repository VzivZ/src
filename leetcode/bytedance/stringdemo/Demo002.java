package leetcode.bytedance.stringdemo;

import java.util.Arrays;

/**
 * @ClassName Demo002
 * @Description 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * @Author HeZhe
 * @Date 2018/12/14 12:54
 */
public class Demo002 {
	//dead end
	public static boolean checkInclusion(String s1, String s2) {
		if (s2.contains(s1)) return true;
		String[] ch = s1.split("");
		int count = 0;
		int[] indices = new int[ch.length];
		for (int i = 0; i < ch.length; i++) {
			if (s2.indexOf(ch[i]) != 0) {
				indices[i] = s2.indexOf(ch[i]);
				count++;
			}
		}
		if (count == 0) return false;
		Arrays.sort(indices);
		for (int i = indices.length - 1; i > 0; i--) {
			if (indices[i] - indices[i - 1] > 1) {
				return false;
			}
		}
		return true;
	}
	//滑动窗口法
	public static boolean checkInclusion2(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		int[] count = new int[128];
		if (l1 > l2)
			return false;
		for (int i = 0; i < l1; i++) {
			count[s1.charAt(i) - 'a']++;
			count[s2.charAt(i) - 'a']--;
		}
		if (allZero(count))
			return true;
		for (int i = l1; i < l2; i++) {
			count[s2.charAt(i) - 'a']--;
			count[s2.charAt(i - l1) - 'a']++;
			if (allZero(count))
				return true;
		}
		return false;
	}

	public static boolean allZero(int[] count) {
		int l = count.length;
		for (int i = 0; i < l; i++) {
			if (count[i] != 0)
				return false;
		}
		return true;
	}

	public static boolean checkInclusion3(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		int[] m1 = new int[128];
		int[] m2 = new int[128];
		for (int i = 0; i < n1; i++) {
			m1[s1.charAt(i)]++;
			m2[s2.charAt(i)]++;
		}
		if (m1 == m2) return true;
		for (int i = n1; i < n2; i++) {
			m2[s2.charAt(i)]++;
			m2[s2.charAt(i - n1)]--;
			if (m1 == m2) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";
		System.out.println(checkInclusion3(s1, s2));
	}
}
