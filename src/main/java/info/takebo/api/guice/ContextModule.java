/**
 * takecy
 */
package info.takebo.api.guice;

import info.takebo.api.config.AppContext;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author takecy
 */
public class ContextModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AppContext.class).in(Scopes.SINGLETON);
	}
}
