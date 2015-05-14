package info.takebo.api.util;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

/**
 * @author takecy
 */
public enum Jsons {
	SINGLETON;

	public static JsonObject of() {
		return new JsonObject();
	}

	public static JsonObject of(Map<String, Object> map) {
		return new JsonObject(map);
	}

	public static JsonArray array() {
		return new JsonArray();
	}

	@SuppressWarnings("rawtypes")
	public static JsonArray array(List list) {
		return new JsonArray(list);
	}
}
