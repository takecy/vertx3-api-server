package info.takebo.api;

import static org.hamcrest.CoreMatchers.*;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import io.vertx.rxjava.core.Vertx;
import io.vertx.rxjava.core.http.HttpClient;
import io.vertx.rxjava.core.http.HttpClientRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.net.HttpHeaders;

@RunWith(VertxUnitRunner.class)
public class RxApiServerTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before
	public void before(TestContext test) {
		Vertx.vertx().deployVerticle(RxApiServer.class.getName(),
										result -> {
											logger.info("done -> " + result.succeeded());

											if (result.succeeded() == false) {
												test.fail();
											}
										});
	}

	@After
	public void after(TestContext test) {
	}

	@Test
	public void testHello(TestContext test) {
		HttpClient client = Vertx.vertx().createHttpClient();
		HttpClientRequest req = client.request(HttpMethod.GET, 8080, "localhost", "/hello");

		req.toObservable()
			.flatMap(res -> {
				if (res.statusCode() != 200) {
					test.fail("status.code -> " + res.statusCode());
				}
				return res.toObservable();
			})
			.subscribe(data -> {
				logger.info("Server content " + data.toString("UTF-8"));
			});

		req.end();
	}

	@Test
	public void testIndex(TestContext test) {
		HttpClient client = Vertx.vertx().createHttpClient();
		HttpClientRequest req = client.request(HttpMethod.GET, 8080, "localhost", "/");

		req.toObservable()
			.flatMap(res -> {
				test.assertEquals(res.statusCode(), 303);
				test.assertEquals(res.headers().get(HttpHeaders.LOCATION), is("hello"));

				return res.toObservable();
			})
			.subscribe(data -> {
				logger.info("Server content " + data.toString("UTF-8"));
			});

		req.end();
	}
}
