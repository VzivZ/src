package leetcode.map;

import java.util.Arrays;

/**
 * @ClassName StraightHand
 * @Description 爱丽丝有一手（hand）由整数数组给定的牌。
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 * 如果她可以完成分组就返回 true，否则返回 false。
 * 示例 1：
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 * 提示：
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 * @Author VzivZ
 * @Date 2019/2/20 14:19
 */
public class StraightHand {
	private static boolean isNStraightHand(int[] hand, int W) {
		int n = hand.length;
		if (n % W != 0) return false;
		Arrays.sort(hand);
		int[] vis = new int[n];
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				int cnt = 1;
				vis[i] = 1;
				int pre = hand[i];
				int j = i + 1;
				while (cnt < W) {
					if (j >= n) break;
					if (vis[j] == 0 && hand[j] == pre + 1) {
						cnt++;
						vis[j] = 1;
						pre = hand[j];
					}
					j++;
				}
				if (cnt != W) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
		int W = 3;
		System.out.println(isNStraightHand(hand, W));
	}
}
