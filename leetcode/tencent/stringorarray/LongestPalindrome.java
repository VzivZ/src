package leetcode.tencent.stringorarray;

/**
 * @ClassName LongestPalindrome
 * @Description
 * @Author HeZhe
 * @Date 2018/10/9 11:06
 */
public class LongestPalindrome {
	private int max = 0;
	private String res = "";
	public String longestPalindrome(String s){
		if(s.length()==1){
			return s;
		}
		for(int i = 0;i<s.length();i++){
			checkPalindromeExpand(s,i,i);
			checkPalindromeExpand(s,i,i+1);
		}
		return res;
	}
	private void checkPalindromeExpand(String s,int low,int high){
		while (low >=0&&high < s.length()){
			if(s.charAt(low)==s.charAt(high)){
				if(high - low + 1 > max){
					max = high - low + 1;
					res = s.substring(low,high+1);
				}
				low--;
				high++;
			}else {
				return;
			}
		}
	}
}
