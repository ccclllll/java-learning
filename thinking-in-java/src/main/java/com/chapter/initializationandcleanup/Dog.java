package com.chapter.initializationandcleanup;

public class Dog {
    public static String name = "wangwang";
    public static String category;
    static {
        category = "feifei";
        name = "lili";
    }
    public static void p(){
        System.out.println(name+"-----"+category);

    }

    enum Num{
        ONE,TWO,THREE
    }

    public static void main(String[] args) {
        Num num = Num.ONE;
        System.out.println(num);
        for(Num num1 : Num.values()){
            System.out.println(num1.ordinal());
        }
        switch (num){
            case ONE:
                break;
            case TWO:
                break;
        }


    }
}
