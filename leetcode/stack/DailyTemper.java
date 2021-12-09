package leetcode.stack;

//import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName DailyTemper
 * @Description 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * @Author HeZhe
 * @Date 2019/1/29 13:20
 */
public class DailyTemper {
	public static int[] dailyTemperatures2(int[] T) {
		int[] res = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			for (int j = i + 1; j < T.length; j++) {
				if (T[j] > T[i]) {
					res[i] = j - i;
					break;
				}
			}
		}
		return res;
	}

	public int[] dailyTemperatures(int[] T) {
		Stack<Entry> stack = new Stack<>();
		int[] res = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			if (stack.isEmpty()) {
				stack.push(new Entry(T[i], i));
				continue;
			}
			if (T[i] <= stack.peek().val) {
				stack.push(new Entry(T[i], i));
			} else {
				while (!stack.empty() && (T[i] > stack.peek().val)) {
					Entry tmp = stack.pop();
					res[tmp.index] = i - tmp.index;
				}
				stack.push(new Entry(T[i], i));
			}
		}
		return res;
	}

	private class Entry {
		public int val;
		public int index;

		public Entry(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}

//	@Test
//	public void test() {
//		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//		dailyTemperatures(temperatures);
//	}

	public static void main(String[] args) {
		int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
		dailyTemperatures2(temperatures);
	}
}
