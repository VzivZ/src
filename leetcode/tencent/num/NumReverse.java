package leetcode.tencent.num;

/**
 * @ClassName NumReverse
 * @Description
 * @Author HeZhe
 * @Date 2018/11/12 13:53
 */
public class NumReverse {
	public static int reverse(int x) {
		int int_max = Integer.MAX_VALUE;
		int int_min = Integer.MIN_VALUE;
        int anwser = 0;
		while(x!=0)
		{
			anwser=anwser*10+(x%10);
			x/=10;
		}
		if(anwser<int_min || anwser>int_max)
		{
			anwser=0;
		}
		return anwser;
	}

	public static void main(String[] args) {
		System.out.println(reverse(755));
	}
}
