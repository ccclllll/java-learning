package com.chapter.io.nio;

import java.io.*;

/**
 * in 读入
 * out 写出
 */
public class CopyObject {
    public static Object copyObject(Object target, Object source) throws Exception {
        ByteArrayOutputStream byo = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byo);
        out.writeObject(source); // 将object流 最终去向是byo

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byo.toByteArray())); // 读入byo中的数据
        target = in.readObject();
        return target;
    }
}
