package com.czff.mydemo.knowledge.iostream;

import java.io.*;

public class BufferStream {
    private static final String FilePath1 = "D:\\File\\崔迪_Java开发工程_华北理工大学_计算机科学与技术.pdf";
    private static final String FilePath2 = "D:\\File\\崔迪_Java开发工程.pdf";

    public static void main(String[] args) throws FileNotFoundException {
        viewIP();


        System.out.println(copyFileByBufferStream());
    }

    private static void viewIP() {
        /**
         * 查看ip地址【Windows系统下】
         */
        ProcessBuilder processBuilder = new ProcessBuilder("ipconfig", "/all");
        try {
            Process process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("IPv4") != -1) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long copyFileByBufferStream() {
        File file1 = new File(FilePath1);
        if (!file1.exists()) {
            System.out.println("要复制的文件不存在!");
            return 0;
        }

        long startTime = System.currentTimeMillis();

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file1);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(FilePath2);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            int i = -1;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long lastTime = System.currentTimeMillis();
        return lastTime - startTime;
    }
}
