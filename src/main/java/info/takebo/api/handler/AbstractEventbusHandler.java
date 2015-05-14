/**
 *
 */
package info.takebo.api.handler;

import rx.Observable;
import io.vertx.core.Handler;
import io.vertx.rxjava.ext.apex.RoutingContext;

/**
 * @author takecy
 */
public abstract class AbstractEventbusHandler<T> implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext event) {
		Observable<T> t = this.handleInternal(event);
	}

	/**
	 * implementation at subclass
	 */
	public abstract Observable<T> handleInternal(RoutingContext event);
}
