package com.com.init;

import com.config.AppCofig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);

        ServletRegistration.Dynamic servletRegistration=servletContext.addServlet("hello",dispatcherServlet);
        annotationConfigWebApplicationContext.register(AppCofig.class);
        servletRegistration.addMapping("/");
    }

}
