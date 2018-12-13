package com.chapter.io;

import java.io.*;

/**
 * 序列化 瞬时关键字
 */
public class TransientData implements Serializable {
    private String stringData;
    private int intData;
    private transient String password; // 瞬时关键字，意味着该子对象不会被序列化保存

    public TransientData(String stringData, int intData, String password) {
        this.stringData = stringData;
        this.intData = intData;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TransientData{" +
                "stringData='" + stringData + '\'' +
                ", intData=" + intData +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception{
        TransientData data = new TransientData("zs",1,"1212312313");
        //序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\cl\\data.txt"));
        out.writeObject(data);// 向文件里写数据
        out.close();

        //反序列化 反序列化时需要保证java虚拟机能够找到对应的class对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\cl\\data.txt"));
        data = (TransientData) in.readObject();
        System.out.println(data); //TransientData{stringData='zs', intData=1, password='null'}
    }
}
