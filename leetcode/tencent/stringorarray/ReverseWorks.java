package leetcode.tencent.stringorarray;

/**
 * @ClassName ReverseWorks
 * @Description
 * @Author HeZhe
 * @Date 2018/10/31 15:58
 */
public class ReverseWorks {
	public static String reverseWords(String s) {
		String[] a = s.split(" ");
		String tmp = "";
		for(int i = 0;i<a.length;i++){
			tmp += new StringBuilder(a[i]).reverse().toString()+" ";
		}
		return tmp.trim();
	}

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
}
