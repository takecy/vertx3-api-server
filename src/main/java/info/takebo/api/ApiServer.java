/**
 *
 */
package info.takebo.api;

import info.takebo.api.runner.Runner;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

/**
 * @author yamashita_takeshi
 */
public class ApiServer extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Runner.runExample(ApiServer.class);
	}

	@Override
	public void start() throws Exception {

		Vertx.vertx().createHttpServer()
				.requestHandler(req -> {
					req.response()
						.end("Hello World!");
				})
				.listen(8080);
	}
}
