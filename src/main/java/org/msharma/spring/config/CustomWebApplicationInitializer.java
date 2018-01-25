package org.msharma.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * This class implements {@link WebApplicationInitializer} and handles dynamic registration of
 * {@link DispatcherServlet} and {@link ContextLoaderListener} and even registers {@link ActiveJDBCCustomFilter}
 * @author Mohan Sharma Created on 22/01/18.
 */
public class CustomWebApplicationInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.setConfigLocation("org.msharma");
		servletContext.addListener(new ContextLoaderListener(appContext));
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		servletContext
				.addFilter("activeJDBCCustomFilter", ActiveJDBCCustomFilter.class)
				.addMappingForUrlPatterns(null, false, "/student/*");
	}
}
