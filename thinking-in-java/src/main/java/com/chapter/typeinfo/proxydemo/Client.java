package com.chapter.typeinfo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        Buyer buyerProxy = (Buyer) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Buyer.class}, new InvocationHandler() {
            Object proxied = (Buyer) word -> System.out.println("buyer says:"+word);
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy = [" + proxy.getClass().getCanonicalName() + "], method = [" + method + "], args = [" + args + "]");
                return method.invoke(proxied,args);
            }
        });
        buyerProxy.talk("hhhhhhh");
    }

}
