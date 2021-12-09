package leetcode.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Demo02
 * @Description 元素均不一致的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author VzivZ
 * @Date 2018/9/11 14:27
 */
public class Demo02 {
	//时间复杂度O(n³)，超时
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}
		return true;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		if (n == 0) return 0;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= res[i - 1]; j++) {
				if (s.charAt(i - j) == s.charAt(i)) {
					res[i] = j;
				}
			}
			if (res[i] == 0) {
				res[i] = res[i - 1] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < res[i]) {
				max = res[i];
			}
		}

		return max;
	}

	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		int res = 0;
		int end = 0, start = 0;
		Set<Character> set = new HashSet<>();
		while (start < n && end < n) {
			if (set.contains(s.charAt(end))) {
				set.remove(s.charAt(start));
				start++;
			} else {
				set.add(s.charAt(end));
				end++;
				res = Math.max(res, end - start);
			}

		}
		return res;
	}


	public static void main(String[] args) {
		int a = lengthOfLongestSubstring3("abcabcbb");
		System.out.println(a);
	}
}
