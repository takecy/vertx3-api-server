/**
 * takecy
 */
package info.takebo.api.handler.eventbus;

import rx.Observable;
import info.takebo.api.handler.AbstractEventbusHandler;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.eventbus.Message;

/**
 * @author takecy
 */
public class EchoEventbusHandler extends AbstractEventbusHandler<String> {

	@Override
	public Observable<String> handleInternal(MultiMap headers,
												Message<String> message) {
		return Observable.just("PONG");
	}

}
