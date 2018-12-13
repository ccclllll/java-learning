package com.chapter.io;

import java.io.*;

/**
 * 一般序列化
 */
public class Data implements Serializable {
    private String stringData;
    private int intData;

    public Data(String stringData, int intData) {
        this.stringData = stringData;
        this.intData = intData;
    }

    @Override
    public String toString() {
        return "Data{" +
                "stringData='" + stringData + '\'' +
                ", intData=" + intData +
                '}';
    }

    public static void main(String[] args) throws Exception{
        Data data = new Data("an object",0);

        //序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\cl\\data.txt"));
        out.writeObject(data);// 向文件里写数据
        out.close();

        //反序列化 反序列化时需要保证java虚拟机能够找到对应的class对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\cl\\data.txt"));
        data = (Data)in.readObject();
        System.out.println(data);
    }
}
