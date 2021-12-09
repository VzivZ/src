package pattern.proxy;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-04-20 18:15
 **/
public class Demo {
    public static void main(String[] args) {
        HelloDao helloDao = new HelloDapImpl() ;
        // ʵ����InvocationHandler
        HelloHandler invocationHandler = new HelloHandler(helloDao);

        // ����Ŀ��������ɴ������
        HelloDao proxy = (HelloDao) invocationHandler.getProxy();

        // ���ô������ķ���
        proxy.eat();
    }
}
