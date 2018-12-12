package com.chapter.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list = path.list((dir, name) -> Pattern.compile("g").matcher(name).find()); // new FilenameFilter(){}
        for (String item : list) {
            System.out.println(item);
        }
    }
}
