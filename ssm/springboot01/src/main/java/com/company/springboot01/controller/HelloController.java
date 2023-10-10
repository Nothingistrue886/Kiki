package com.company.springboot01.controller;

import com.company.springboot01.mapper.SysLogMapper;
import com.company.springboot01.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 疾风劲草
 * @date 2020/4/24 16:50
 * @description TODO
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HelloController {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    private HelloService helloService;

    @DeleteMapping("updateLogById")
    @ResponseBody
    public String updateLogById(@RequestParam(name = "id", required = false) Integer id) {
        int rows = helloService.updateLogById(id);
        if (rows >= 1) {
            return "delete ok! rows=" + rows;
        } else {
            return "delete fail! rows=" + rows;
        }
    }

    @DeleteMapping("deleteLogById")
    @ResponseBody
    public String deleteLogById(@RequestParam(name = "id", required = false) Integer id) {
        int rows = sysLogMapper.deleteLogById(id);
        if (rows >= 1) {
            return "delete ok! rows=" + rows;
        } else {
            return "delete fail! rows=" + rows;
        }
    }

    @RequestMapping("helloUI")
    public String helloUI() {
        return "hello";
    }

    @RequestMapping("helloWorld")
    @ResponseBody
    public String helloWorld() {
        return "hello world";
    }
}
