/**
 *
 */
package info.takebo.api.verticle;

import java.util.Calendar;
import java.util.Date;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.eventbus.EventBus;
import io.vertx.rxjava.core.eventbus.MessageConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yamashita_takeshi
 */
public class EventbusWorkerVerticle extends AbstractVerticle {

	private Logger logger = LoggerFactory.getLogger("init.server"
			+ EventbusWorkerVerticle.class.getName());

	@Override
	public void start() throws Exception {

		EventBus eb = vertx.eventBus();

		MessageConsumer<String> consumer = eb.consumer("news.uk.sport");

		// eb receive event handler
		consumer.handler(message -> {
			logger.info("I have received a message: " + message.body());
			logger.info("message headers: " + message.headers());
		});

		// eb send event handler
		consumer.completionHandler(res -> {
			if (res.succeeded()) {
				logger.info("The handler registration has reached all nodes");
			} else {
				logger.info("Registration failed!");
			}
		});


		DeliveryOptions options = new DeliveryOptions();
		options.addHeader("x-token-header", "token-" + Calendar.getInstance().getTimeInMillis());
		eb.send("news.uk.sport", "Yay! Someone kicked a ball", options);
	}
}
