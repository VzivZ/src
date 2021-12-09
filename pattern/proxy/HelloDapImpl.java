package pattern.proxy;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-04-20 18:13
 **/
public class HelloDapImpl implements HelloDao{
    @Override
    public void eat() {
        System.out.println("eat");
    }
}
