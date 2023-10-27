package com.czff.study.util.encryptutil;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * @author cuidi
 * @description AES+自定义密钥实现加密解密
 * @date 2022/11/10 20:45
 */
public class AesEncryptUtil {

    //指定算法方式
    private static final String AES = "AES";
    //声明完整算法，用于构造密码器
    private static final String AES_CIPHER = "AES/ECB/PKCS5Padding";

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param keyStr  AES解密密钥（32位的16进制字符串）
     * @return 加密后的字节数组
     */
    public static String encrypt(String content, String keyStr) {
        try {
            // 根据自定义的密钥构建SecretKeySpec对象
            SecretKeySpec key = new SecretKeySpec(Hex.decodeHex(keyStr.toCharArray()), AES);
            // 创建密码器，声明为AES算法
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //一般加密后的结果，这里无法直接通过new String(result)拿到结果，会乱码
            //这里使用的是Apache的commons-codec进行处理为16进制
            byte[] result = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            // 加密
            return new String(Hex.encodeHex(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content 加密后的密文
     * @param keyStr  密钥
     */
    public static String decrypt(String content, String keyStr) {
        try {
            SecretKeySpec key = new SecretKeySpec(Hex.decodeHex(keyStr.toCharArray()), AES);
            // 创建密码器
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(Hex.decodeHex(content.toCharArray()));
            // 解密
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据自定义的key得到128Bit 的 AES密钥
     *
     * @param key 自定义的关键字
     * @return AES密钥（32位的16进制字符串）
     * @throws Exception
     */
    public static String getAESKey(String key) throws Exception {
        // 构造方法内的参数为byte[]-》种子byte数组
        final SecureRandom random = new SecureRandom(key.getBytes());
        final KeyGenerator generate;
        generate = KeyGenerator.getInstance(AES);
        generate.init(128, random);
        byte[] keyBytes = generate.generateKey().getEncoded();

//        System.out.println("加密后的字符串 = " + new String(keyBytes));
        return new String(Hex.encodeHex(keyBytes));
    }

    public static void main(String[] args) throws Exception {
        String aesKey = AesEncryptUtil.getAESKey("testAesEncrypt");
        String encrypt = AesEncryptUtil.encrypt("18755813090", aesKey);
        String decrypt = AesEncryptUtil.decrypt(encrypt, aesKey);

        System.out.println("密钥= " + aesKey);
        System.out.println("加密结果 = " + encrypt);
        System.out.println("解密 = " + decrypt);
    }

}
