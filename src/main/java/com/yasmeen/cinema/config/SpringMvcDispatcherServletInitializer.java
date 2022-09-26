package com.yasmeen.cinema.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author YasmeenHj
 * created on 9/7/2022 at 10:54 PM
 * @project spring-security-demo-01-base-app
 */
public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CinemaApp.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
