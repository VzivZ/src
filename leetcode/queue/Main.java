package leetcode.queue;

/**
 * @ClassName Main
 * @Description
 * @Author HeZhe
 * @Date 2019/1/29 11:00
 */
public class Main {
	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enQueue(5);
		q.enQueue(3);
		if (!q.isEmpty()) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (!q.isEmpty()) {
			System.out.println(q.Front());
		}
		q.deQueue();
		if (!q.isEmpty()) {
			System.out.println(q.Front());
		}
	}
}