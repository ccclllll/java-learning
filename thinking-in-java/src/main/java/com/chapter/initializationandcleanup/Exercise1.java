package com.chapter.initializationandcleanup;

import org.junit.jupiter.api.Test;

public class Exercise1 {
    class A{
        String s;
    }

    class B{
        String s = "string1";
        String s1 ;
        B(String s1){
            this.s1 = s1;
        }
        void f(int i,String s){

        }
        void f(String s,int i){ // the order of arguments is different

        }

        void f(String s){ // the list of arguments if different

        }
        // 对于方法重载 ， 返回类型可以不同，但是不能有相同序列的参数列表，
        // 举个例子  void f(int i,String s),void f(String s,int i)是允许的，但是不推荐，因为不利于代码维护
        int f(){
            return 1;
        }
    }

    /**
     * 基本类型重载 类似类型提升
     */
    class OverloadWithPrimitive{

/*        void f1(char c){
            System.out.println("c = [" + c + "]");
        }*/
/*
        void f1(int i){
            System.out.println("i = [" + i + "]");
        }
*/

        void f1(byte b){
            System.out.println("b = [" + b + "]");
        }
        void f1(short shortNum){
            System.out.println("shortNum = [" + shortNum + "]");
        }
        void f1(float f){
            System.out.println("f = [" + f + "]");
        }
    }
    @Test
    public void testA(){
/*        A a= new A();
        String s;
        *//*System.out.println(s);*//* // error 没有被初始化 使用一个引用前必须对其赋值或者初始化
        System.out.println(a.s); // 会被构造器自动初始化为null*/

        OverloadWithPrimitive overload = new OverloadWithPrimitive();
        char c = 5;
        overload.f1(c); // if there are no method with char argument, but a method with large type , the char type will be automatically promoted to large type.
        int i = 5;
        overload.f1(i);
        float f= 5;
        overload.f1(f);

        byte b = 5;
        overload.f1(b);
    }

    class Father{
        String name = "father";
        void sayName(){
            System.out.println(this.name);
        }
        void sayHello(){
            System.out.println("hello");
        }
    }

    class Son extends Father{
        String name = "son";
        @Override
        void sayName(){
            System.out.println(this.name);
        }
    }

    class Use{
        void f1(Father f){
            f.sayName();
        }

    }

    @Test
    public void testFather(){
        Son son = new Son();
        Use use = new Use();
        use.f1(son);
    }
}
