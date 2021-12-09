package leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MyQueue
 * @Description
 * @Author VzivZ
 * @Date 2019/1/29 10:53
 */
public class MyQueue {
	private List<Integer> data;
	private int p_start;

	public MyQueue() {
		data = new ArrayList<>();
		p_start = 0;
	}

	public boolean enQueue(int x) {
		data.add(x);
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}
		p_start++;
		return true;
	}

	public int Front() {
		return data.get(p_start);
	}

	public boolean isEmpty() {
		return p_start >= data.size();
	}
}

