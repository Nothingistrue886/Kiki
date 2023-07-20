package com.czff.mydemo.encryptutil;

import java.util.Base64;

/**
 * @description 
 * @author cuidi
 * @date 2023/2/20 10:50
 */
public class Base64Test {
    public static void main(String[] args) {
        // 使用基本型的编码器和解码器 对数据进行编码和解码
        //1.获取编码器
        Base64.Encoder encoder = Base64.getEncoder();
        //2.对字符串进行编码
        String str = "张三";
        String s = encoder.encodeToString(str.getBytes());
        //3.输出编码后的字符串
        System.out.println("编码后的字符串："+s);

        //4.获取解码器
        Base64.Decoder decoder = Base64.getDecoder();
        //5.对编码后的字符串进行解码
        byte[] decode = decoder.decode(s);
        String s1 = new String(decode);
        //6.打印输出解码后的字符串
        System.out.println("解码后的字符串："+s1);

        String encode = cn.hutool.core.codec.Base64.encode("张三");
        System.out.println(encode);
        cn.hutool.core.codec.Base64.decode(encode);


    }
}
