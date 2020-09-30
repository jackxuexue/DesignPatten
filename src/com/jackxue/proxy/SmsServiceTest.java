package com.jackxue.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SmsServiceTest{
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        ProxySmsService proxySmsService = new ProxySmsService(smsService);
        SmsService instance = (SmsService) proxySmsService.getInstance();
        instance.sendMessage("hello");
        instance.sendEmail("test");
    }
}
interface SmsService  {
    void sendMessage(String message);
    void sendEmail(String message);
}

class SmsServiceImpl implements SmsService {

    @Override
    public void sendMessage(String message) {
        System.out.println("发送消息：" + message);
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("发送邮件：" + message);
    }
}

class ProxySmsService implements InvocationHandler{

    private Object taget;

    public ProxySmsService(Object taget){
        this.taget = taget;
    }

    public Object getInstance(){
        Object o = Proxy.newProxyInstance(taget.getClass().getClassLoader(), taget.getClass().getInterfaces(),
                this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " 方法执行前");
        Object o = method.invoke(taget, args);
        System.out.println(method.getName() + " 方法执行后");
        return o;
    }
}


