package com.jackxue.proxy;

/**
 * 导入依赖
 *          <dependency>
         *   <groupId>cglib</groupId>
         *   <artifactId>cglib</artifactId>
         *   <version>3.3.0</version>
         * </dependency>
 *
 *
 */
public class CglibProxy {
    public static void main(String[] args) {
/*        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");*/
    }
}


class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

/*
public class DebugMethodInterceptor implements MethodInterceptor {

    */
/**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     *//*

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;
    }

}*/

/*public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}*/
