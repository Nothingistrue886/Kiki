package com.czff.shiro.spring;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author cuidi
 * @description
 * @date 2022/11/3 11:07
 */
public class ShiroMD5 {

    public static void main(String[] args) {

        String password = "z3";
        Md5Hash md5Hash = new Md5Hash(password, "salt", 3);
        System.out.println("md5Hash = " + md5Hash.toString());
        // md5Hash = 7174f64b13022acd3c56e2781e098a5f
    }
}
