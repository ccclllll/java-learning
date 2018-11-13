package com.chapter;

import org.junit.jupiter.api.Test;

public class MyTest {

    private final static String NAME = "zhangsan";
    private final static A a = new A();

    public void fun(A a){
        a.fun1();
    }
    @Test
    public void fun() {
        a.name = NAME;
        A a1 = new A();

        C c = new C();

        B b = new B();
        fun(b);
    }
}

class A {
    String name;

    public final void fun() {
        System.out.println("A fun()");
    }

    public A() {
        System.out.println("A constructor");
    }

    public void fun1(){
        System.out.println("A fun1");
    }
}

class B extends A {

    /*    public final void fun(){

        }*/
    public B() {
        System.out.println("B constructor");
    }

    public void fun1(){
        System.out.println("B fun1");
    }
}

class C extends B {
    public C() {
        System.out.println("C constructor");
    }
}
