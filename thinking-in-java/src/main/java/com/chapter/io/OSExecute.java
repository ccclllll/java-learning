package com.chapter.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 执行操作系统程序，捕获其输入流
 */
public class OSExecute {
    public static void main(String[] args) throws IOException {
        String command = "";
        Process process = new ProcessBuilder(command).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.readLine();
    }
}
