package com.czff.springbootweb.controller;

import com.czff.springbootweb.exception.UserException;
import com.czff.springbootweb.servicce.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2020/12/13 22:22
 * @description
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name") String name) {
        String helloName = helloService.getName(name);
        if("aaa".equals(name)){
            throw new UserException();
        }
        return helloName;
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("name", "<h1>疾风劲草</h1>");
        map.put("list", Arrays.asList("coc", "lol", "eve"));
        // classpath:/templates/thymeleaf.html thymeleaf 自动渲染
        return "thymeleaf";
    }

}
