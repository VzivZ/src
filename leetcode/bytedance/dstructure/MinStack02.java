package leetcode.bytedance.dstructure;

/**
 * @ClassName MinStack02
 * @Description
 * @Author VzivZ
 * @Date 2019/1/29 10:00
 */
public class MinStack02 {
	private final static int DEFAULT_SIZE = 1000;
	private int[] stack;
	private int[] minIndex; // 用于保存前n个数据的栈中最小元素的下标
	private int min = Integer.MAX_VALUE; // 用于记录插入过程中的最小数据
	private int index = -1; // 记录最小元素在stack中的位置
	private int current = -1;

	public MinStack02() {
		stack = new int[DEFAULT_SIZE];
		minIndex = new int[DEFAULT_SIZE];
	}

	public MinStack02(int size) {
		stack = new int[size];
		minIndex = new int[size];
	}

	public void push(int x) {
		current++;//移动到要插入的位置
		if (current >= stack.length) {//扩容
			int[] tmp = new int[current * 2];
			System.arraycopy(stack, 0, tmp, 0, stack.length);
			stack = tmp;

			tmp = new int[current * 2];
			System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
			minIndex = tmp;
		}
		stack[current] = x; // 插入数据

		if (x < min) { // 保存插入的最小值
			min = x;
			index = current; // 记录[0, current]中最小的元素下标是index
		}

		minIndex[current] = index;
	}

	public void pop() {
		current--;
		if (current >= 0) {
			min = stack[minIndex[current]]; // 重新设置栈中的最小值
			index = minIndex[current]; // 重置最小值的索引
		}
	}

	public int top() {

		if (current < 0) {
			throw new RuntimeException("No more data");
		}

		return stack[current];
	}

	public int getMin() {
		if (current < 0) {
			throw new RuntimeException("No more data");
		}

		return stack[minIndex[current]];
	}
}
