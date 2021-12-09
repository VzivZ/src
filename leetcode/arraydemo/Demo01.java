package leetcode.arraydemo;

/**
 * @ClassName Demo01
 * @Description
 * @Author VzivZ
 * @Date 2018/9/12 16:26
 */
public class Demo01 {
    public static boolean isOneBitCharacter(int[] bits) {
        int n =0;
        while (n<bits.length-1){
            if(bits[n]==0){
                n++;
            }else if(bits[n]==1){
                n=n+2;
            }
        }
        if(n==bits.length-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] b = {1,1,0};
       boolean a = isOneBitCharacter(b);
        System.out.println(a);
    }
}
