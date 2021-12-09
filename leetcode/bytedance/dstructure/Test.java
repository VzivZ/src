package leetcode.bytedance.dstructure;

/**
 * @ClassName Test
 * @Description
 * @Author HeZhe
 * @Date 2019/1/29 9:36
 */
public class Test {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		int a = minStack.getMin();
		System.out.println(a);

		minStack.pop();

		int b = minStack.top();
		System.out.println(b);

		int c = minStack.getMin();
		System.out.println(c);
	}
}
