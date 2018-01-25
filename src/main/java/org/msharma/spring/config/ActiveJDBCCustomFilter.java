package org.msharma.spring.config;

import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import java.io.IOException;

/**
 * This filter open a connection for a request and closes it on serving the request.
 * @author Mohan Sharma Created on 25/01/18.
 */
@Component
public class ActiveJDBCCustomFilter implements Filter
{

	@Autowired
	private DataSource dataSource;

	@Override
	public void init(FilterConfig filterConfig)
	{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		try
		{
			Base.open(dataSource);
			Base.openTransaction();
			chain.doFilter(request, response);
			Base.commitTransaction();
		}
		catch (IOException e)
		{
			Base.rollbackTransaction();
			throw e;
		}
		catch (ServletException e)
		{
			Base.rollbackTransaction();
			throw e;
		}
		finally
		{

			Base.close();
		}
	}

	@Override public void destroy()
	{}
}
