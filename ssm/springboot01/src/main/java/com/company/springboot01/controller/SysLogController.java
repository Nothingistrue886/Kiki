package com.company.springboot01.controller;

import com.company.springboot01.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 疾风劲草
 * @date 2020/5/4 11:31
 * @description TODO
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 方法一:
     * {ids} 占位符
     * 通过 @PathVariable 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
     * 方法二:
     * URL中没有占位符
     * 在URL中拼接 http://localhost:8080/log/deleteLogsById?ids=12
     * @param ids
     * @return
     */
    @RequestMapping("deleteLogsById/{ids}")
    @ResponseBody
    public String deleteLogsById(@PathVariable Integer... ids) {
        int rows = sysLogService.deleteLogsById(ids);
        return "delete ok, rows = " + rows;
    }
}
