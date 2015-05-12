/**
 *
 */
package info.takebo.api.handler;

import io.vertx.core.Handler;
import io.vertx.rxjava.ext.apex.RoutingContext;

/**
 * @author takecy
 */
public abstract class AbstractEventbusHandler<T> implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext event) {
		// TODO 自動生成されたメソッド・スタブ
	}

	/**
	 * implementation at subclass
	 */
	public abstract T handleInternal(RoutingContext event);
}
