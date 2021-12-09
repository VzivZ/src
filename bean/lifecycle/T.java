package bean.lifecycle;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-11-06 15:37
 **/
public class T {
    public static T t = new T();
    public static int count = 2;

    private T() {
        count++;
    }

    public static void main(String[] args) {
        System.out.println(T.count);
    }
}
