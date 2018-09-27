package com.chapter.initializationandcleanup;

public class StaticTest {
    class InnerStaticClass {
        public final void f() {
            System.out.println("InnerStaticClass");
        }
    }

    public static void say(String args[]){
        System.out.println("args = [" + args + "]");
    }
}