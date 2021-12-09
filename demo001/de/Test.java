package demo001.de;

import java.math.BigDecimal;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-05 10:23
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(getGrowthRate(1,2));
    }

    private static double getGrowthRate(double val1, double val2) {
        if(val2 == 0) return 0.0;
        return keepXiaoShuUpNumber(sub(val1, val2) / val2 * 100, 2);
    }

    private static double keepXiaoShuUpNumber(double data, int newScale) {
        //使用参数为float或double的BigDecimal创建对象会丢失精度,所以要用字符串 modify by hez
        //四舍五入
        return new BigDecimal(String.valueOf(data)).setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    //两个Double数相减
    private static Double sub(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
    }
}
