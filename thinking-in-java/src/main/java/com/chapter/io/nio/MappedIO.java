package com.chapter.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件，可以将文件的一部分映射到缓冲区
 */
public class MappedIO {
    private abstract static class Tester {
        void run() {
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        abstract void test() throws IOException;
    }

    private static Tester[] testers = new Tester[]{
            new Tester() {
                @Override
                void test() throws IOException {
                    MappedByteBuffer out = new RandomAccessFile("c:\\cl\\data.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0x8ffffff/2-1, 0x8ffffff);
                    for (int i = 0x8ffffff/2-1; i < 0x8ffffff; i++)
                        out.put((byte) 'k');
/*                    out = new RandomAccessFile("c:\\cl\\data.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0x8ffffff, 0x8ffffff);
                    for (int i = 0; i < 0x8ffffff; i++)
                        out.put((byte) 'z');*/

                }
            }
    };

    public static void main(String[] args) {
        testers[0].run();
    }
}
