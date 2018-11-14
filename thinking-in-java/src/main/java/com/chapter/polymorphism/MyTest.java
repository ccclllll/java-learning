package com.chapter.polymorphism;

import org.junit.jupiter.api.Test;

import java.util.Random;

class ST{
    public static String s = "ABC";

    public static void ff(){

    }
    public ST(int i){

    }
}
class A{
    public static void fun(){
        System.out.println("A fun");
    }


    public A(int i){

    }
    public void ff(){

    }

    protected int ff(int i){
        return i;
    }
}
interface In{

}
class B extends A{

    int i =0;

    public static void sf(){

    }


    public B(){
        super(1);

        sf();

        int i= 0;
        this.i = 1;
    }

    /**重写要求参数列表，返回值必须与父类一致,访问权限大于等于父类**/
    @Override
    public void ff(){}

    /** 重载要求参数列表必须不一致,返回类型可以不一致 ,访问权限可以不一致**/
    @Override
    public int ff(int i){
        return i;
    }

    public int ff(A a){
        return 1;
    }

    public A  ff(A a,A b){
        return a;
    }

    private A ff(A a,int i){
        return a;
    }

    public static void fun(){
        System.out.println("B fun");
    }
}


interface MyInterface{
    A fun(A a);
    A funn(A a);
}

/**
 * 实现接口时，方法名与参数需要与接口一致，返回类型和抛出异常小于等于接口，访问权限大于等于接口
 */
class IntefaceImpl implements MyInterface{
    public B fun(A a){
        return new B();
    }

    public A funn(A a) {
        return null;
    }

}

class Father{

    public void fun2(){
        System.out.println("father fun2 called");
    }

    public Father(){

        fun2();
    }
}
class Son extends Father{

    static int i = 1;
    String s = "123";
    public Son(){
    }
    {
        s="12312";
    }
    @Override
    public void fun2(){
        System.out.println("son fun2 called ; i = "+ i + s);
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
      /*  bbb=b1+b2;*/
    }

    @Test
    public void testFun(){
        Father father = new Son();
/*        father.fun1();
        father.sayI();*/
    }
}
