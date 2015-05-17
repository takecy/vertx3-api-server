/**
 *
 */
package info.takebo.api.verticle;

import info.takebo.api.guice.AopModule;
import info.takebo.api.guice.ContextModule;
import info.takebo.api.guice.HandlerModule;
import info.takebo.api.guice.LoggerModule;
import info.takebo.api.guice.ServiceModule;
import info.takebo.api.handler.http.AliveHandler;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.buffer.Buffer;
import io.vertx.rxjava.core.http.HttpServer;
import io.vertx.rxjava.ext.apex.Router;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author yamashita_takeshi
 */
public class HttpVerticle extends AbstractVerticle {

	private Logger logger = LoggerFactory.getLogger("init.server"
													+ HttpVerticle.class.getName());

	@Override
	public void start() throws Exception {

		Injector injector = Guice.createInjector(new LoggerModule(),
													new AopModule(),
													new ContextModule(),
													new HandlerModule(),
													new ServiceModule()
									);

		// URL routing
		Router router = Router.router(vertx);

		router.options("*")
				.handler(context -> {
					context.response()
							.putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")
							.putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*")
							.putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*")
							.setStatusCode(200)
							.end();
				});

		router.get("/")
				.handler(context -> {
					context.response()
							.setStatusCode(303)
							.putHeader(HttpHeaders.LOCATION, "/alive")
							.end();
				});

		router.get("/hello")
				.handler(context -> {
					JsonObject json = new JsonObject().put("message",
															"Hello! Vert.x 3.x JSON");

					Buffer buffer = Buffer.buffer(json.toString());

					context.response()
							.putHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString())
							.putHeader(HttpHeaders.CONTENT_LENGTH, Objects.toString(buffer.length()))
							.write(buffer)
							.end();
				});

		router.get("/alive")
				.handler(injector.getInstance(AliveHandler.class));

		HttpServerOptions serverOption = new HttpServerOptions().setAcceptBacklog(10000)
																.setCompressionSupported(true);
		HttpServer server = vertx.createHttpServer(serverOption);

		server.requestHandler(router::accept)
				.listenObservable(8080)
				.subscribe(result -> logger.info("start.server"),
							error -> logger.error("failed.start.server"),
							() -> logger.info("complete.ini.server"));

		// server.requestStream()
		// .toObservable()
		// .subscribe(req -> {
		// req.response()
		// .putHeader("content-type", "text/html")
		// .end("<html><body><h1>Hello from vert.x!</h1></body></html>");
		// });
	}
}
