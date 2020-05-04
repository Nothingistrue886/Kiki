package com.company.springboot01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 疾风劲草
 * @date 2020/5/4 0:41
 * @description TODO
 */
@Controller
@RequestMapping("/")
@Slf4j
public class PageController {
    @RequestMapping("indexUI")
    public String indexUI(){
        log.info("indexUI");
        return "index";
    }
}
