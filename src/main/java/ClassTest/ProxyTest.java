package ClassTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    static int i;
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before connect");

                System.out.println(proxy.getClass().getName());
                return method.invoke(service,args);
            };

        };
        Class<?> serviceImplClass = ServiceImpl.class;
        Service proxyService = (Service) Proxy.newProxyInstance
                (serviceImplClass.getClassLoader(),
                serviceImplClass.getInterfaces(), invocationHandler);
        proxyService.connectDB();
        proxyService.dealRequest();
    }
}
