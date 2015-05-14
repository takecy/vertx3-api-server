/**
 *
 */
package info.takebo.api.guice;

import javax.inject.Singleton;

import info.takebo.api.logger.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * @author takecy
 */
public class LoggerModule extends AbstractModule {

	@Override
	protected void configure() {
	}

	@Singleton
	@Provides
	public Logger logger() {
		return new Logger();
	}
}
