package leetcode.queue;

/**
 * @ClassName MyCircularQueue
 * @Description 设计循环队列
 * 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * @Author VzivZ
 * @Date 2019/1/29 11:14
 */
public class MyCircularQueue {
	private int[] data;
	private int head;
	private int tail;
	private int size;

	public MyCircularQueue(int k) {
		data = new int[k];
		head = -1;
		tail = -1;
		size = k;
	}

	public boolean enQueue(int value) {
		if (isFull()) return false;
		if (isEmpty()) head = 0;
		tail = (tail + 1) % size;
		data[tail] = value;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) return false;
		if (head == tail) {
			head = -1;
			tail = -1;
			return true;
		}
		head = (head + 1) % size;
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		if (isEmpty()) {
			return -1;
		}
		return data[head];
	}

	/**
	 * Get the last item from the queue.
	 */
	public int Rear() {
		if (isEmpty()) {
			return -1;
		}
		return data[tail];
	}

	public boolean isEmpty() {
		return head == -1;
	}

	public boolean isFull() {
		return ((tail + 1) % size) == head;
	}
}
