package com.chapter.io;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadList<T> {
    List<T> list;

    public ReadList(List<T> list) {
        this.list = list;
    }

    public File readListToFile(String path) throws IOException {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        Iterator<T> iterator = list.iterator();

        while (iterator.hasNext()) {
            T t = iterator.next();
            writer.write(t.toString());
            writer.newLine();
        }
        writer.close();
        return file;
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        ReadList<Integer> list = new ReadList<>(integers);
        list.readListToFile("c://cl//3.txt");
    }
}
