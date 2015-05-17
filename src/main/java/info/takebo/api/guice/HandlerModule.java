/**
 *
 */
package info.takebo.api.guice;

import info.takebo.api.handler.eventbus.EchoEventbusHandler;
import info.takebo.api.handler.http.AliveHandler;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author takecy
 */
public class HandlerModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AliveHandler.class).in(Scopes.SINGLETON);
		bind(EchoEventbusHandler.class).in(Scopes.SINGLETON);
	}
}
