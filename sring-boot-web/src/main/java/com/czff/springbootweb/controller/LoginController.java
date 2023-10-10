package com.czff.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2021/1/14 20:50
 * @description
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登陆成功 防止表单重复提交 可以重定向到主页
            session.setAttribute("loginUser", username);
            // 重定向
            return "redirect:/main.html";
        }
        // 登陆失败
        map.put("message", "用户名密码错误！");
        return "login";
    }
}
