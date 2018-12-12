package com.chapter.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Channel {
    public static void copyFileWithNio(String target, String source) throws Exception {
        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileOutputStream(target).getChannel();
        out.transferFrom(in, 0, in.size());
        // or in.transferTo(out,in.size(),0);
    }

    public static void copyFileWithIO(String target, String source) throws Exception {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(target)));
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        out.write(bytes);
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
//        FileInputStream stream = new FileInputStream("c:\\cl\\img.jpg");
//        FileChannel channel = stream.getChannel();
//        FileOutputStream stream1 = new FileOutputStream("c:\\cl\\img4.jpg");
//        FileChannel channel1 = stream1.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        while (channel.read(byteBuffer) != -1) {
//            byteBuffer.flip(); // 写入数据之后必须
//            channel1.write(byteBuffer);
//            byteBuffer.clear(); // 继续写入时必须
//        }
//        channel.close();
//        channel1.close();
//        stream.close();
//        stream1.close();
        copyFileWithNio("c:\\cl\\img5.jpg", "c:\\\\cl\\\\img.jpg");

    }
}
