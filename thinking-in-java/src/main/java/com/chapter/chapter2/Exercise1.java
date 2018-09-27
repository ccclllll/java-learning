package com.chapter.chapter2;

public class Exercise1 {
    public static void main(String[] args) {
        int i = 0;
        i = 10;
        String s = new String("134");
        String s2 = new String("1132");

        System.out.println(System.identityHashCode(s));
        s = "134";
        System.out.println(System.identityHashCode(s));
    }
}
