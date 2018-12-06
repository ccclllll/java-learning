package com.chapter.typeinfo;

import javax.lang.model.type.NullType;

public class Class1 <T>{
    public static void ff(Object o){
        if(o instanceof String){
            System.out.println("o = [" + o + "]");
        }
    }
    public static void main(String[] args) throws Exception{

        Class<? extends Number> clazz = Integer.class;


        ff(new Integer(10));
    }

}