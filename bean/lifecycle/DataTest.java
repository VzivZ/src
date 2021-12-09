package bean.lifecycle;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-11-06 10:25
 **/
public class DataTest {
    private Data a1 = new Data();
    private final Data a2 = new Data();
    private static final Data a3 = new Data();

    public static void main(String[] args) {
        DataTest test = new DataTest();
        test.a1.i++;
        test.a1 = new Data();
        test.a2.i++;
//        test.a2 = new Data();
        test.a3.i++;
//        test.a3 = new Data();
    }
}
