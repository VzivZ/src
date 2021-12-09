package yjt;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/2/24 16:07
 */
public class Demo003 {
    public static void main(String[] args) {
        System.out.println(aaa(20210223101551L));
    }
    private static int aaa(long payTime){
        return  (int)(payTime / 1000000);
    }
}
