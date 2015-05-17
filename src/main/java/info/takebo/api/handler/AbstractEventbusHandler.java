/**
 *
 */
package info.takebo.api.handler;

import io.vertx.core.Handler;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.eventbus.Message;
import rx.Observable;

/**
 * @author takecy
 */
public abstract class AbstractEventbusHandler<T> implements Handler<Message<T>> {

	@Override
	public void handle(Message<T> message) {
		MultiMap headers = message.headers();
		this.handleInternal(headers, message)
			.map(in -> {
				// TODO log
				return in;
			})
			.subscribe(
						result -> {
							message.reply(result);
						},
						error -> {
							message.fail(500, "failed");
						},
						() -> {
						});
		;
	}

	/**
	 * implementation at subclass
	 *
	 * @param headers
	 * @param message
	 */
	public abstract Observable<T> handleInternal(MultiMap headers,
													Message<T> message);
}
