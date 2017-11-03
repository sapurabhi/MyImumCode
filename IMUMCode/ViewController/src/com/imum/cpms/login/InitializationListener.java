package com.imum.cpms.login;

import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import oracle.jbo.common.PropertyMetadata;

public class InitializationListener implements ServletContextListener {
    public InitializationListener() {
        super();
    }
    private ServletContext context = null;
    
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       context = servletContextEvent.getServletContext();

       AccessController.doPrivileged( new PrivilegedAction(){
           public Object run(){ System.setProperty(PropertyMetadata.PN_SQLBUILDERIMPL.getName(),"SQLServer");
                                return null;
                                }});

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext();
    }
}
