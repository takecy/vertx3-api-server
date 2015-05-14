/**
 *
 */
package info.takebo.api.handler;

import io.vertx.core.Handler;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.apex.RoutingContext;
import rx.Observable;

/**
 * @author takecy
 */
public abstract class AbstractHttpHandler<T> implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext event) {
		HttpServerRequest req = event.request();
		MultiMap params = req.params();
		this.handleInternal(event, req, params)
		.map(in -> {
			// TODO log
			return in;
		})
		.subscribe(result -> {
			event.response().setStatusCode(200).end();
		}, error -> {
			// TODO
			event.response().setStatusCode(500).end();
		}, () -> {
			// TODO log
		});
	}

	/**
	 * implementation at subclass
	 *
	 * @param event
	 * @param params
	 * @param req
	 */
	public abstract Observable<T> handleInternal(RoutingContext event,
													HttpServerRequest req,
													MultiMap params);

}
