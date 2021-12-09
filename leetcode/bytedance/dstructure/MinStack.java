package leetcode.bytedance.dstructure;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @Author VzivZ
 * @Date 2019/1/29 8:59
 */
public class MinStack {
	Stack<Integer> s1;
	Stack<Integer> s2;

	public MinStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void push(int x) {
		s1.push(x);
		if (s2.empty() || x <= getMin()) {
			s2.push(x);
		}
	}

	public void pop() {
		if (s1.pop() == getMin()) {
			s2.pop();
		}
	}

	public int top() {
		return s1.peek();
	}

	public int getMin() {
		return s2.peek();
	}
}
