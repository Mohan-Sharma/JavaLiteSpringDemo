package org.msharma.spring.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

/**
 * @author Mohan Sharma Created on 23/01/18.
 */
public class DBConfig extends AbstractDBConfig
{
	@Override
	public void init(AppContext appContext)
	{
		configFile("/database.properties");
		environment("development").jndi("jdbc/simple_development");
	}
}
