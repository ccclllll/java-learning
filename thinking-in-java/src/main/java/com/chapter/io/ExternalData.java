package com.chapter.io;

import java.io.*;

/**
 * 特殊序列化，可操控的序列化
 */
public class ExternalData implements Externalizable {
    private String stringData;
    private int intData;

    public ExternalData() {
    }

    public ExternalData(String stringData, int intData) {
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

    /** 向输出流中写对象 **/
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(stringData);
    }

    /** 从输入流中反序列化对象 **/
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        stringData = (String)in.readObject();
    }

    public static void main(String[] args) throws Exception{
        ExternalData data = new ExternalData("zs",1);
        //序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\cl\\data.txt"));
        out.writeObject(data);// 向文件里写数据
        out.close();

        //反序列化 反序列化时需要保证java虚拟机能够找到对应的class对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\cl\\data.txt"));
        data = (ExternalData)in.readObject();
        System.out.println(data);
    }
}
