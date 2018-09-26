package com.chapter.initializationandcleanup;

import org.junit.jupiter.api.Test;

public class Exercise3 {

    static class A{
        public A(){

        }
        public A(String a){
            this();
        }
        public A(String ...s){
            for(String s1 : s){
                System.out.println("s = [" + s1 + "]");
            }
        }
       static void f1(){
           System.out.println("static method");
       }
       void f2(){
           System.out.println("non-static method");
           f1();
       }
       static class AA{
            static String name = "the inner class of a inner class";
       }
    }
    @Test
    public void testExercise3(){
        A a = new A();
        A.f1();
        a.f2();
    }

}
