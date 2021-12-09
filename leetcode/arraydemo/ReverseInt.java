package leetcode.arraydemo;

/**
 * @ClassName ReverseInt
 * @Description
 * @Author HeZhe
 * @Date 2018/9/20 10:09
 */
public class ReverseInt {
	public static int reverse(int x) {
		int n = x;
		int reversed_n = 0;

		while (n != 0) {
			int temp = reversed_n * 10 + n % 10;
			n = n / 10;
			if (temp / 10 != reversed_n) {
				reversed_n = 0;
				break;
			}
			reversed_n = temp;
		}
		return reversed_n;

	}

	public static void main(String[] args) {
		int a = 120;
		int b = reverse(a);
		System.out.println(b);
	}
}
