package com.jackxue.adapter;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AdapterTest {
    public static void main(String[] args) {
        //1.注册adapter到Dispatcher中
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.register(new HttpControllerAdapter());
        dispatcher.register(new SimpleControllerAdapter());

        //2.测试http controller
//        HttpController controller = new HttpController();

        //3.测试Simple controller
        SimpleController controller = new SimpleController();
        dispatcher.doDispatch(controller);

    }
}

//分发器
class Dispatcher{
    List<Adapter> adapterList = new ArrayList<>();

    Adapter getAdapter(Controller controller){
        for (Adapter adapter : adapterList) {
            if(adapter.support(controller)){
                return adapter;
            }
        }
        return null;
    }

    void register(Adapter adapter){
        adapterList.add(adapter);
    }

    void doDispatch(Controller controller){
        Adapter adapter = this.getAdapter(controller);
        adapter.handle(controller);
    }
}

//适配器
interface Adapter{
    boolean support(Object obj);
    void handle(Object obj);
}

// controller
interface Controller{
    void handle();
}

//httpcontroller
class HttpController implements Controller {

    @Override
    public void handle() {
        System.out.println("HTTP controller....");
    }
}

//SimpleController
class SimpleController implements Controller{

    @Override
    public void handle() {
        System.out.println("simple controller...");
    }
}

//httpcontroller adapter
class HttpControllerAdapter implements Adapter{

    @Override
    public boolean support(Object obj) {
        return obj instanceof HttpController;
    }

    @Override
    public void handle(Object obj) {
        ((HttpController)obj).handle();
    }
}

//simple controller adapter
class SimpleControllerAdapter implements Adapter{

    @Override
    public boolean support(Object obj) {
        return obj instanceof SimpleController;
    }

    @Override
    public void handle(Object obj) {
        ((SimpleController)obj).handle();
    }
}