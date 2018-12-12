package com.chapter.generics.bianjie;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Common {
    @Test
    public void m() {
        Object[] objects = new String[10];
        Common common = new Common();
        objects[0] = new String();
        //编译通过，但是运行时产生java.lang.ArrayStoreException: java.lang.Object 异常，
        // 运行时，数组里存放的引用的实际类型为String，无法将一个Object向下转型为String
        objects[0] = new Object();
        List<? extends LinkedList<? extends Number>> list = new LinkedList<>(); // 编译器不知道list到底持有什么类型，所以不会接受任何类型的Number,禁止了使用了泛型作为参数类型的方法

    }

    public static <T> String vv(T t) {

        return t.getClass().toString();

    }

    public static void main(String[] args) {
        String s = vv(new Object());
    }
}
