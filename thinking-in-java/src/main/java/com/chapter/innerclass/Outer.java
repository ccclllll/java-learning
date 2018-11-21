package com.chapter.innerclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
interface In{
    void f();
}
class A{

    protected static String s ="1";
    void say(){
        System.out.println("A fun");
    }
    class B{
        In Say(){
            class CC implements In{
                String name = "asa";

                public void f() {

                }
            }

            CC c = new CC();
            return c;
        }
        void t(){
            this.Say();
            A.this.say();
        }
    }

    public B b(){
        return new B();

    }


    static void ss(){
        System.out.println("ss");
    }

    static class C{
        public void say(){
            ss();
        }
    }

    public C c(){
        return new C();

    }
}
public class Outer {

    class B{

    }

    public static void main(String[] args) {
  /*      OO o = new OO();
        OO.Inner inner = o.inner();


        System.out.println(inner.getClass());*/
        A.C c = new A.C();
        String a = A.s;
        c.say();
    }
}
class OO{
    String a = "123";
    public class Inner{
        public void get(){
            tt();
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public void tt(){

    }
}

class OOO{
    public OOO(String name1){

    }

    void oo(){}
}

interface Inter{
    String AA = "ass";
    class Inner {

    }
}
class TestOO{

    static class MyIn implements In{

        public void f() {

        }
    }


    class TT extends Inter.Inner{
        void ff(){
        }
    }

    public OOO eO(){
        class C{

        }
        return new OOO("a"){
            void fun(){
                System.out.println("000000");
            }
        };
    }

    public In in(){
        In in;
        if(true){
            class MyIn implements In{

                public void f() {

                }
            }


            in = new MyIn();


        }


        return in;
    }

}

class WithInner{
    void ff(){

    }
    class Inner{
        void say(){
            System.out.println("withInner inner say");
        }
    }
}
class InheritInner extends WithInner.Inner{
    public InheritInner(WithInner withInner){
        withInner.super();
    }
}

class InheritWithInner extends WithInner{
    class Inner{
        void say(){
            System.out.println("InheritWithInner inner say");
        }
    }
}