package leetcode.arraydemo;

/**
 * @ClassName MatchDemo
 * @Description
 * @Author VzivZ
 * @Date 2018/9/20 15:26
 */
public class MatchDemo {
	public static int strStr(String haystack, String needle) {
		if("".equals(needle)){
			return 0;
		}
		if(haystack.equals(needle)){
			return 0;
		}
		int n = needle.length();
		for(int i = 0;i<haystack.length();i++){
			String str;
			if(i+n<haystack.length()){
				str = haystack.substring(i,i+n);
			}else {
				str = haystack.substring(i);
			}
			if(str.equals(needle)){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a = strStr("hello","ll");
		System.out.println(a);
	}
}
