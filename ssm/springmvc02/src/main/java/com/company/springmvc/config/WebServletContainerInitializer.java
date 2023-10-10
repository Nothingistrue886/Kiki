package com.company.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;

/**
 * @author 疾风劲草
 * @date 2020/4/23 14:53
 * @description 借助此类取代 web.xml 中的配置
 */

public class WebServletContainerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 父类中默认注册了 DispatcherServlet
     * @param servletContext
     * @throws ServletException
     */
    /*@Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
    }*/

    /**
     * 返回 service dao 相关配置类
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * 返回 controller 相关配置类：spring-configs.xml
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringmvcConfig.class};
    }

    /**
     * 配置 url 映射：url-pattern
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
