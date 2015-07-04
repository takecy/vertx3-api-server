/**
 * takecy
 */
package info.takebo.api.handler.http;

import info.takebo.api.handler.AbstractHttpHandler;
import info.takebo.api.util.Jsons;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.web.RoutingContext;
import rx.Observable;

/**
 * @author takecy
 */
public class AliveHandler extends AbstractHttpHandler<String> {

	@Override
	public Observable<String> handleInternal(RoutingContext event,
												HttpServerRequest req,
												MultiMap headers,
												MultiMap params) {

		JsonObject json = Jsons.of().put("app", true);

		return Observable.just(json.toString());
	}
}
