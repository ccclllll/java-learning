package com.chapter.io;

import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList {
    ArrayList<String> list = new ArrayList<>();
    String path;

    public SortedDirList(String path) {
        this.path = path;
    }

    public String[] list() {
        String[] list = new File(path).list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(FilenameFilter filter) {
        String[] strings = new File(path).list(filter);
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        return strings;
    }

    public static void main(String[] args) throws FileNotFoundException,IOException {
        SortedDirList list = new SortedDirList(".");
        String[] s = list.list((dir, name) -> Pattern.compile("g").matcher(name).find());
        System.out.println(s);
        File file = new File(".");

       // InputStreamReader reader = new InputStreamReader(new FileInputStream(".git"));
        //BufferedInputStream daraReader = new BufferedInputStream(new DataInputStream(new SequenceInputStream(new FileInputStream("/a"),new FileInputStream("/a"))));
       // BufferedReader bufferedReader = new BufferedReader(reader); // 对输入流进行缓冲
       // StringReader stringReader = new StringReader("asdadasdasdadsa");

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream("c:\\cl\\img.jpg"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("c:\\cl\\img3.jpg")));
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        out.write(bytes);
        stream.close();
        out.close();
    }
}
