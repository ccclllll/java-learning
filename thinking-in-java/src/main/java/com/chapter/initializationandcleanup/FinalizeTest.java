package com.chapter.initializationandcleanup;

public class FinalizeTest {
    public native void fun();
    public static void main(String[] args) throws Exception{
        new Finalize();
        System.gc();
        String s = "s";
        System.out.println(s);
    }
}
