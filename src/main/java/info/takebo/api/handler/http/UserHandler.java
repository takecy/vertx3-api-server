/**
 * takecy
 */
package info.takebo.api.handler.http;

import info.takebo.api.entity.User;
import info.takebo.api.handler.AbstractHttpHandler;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.apex.RoutingContext;
import rx.Observable;

/**
 * @author takecy
 */
public class UserHandler extends AbstractHttpHandler<User> {

	@Override
	public Observable<User> handleInternal(RoutingContext event,
												HttpServerRequest req,
												MultiMap headers,
												MultiMap params) {

		User user = new User();

		return Observable.just(user);
	}
}
