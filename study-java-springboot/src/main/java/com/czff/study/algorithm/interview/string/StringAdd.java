package com.czff.study.algorithm.interview.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 疾风劲草
 * @date 2022/6/9 15:07
 * @description 字符串相加
 */
public class StringAdd {

    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "23";

        StringAdd stringAdd = new StringAdd();
        String s = stringAdd.addFoo(str1, str2);
        System.out.println(s);
    }

    public String addFoo(String str1, String str2) {

        StringBuffer s1 = new StringBuffer(str1).reverse();
        StringBuffer s2 = new StringBuffer(str2).reverse();
        StringBuffer res = new StringBuffer();

        int len1 = s1.length();
        int len2 = s2.length();
        int len;

        if (len1 < len2) {
            len = len2;
            int count = len2 - len1;
            while (count-- > 0) {
                s1.append('0');
            }
        } else {
            len = len1;
            int count = len1 - len2;
            while (count-- > 0) {
                s2.append('0');
            }
        }

        int overflow = 0;
        int num;

        for (int i = 0; i < len; i++) {
            // ASCII码中字符"0"为48，"3"为51
            num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
            if (num >= 10) {
                overflow = 1;
                num -= 10;
            } else {
                overflow = 0;
            }
            res.append(num);
        }

        if (overflow == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    /**
     * 两个大字符串相加，会有很大的数字无法使用int或者long来存储了，那么只能存储成string类型
     */
    public String bigNumberPlus(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA > lenB) {
            b = StringUtils.leftPad(b, lenA, "0");
        } else {
            a = StringUtils.leftPad(a, lenB, "0");
        }

        int[] arrC = new int[a.length() + 1];

        for (int i = a.length() - 1; i >= 0; i--) {
            int ai = Integer.parseInt(a.charAt(i) + "");
            int bi = Integer.parseInt(b.charAt(i) + "");
            int ci = arrC[i + 1];
            int t = ai + bi + ci;
            arrC[i + 1] = t % 10;
            arrC[i] = t / 10;
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < arrC.length; i++) {
            if (i == 0 && arrC[i] == 0) continue;
            res.append(arrC[i]);
        }
        return res.toString();
    }
}
