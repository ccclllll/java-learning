package com.chapter.generics.bianjie;

import com.chapter.generics.lib.LinkedArray;
import com.chapter.generics.lib.List;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Common {
    @Test
    public  void m() {
        Object[] objects = new String[10];
        Common common = new Common();
        objects[0] = new String();
        //编译通过，但是运行时产生java.lang.ArrayStoreException: java.lang.Object 异常，
        // 运行时，数组里存放的引用的实际类型为String，无法将一个Object向下转型为String
        objects[0] = new Object();
        List<? extends LinkedArray<? extends Number>> list = new LinkedArray<>(); // 编译器不知道list到底持有什么类型，所以不会接受任何类型的Number,禁止了使用了泛型作为参数类型的方法


    }
}
