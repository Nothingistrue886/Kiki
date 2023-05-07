package com.camunda.engine.config;

import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/18 19:28
 */
//@Configuration
//public class AuthFilterConfig implements ServletContextInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) {
//        FilterRegistration.Dynamic authFilter = servletContext.addFilter("camunda-auth", ProcessEngineAuthenticationFilter.class);
//        authFilter.setAsyncSupported(true);
//        authFilter.setInitParameter("authentication-provider", "org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider");
//        authFilter.addMappingForUrlPatterns(null,true,"/engine-rest/*");
//    }
//}
