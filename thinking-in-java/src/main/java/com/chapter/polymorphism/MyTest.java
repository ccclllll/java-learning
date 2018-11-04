package com.chapter.polymorphism;

import org.junit.jupiter.api.Test;

import java.util.Random;

class A{
    public static void fun(){
        System.out.println("A fun");
    }
    public A(int i){

    }
}
interface In{

}
class B extends A{

    int i =0;
    public B(){
        super(1);

        int i= 0;
        this.i = 1;
    }



    public static void fun(){
        System.out.println("B fun");
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("my thread run");
    }
}
public class MyTest {
    void fun(A a){
        a.fun();
    }

    @Test
    public void testA(){
        A b = new B();
        fun(b);
        Random random = new Random();
        System.out.println(random.nextInt(2));
        Object o;
        int i = 0;
        o=i;
        o=b;
        Thread thread = new MyThread();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("runable");
            }
        };

        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();

        byte b1=4,b2=6,bb,bbb;
        final byte b3=4,b4=6;
        bb=(b3+b4);
        bbb=b1+b2;
    }
}
