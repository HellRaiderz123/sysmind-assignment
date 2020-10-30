package com.sysmind.org.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.h2.server.web.WebServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcConfigureInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MvcConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter()};
    	return singleton;
    }
    
    @Override
    public void onStartup(ServletContext servletContext) 
      throws ServletException {
      super.onStartup(servletContext);
      ServletRegistration.Dynamic servlet = servletContext
        .addServlet("h2-console", new WebServlet());
      servlet.setLoadOnStartup(2);
      servlet.addMapping("/console/*");
    }
 
}