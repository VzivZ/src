package pattern.proxy;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-04-20 18:15
 **/
public class Demo {
    public static void main(String[] args) {
        HelloDao helloDao = new HelloDapImpl() ;
        // 实例化InvocationHandler
        HelloHandler invocationHandler = new HelloHandler(helloDao);

        // 根据目标对象生成代理对象
        HelloDao proxy = (HelloDao) invocationHandler.getProxy();

        // 调用代理对象的方法
        proxy.eat();
    }
}
