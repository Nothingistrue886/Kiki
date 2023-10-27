package com.czff.study.knowledge.iostream;

import java.io.*;

public class Stream {
    private static final String FilePath = "D:\\MyTests\\src\\main\\java\\com\\czff\\demo\\DemoApplication.java";
    private static final String FilePath1 = "D:\\MyTests\\src\\tests\\test.html";
    public static void main(String[] args) throws IOException {
//        readStream();
//        writeStream();
        bufferStream();
    }
    
    public static void bufferStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FilePath1);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(bytes);
        String string = new String(bytes);
        System.out.println(string);
    }

    public static void writeStream() throws IOException {
        File file = new File(FilePath1);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String content = "jifengjincao!";
        fileOutputStream.write(content.getBytes());
        fileOutputStream.close();
    }

    public static void readStream() throws IOException {
        File file = new File(FilePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[500];
        fileInputStream.read(bytes);
//        int count = 0;
//        while((bytes[count] = (byte) fileInputStream.read()) != -1){
//            count++;
//        }
        String string = new String(bytes);
        System.out.println(string);
        fileInputStream.close();
    }
}
