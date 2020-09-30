package com.jackxue.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        ITeacher teacher = new Teacher();
        ProxyFactory proxyFactory = new ProxyFactory(teacher);
        ITeacher o = (ITeacher)proxyFactory.getProxyIntance();

        o.teach();

    }
}

interface ITeacher{
    void teach();
}

class Teacher implements ITeacher{

    @Override
    public void teach() {
        System.out.println("老师授课中");
    }
}

class ProxyFactory{
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyIntance(){
        /**
         *
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("方法执行前！");
                        Object ret = method.invoke(target, args);
                        System.out.println("方法执行后！");
                        return null;
                    }
                });
    }
}
