package com.czff.mydemo.hutool.net;

import cn.hutool.core.net.NetUtil;

import java.math.BigInteger;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description 
 * @author cuidi
 * @date 2023/3/6 21:15
 */
public class NetTest2 {

    public static void main(String[] args) throws UnknownHostException {
        // ipv6子网掩码计算首位ip和末尾ip
        // Define the IPv6 subnet and prefix length
        String subnet = "2001:db8:85a3::";
        int prefixLength = 64;

        // Calculate the first and last IP addresses
        InetAddress firstIp = InetAddress.getByName(subnet);
        BigInteger firstIpValue = new BigInteger(1, firstIp.getAddress());
        BigInteger lastIpValue = firstIpValue.add(BigInteger.ONE.shiftLeft(128 - prefixLength).subtract(BigInteger.ONE));
        byte[] lastIpBytes = lastIpValue.toByteArray();
        byte[] lastIpAddr = new byte[16];
        for (int i = 0; i < 16; i++) {
            lastIpAddr[i] = (lastIpBytes.length - 1 - i >= 0) ? lastIpBytes[lastIpBytes.length - 1 - i] : 0;
        }
        InetAddress lastIp = InetAddress.getByAddress(lastIpAddr);

        // Example usage
        System.out.println("First IP: " + firstIp.getHostAddress());
        System.out.println("Last IP: " + lastIp.getHostAddress());



//        String IPv6Str = "2001:db8:85a3::1";
//        BigInteger bigInteger = NetUtil.ipv6ToBitInteger(IPv6Str);
//        String valueOf = String.valueOf(bigInteger);
//        System.out.println(valueOf);
        // 42540766452641154071740063647526813697


//        String ipValid = MyNetUtil.validIPAddress("2001:0db8:3c4d:0015:0000:0000:1a2f:1a2b");
//        System.out.println(ipValid);



    }
}
