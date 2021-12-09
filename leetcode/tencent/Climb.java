package leetcode.tencent;

/**
 * @ClassName Climb
 * @Description 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。
 * 你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @Author HeZhe
 * @Date 2018/11/2 15:49
 */
public class Climb {
	//递归方式超时
	public static int climbStairs(int n) {
		if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
	}
	public static int climbStairs2(int n) {
		int result = 0;
		// 只有一阶
		if (n == 1) {
			result = 1;
		}
		// 只有两阶
		else if (n == 2) {
			result = 2;
		}
		// 楼梯阶数大于2
		else if (n > 2) {
			// 保存所有的解法
			int[] ways = new int[n];
			ways[0] = 1;
			ways[1] = 2;
			for (int i = 2; i < ways.length; i++) {
				ways[i] = ways[i - 1] + ways[i - 2];
			}
			result = ways[ways.length - 1];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}
}
