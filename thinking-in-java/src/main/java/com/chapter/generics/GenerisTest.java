package com.chapter.generics;


import com.chapter.generics.inherit.Base;
import com.chapter.generics.inherit.Child;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerisTest {
    class TwoTuple<A, B> {
        public final A first;
        public final B second;

        /**
         * 可以在构造函数里进行初始化，构造函数是一个static成员
         *
         * @param first
         * @param second
         */
        public TwoTuple(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public <T> T getParameterType(T t) {
        return t;
    }


    @Test
    public void testRemoveType() throws Exception {
        List<String> strings = new ArrayList<>();
        strings.getClass().getDeclaredMethod("add", Object.class).invoke(strings, new Double(10));
        Object o = strings.getClass().getDeclaredMethod("get", int.class).invoke(strings, 0);
        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {
        GenerisTest test = new GenerisTest();
        test.getParameterType("String");
        List<String> strings = new ArrayList<>();
        List<?> list = strings; // ?只提供可读功能
        List<? extends Base> bases = new ArrayList<>();
        // bases.add(new Child()); // error
        // bases.add(new Base());// error
        List<? super Child> objects = new ArrayList<>();
        objects.add(new Child());
        //objects.add(new Base());//error
        System.out.println(objects.getClass().equals(bases.getClass()));//true
        ArrayList<Child<String>> children = new ArrayList<>();
        children.get(1);
        Child<String>[] s = new Child[]{new Child<Double>(), new Child<Integer>()};
        String ss = new String("a");
        Child c = new Child();
        System.out.println(c instanceof Base);
        System.out.println(String.class.isInstance(new String()));
    }
}
