package com.czff.mydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cuidi
 * @description
 * @date 2023/6/6 15:03
 */
@RestController
public class TestController {

//    @Resource
//    private ThreadPoolExecutor myThreadPoolExecutor;
//
//    @Resource(name = "myThreadPoolExecutor")
//    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    private ThreadPoolExecutor executor;

    @RequestMapping("/hello")
    public String hello() {
        String s = executor.toString();
        return "Hello World!" + s;
    }
}
