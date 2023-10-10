package com.czff.mydemo.util.encryptutil;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Data;

/**
 * @author cuidi
 * @description
 * @date 2022/11/10 20:52
 */
public class AesUtilTest {
    public static void main(String[] args) throws Exception {
        String aesKey = AesEncryptUtil.getAESKey("testAesEncrypt");
        String encrypt = AesEncryptUtil.encrypt("18755813090", aesKey);
        String decrypt = AesEncryptUtil.decrypt(encrypt, aesKey);

        System.out.println("密钥= " + aesKey);
        System.out.println("加密结果 = " + encrypt);
        System.out.println("解密 = " + decrypt);

        System.out.println("================");

        String aesKey1 = AesEncryptUtil.getAESKey("testAesEncrypt");
        String content1 = "{\"username\":\"18617488187\",\"uuid\":\"18617488187\"}";
        String encrypt1 = AesEncryptUtil.encrypt(content1, aesKey1);
//        JSON json = JSONUtil.parse(content1);
//        String encrypt1 = AesEncryptUtil.encrypt(json.toString(), aesKey1);
        System.out.println("encrypt1 = " + encrypt1);
        String decrypt1 = AesEncryptUtil.decrypt(encrypt1, aesKey1);
        System.out.println("decrypt1 = " + decrypt1);
        JSONObject jsonObject = JSONUtil.parseObj(decrypt1);
        Aaa aaa = jsonObject.toBean(Aaa.class);
        String username = aaa.getUsername();
        String uuid = aaa.getUuid();
        System.out.println(username + "---" + uuid);
    }

}

@Data
class Aaa {
    private String username;
    private String uuid;
}
