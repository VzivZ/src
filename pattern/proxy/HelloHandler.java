package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-04-20 18:14
 **/
public class HelloHandler implements InvocationHandler {
    // 目标对象

    private Object target;

    HelloHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("先洗手\n------------------------------\n");
        Object result = method.invoke(target, args);
        System.out.println("\n------------------------------\n吃完了");
        return result;
    }


    /**
     * 获取目标对象的代理对象
     * @return 代理对象
     */
    Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }

}
