package leetcode.tencent.stringorarray;

import java.math.BigInteger;

/**
 * @ClassName Mutiny
 * @Description 字符串相乘
 * @Author HeZhe
 * @Date 2018/10/30 16:13
 */
public class Mutiny {
	public static String multiply(String num1, String num2) {
		BigInteger a = new BigInteger(num1);
		BigInteger b = new BigInteger(num2);
		String c = String.valueOf(a.multiply(b));
		System.out.println(c);
		return c;
	}
	public static String multiply2(String num1, String num2){
		char[] nums1=num1.toCharArray();
		char[] nums2=num2.toCharArray();
		int n=nums1.length,m=nums2.length;
		int i,j,k;
		//一般来说两个数相乘，其最大位数也不会大于两个位数之和
		int[] result=new int[n+m];
		//转换成数字
		for( i=0;i<n;i++)
			nums1[i]-='0';
		for( i=0;i<m;i++)
			nums2[i]-='0';
		//用nums2的每一位去乘nums1 累加到result
		for( i=0;i<m;i++){
			int carry=0;
			for( j=0;j<n;j++){
				result[i+j]=result[i+j]+nums2[m-1-i]*nums1[n-1-j]+carry;
				carry=result[i+j]/10;
				result[i+j]%=10;
			}
			k=i+j;
			//处理进位
			while(carry!=0){
				result[k]+=carry;
				carry=result[k]/10;
				result[k]%=10;
				k++;
			}
		}
		StringBuilder tmp=new StringBuilder(n+m);
		i=m+n-1;
		while(i>0 && result[i]==0)
			i--;
		while(i>=0)
			tmp.append(result[i--]);
		return tmp.toString();
	}

	public static void main(String[] args) {
		multiply("123","456");
	}
}
