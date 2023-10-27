package com.czff.study.util.hutool.http;

import cn.hutool.http.HttpRequest;

/**
 * @description 
 * @author cuidi
 * @date 2023/2/16 10:30
 */
public class HttpUtilTest {

    public static void main(String[] args) {


        String result2 = HttpRequest.get("https://www.baidu.com/").setSSLProtocol("SSL").execute().body();
        System.out.println(result2);

//        String s = HttpUtil.get("https://mp-test.chinalco.com.cn:10443/open/apigw/v1/apptoken/create?grant_type=client_credential&appid=3261184-663552&secret=C32A6F784AD756D5F7D7B77C147A4F70");
//        System.out.println(s);


//        //链式构建请求
//        String result2 = HttpRequest.post("http://10.18.1.216/api/base-server/manage/assetsUser/getDep")
//                .header(Header.CONTENT_TYPE, "application/json")//头信息，多个头信息多次调用此方法即可
//                .header(Header.COOKIE, "JSESSIONID=727303448a3b4c8b96c1b6314a3830f6")
//                .timeout(20000)//超时，毫秒
//                .execute().body();
//        System.out.println(result2);
    }



}
