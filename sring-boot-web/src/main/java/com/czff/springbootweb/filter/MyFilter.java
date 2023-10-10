package com.czff.springbootweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 疾风劲草
 * @date 2021/2/19 21:24
 * @description
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("my filter process...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
