package com.chapter.typeinfo.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BuyerProxyHandler implements InvocationHandler {
    private Object proxied;
    public BuyerProxyHandler(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("buy")){
            System.out.println("do buy method");
        }
        return method.invoke(proxied,args);
    }
}
