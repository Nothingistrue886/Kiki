package com.czff.mydemo.knowledge.iostream;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader {
    private static final String URL = "http://pic31.nipic.com/20130728/8886898_150127300146_2.jpg";
    private static final int MAX_BUFFERED_SIZE = 10240;

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            //创建url对象，以便获取文件流
            URL url = new URL(URL);
            connection = (HttpURLConnection) url.openConnection();
            //设置连接属性
            //Range从服务器请求下载文件的字节数范围，0-表示不指定终止字节数
            connection.setRequestProperty("Range", "bytes=0-");
            //连接到服务器
            connection.connect();
            if (connection.getResponseCode() / 100 != 2) {
                System.out.println("连接失败！");
                return;
            }
            bufferedInputStream = new BufferedInputStream(connection.getInputStream(), MAX_BUFFERED_SIZE);


            String file = url.getFile();
            String fileName = file.substring(file.lastIndexOf('/') + 1);
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            randomAccessFile.setLength(0);
            randomAccessFile.seek(0);

            int downloed = 0;
            int fileSize = connection.getContentLength();
            while (downloed < fileSize) {
                byte[] buffer = null;
                if (fileSize - downloed > MAX_BUFFERED_SIZE) {
                    buffer = new byte[MAX_BUFFERED_SIZE];
                } else {
                    buffer = new byte[fileSize - downloed];
                }
                //将缓冲区的内容读取出来
                int read = bufferedInputStream.read(buffer);
                if (read == -1) {
                    break;//下载完毕
                }

                //将下载的缓存写入到文件中
                randomAccessFile.seek(downloed);//设置文件指针
                randomAccessFile.write(buffer, 0, read);
                downloed += read;
                System.out.println("当前下载进度：" + downloed * 1.0 / fileSize * 10000 / 100 + "%");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

