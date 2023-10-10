package com.czff.springbootweb.controller;

import com.czff.springbootweb.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 疾风劲草
 * @date 2021/1/31 22:08
 * @description
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * 返回json数据
     * @param e
     * @return
     */
//    @ResponseBody
//    @ExceptionHandler(UserException.class)
//    public Map<String, Object> handlerException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return map;
//    }

    /**
     * 自适应
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public String handlerException(HttpServletRequest request, Exception e){
        Map<String, Object> map = new HashMap<>();
        // 传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        request.setAttribute("other", map);
        // 转发到/error
        return "forward:/error";
    }
}
