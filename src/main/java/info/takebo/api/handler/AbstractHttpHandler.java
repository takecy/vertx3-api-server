/**
 *
 */
package info.takebo.api.handler;

import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import info.takebo.api.logger.LoggerWrapper;
import io.vertx.core.Handler;
import io.vertx.rxjava.core.MultiMap;
import io.vertx.rxjava.core.buffer.Buffer;
import io.vertx.rxjava.core.http.HttpServerRequest;
import io.vertx.rxjava.ext.web.RoutingContext;
import rx.Observable;

import java.util.Objects;

/**
 * @author takecy
 */
public abstract class AbstractHttpHandler<T> implements Handler<RoutingContext> {

	private LoggerWrapper logger = new LoggerWrapper(this.getClass().getName(), "$$");

	@Override
	public void handle(RoutingContext event) {
		HttpServerRequest req = event.request();
		MultiMap params = req.params();
		MultiMap headers = req.headers();

		this.handleInternal(event, req, headers, params)
			.map(in -> {
				// TODO log
				return in;
			})
			.subscribe(
						result -> {
							Buffer buffer = Buffer.buffer(Objects.toString(result));

							event.response()
									.setStatusCode(200)
									.putHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString())
									.putHeader(HttpHeaders.CONTENT_LENGTH, Objects.toString(buffer.length()))
									.putHeader(HttpHeaders.CONNECTION, "keep-alive")
									.write(buffer)
									.end();
						},
						error -> {
							event.response()
									.setStatusCode(500)
									.end();
						},
						() -> {
							logger.info("complete.http.routing");
						});
	}

	/**
	 * implementation at subclass
	 *
	 * @param event
	 * @param req
	 * @param headers
	 * @param params
	 */
	public abstract Observable<T> handleInternal(RoutingContext event,
													HttpServerRequest req,
													MultiMap headers,
													MultiMap params);

}
