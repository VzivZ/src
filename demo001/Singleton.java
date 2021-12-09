package demo001;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-01-03 09:52
 **/
public class Singleton {
    private Singleton(){}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
