package org.msharma.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Mohan Sharma Created on 22/01/18.
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] {SpringAppConfig.class};
	}

	@Override protected Class<?>[] getServletConfigClasses()
	{
		return new Class[] {SpringWebMVCConfigurer.class};
	}

	@Override protected String[] getServletMappings()
	{
		return new String[] {"/"};
	}
}
