package com.chapter.innerclass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class A{

    protected static String s ="1";
    void say(){
        System.out.println("A fun");
    }
    class B{
        void Say(){
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