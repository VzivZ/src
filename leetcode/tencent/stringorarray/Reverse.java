package leetcode.tencent.stringorarray;

/**
 * @ClassName Reverse
 * @Description 反转字符串
 * @Author VzivZ
 * @Date 2018/10/31 10:07
 */
public class Reverse {
	public static String reverseString(String s) {
		String res =  new StringBuffer(s).reverse().toString();
		String res2 = new StringBuilder(s).reverse().toString();
		return res;
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(reverseString(s));
	}
}
