package com.chapter.controllingexecution;

public class Test {


    public static void main(String[] args) {
/*        for (char c = 128; c >0; c--) {
           *//* if (Character.isLowerCase(c))
                System.out.println("value:" + (int) c + "character:" + c);*//*
            System.out.println("value:" + (int) c + "character:" + c);
        }*/
        Character c = 0;

        System.out.println("value:" + (int) --c + "character:" + --c);
    }


    @org.junit.jupiter.api.Test
    public void testCommaOperator(){
        for(int i=0, j=10;i<j;i++,j--){
            System.out.println("i is "+ i+",j is "+j);
        }
    }

    @org.junit.jupiter.api.Test
    public void testForEach(){
        for(char c : "Hello World".toCharArray()){
            System.out.println(c);
        }
    }
}
