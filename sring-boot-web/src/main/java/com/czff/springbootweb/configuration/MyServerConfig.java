package com.czff.springbootweb.configuration;

import com.czff.springbootweb.filter.MyFilter;
import com.czff.springbootweb.listener.MyListener;
import com.czff.springbootweb.servlet.MyServlet;
import org.springframework.boot.autoconfigure.websocket.servlet.TomcatWebSocketServletWebServerCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 疾风劲草
 * @date 2021/2/19 21:14
 * @description
 */
@Configuration
public class MyServerConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        ServletRegistrationBean<MyServlet> servletRegistrationBean =
                new ServletRegistrationBean<>(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>(new MyFilter(), myServlet());
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;
    }

    // 一定要将这个定制器加入到容器中
    @Bean
    public TomcatWebSocketServletWebServerCustomizer tomcatWebSocketServletWebServerCustomizer() {
        return new TomcatWebSocketServletWebServerCustomizer() {
            // 定制嵌入式的Servlet容器相关的规则
            @Override
            public void customize(TomcatServletWebServerFactory factory) {
                factory.setPort(8088);
            }
        };
    }
}
