package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-04-20 18:14
 **/
public class HelloHandler implements InvocationHandler {
    // Ŀ�����

    private Object target;

    HelloHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("��ϴ��\n------------------------------\n");
        Object result = method.invoke(target, args);
        System.out.println("\n------------------------------\n������");
        return result;
    }


    /**
     * ��ȡĿ�����Ĵ������
     * @return �������
     */
    Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}
