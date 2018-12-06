package com.chapter;

import com.chapter.generics.lib.LinkedArray;
import com.chapter.generics.lib.LinkedQueue;
import com.chapter.generics.lib.LinkedStack;
import org.junit.jupiter.api.Test;

public class MyTest {

    private final static String NAME = "zhangsan";
    private final static A a = new A();

    public void fun(A a) {
        a.fun1();
    }

    @Test
    public void fun() {
        class A {
            {
                System.out.println("A {}");
            }

            A() {
                System.out.println("A ()");
            }
        }
/*        a.name = NAME;
        A a1 = new A();

        C c = new C();

        B b = new B();
        fun(b);*/
        A a = new A();

    }

    @Test
    public void testList() throws Exception{
        LinkedArray<String> array = new LinkedArray<>();
        for (int i = 0; i < 10; i++) {
            array.add(i + "");
        }

        array.getClass().getDeclaredMethod("add",Object.class).invoke(array,new Object());
        System.out.println(array.size());
        Object o = array.getClass().getDeclaredMethod("get",int.class).invoke(array,10);
        System.out.println(o);
        System.out.println(array.getClass().getDeclaredMethod("get",int.class));
        /*
        array.forEach(string-> System.out.println(string));

        LinkedStack<String> stack = new LinkedStack<>();
        for(int i = 0;i<10;i++){
            stack.push(i+"");
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        LinkedQueue<String> queue = new LinkedQueue<>();
        for(int i = 0;i<10;i++){
            queue.enterQueue(i+"");
        }
        while (!queue.isEmpty()){
            System.out.println(queue.peekQueue());
        }*/
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

    public void fun1() {
        System.out.println("A fun1");
    }
}

class B extends A {

    /*    public final void fun(){

        }*/
    public B() {
        System.out.println("B constructor");
    }

    public void fun1() {
        System.out.println("B fun1");
    }
}

class C extends B {
    public C() {
        System.out.println("C constructor");
    }
}
