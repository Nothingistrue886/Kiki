package com.czff.springbootweb.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 疾风劲草
 * @date 2021/1/11 22:14
 * @description 可以在链接上携带区域信息 th:href="@{/login.html(l='zh_CN')
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String req = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(req)){
            String[] s = req.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
