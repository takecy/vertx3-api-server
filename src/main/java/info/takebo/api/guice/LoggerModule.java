/**
 *
 */
package info.takebo.api.guice;

import info.takebo.api.logger.LoggerWrapper;

import javax.inject.Singleton;

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
	public LoggerWrapper logger() {
		return new LoggerWrapper("base", "$$");
	}
}
