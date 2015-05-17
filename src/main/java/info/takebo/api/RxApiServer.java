/**
 *
 */
package info.takebo.api;

import info.takebo.api.logger.LoggerWrapper;
import info.takebo.api.runner.Runner;
import info.takebo.api.verticle.EventbusWorkerVerticle;
import info.takebo.api.verticle.HttpVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;
import io.vertx.rxjava.core.AbstractVerticle;

/**
 * @author yamashita_takeshi
 */
public class RxApiServer extends AbstractVerticle {

	private LoggerWrapper logger = new LoggerWrapper("init.server"
														+ RxApiServer.class.getName());
	private static final int CPUS = Runtime.getRuntime().availableProcessors();

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Runner.runExample(RxApiServer.class);
	}

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		// deploy other verticle here
		super.start(startFuture);
	}

	@Override
	public void start() throws Exception {

		vertx.deployVerticle(HttpVerticle.class.getName());

		DeploymentOptions options = new DeploymentOptions().setWorker(true)
															.setInstances(CPUS);
		vertx.deployVerticle(EventbusWorkerVerticle.class.getName(), options);

		logger.info("start.server.complete");
	}
}
