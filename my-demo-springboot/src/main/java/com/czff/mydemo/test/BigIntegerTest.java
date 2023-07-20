package com.czff.mydemo.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @description 
 * @author cuidi
 * @date 2023/3/14 17:24
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("200");
        BigInteger b = new BigInteger("1000");
        BigDecimal c = new BigDecimal(a);
        BigDecimal d = new BigDecimal(b);
        BigDecimal divide = c.divide(d, 2, RoundingMode.HALF_UP);
        System.out.println(divide);

        BigInteger z = new BigInteger("1000");
        System.out.println(z);
    }
}
