/**
 *
 */
package info.takebo.api;

import info.takebo.api.util.Runner;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.ext.apex.Router;

/**
 * @author yamashita_takeshi
 */
public class RxApiServer extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Runner.runExample(RxApiServer.class);
	}

	@Override
	public void start() throws Exception {

		// URL routing
		Router router = Router.router(vertx);

		router.get("/")
				.handler(req -> {
					req.response()
						.setStatusCode(303)
						.putHeader(HttpHeaders.LOCATION.toString(), "/hello")
						.end();
				});

		router.get("/hello")
				.handler(req -> {
					req.response()
						.putHeader("content-type", "text/html")
						.end("<html><body><h1>Hello from vert.x! Routing!</h1></body></html>");
				});

		HttpServerOptions serverOption = new HttpServerOptions().setAcceptBacklog(10000)
																.setCompressionSupported(true);

		HttpServer server = vertx.createHttpServer(serverOption);

		server.requestHandler(router::accept)
				.listen(8080);

		// server.requestStream()
		// .toObservable()
		// .subscribe(req -> {
		// req.response()
		// .putHeader("content-type", "text/html")
		// .end("<html><body><h1>Hello from vert.x!</h1></body></html>");
		// });
	}
}
