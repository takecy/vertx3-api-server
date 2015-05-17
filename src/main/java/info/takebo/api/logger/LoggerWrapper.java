/**
 *
 */
package info.takebo.api.logger;

import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author takecy
 */
public class LoggerWrapper {
	/** nested {@link Logger} */
	private Logger nested;

	public LoggerWrapper(Logger core) {
		if (core == null)
			throw new IllegalArgumentException("logger.null");

		this.nested = core;
	}

	public LoggerWrapper(String name) {
		this.nested = LoggerFactory.getLogger(name);
	}

	/**
	 * <pre>
	 * It is output log, if instance managed by Google Guice.
	 *
	 * <code>HogeClass$$EnhancerByGuice$$12345#info</code>
	 *
	 * specify separator "$$"
	 *
	 * <code>HogeClass#info</code>
	 *
	 * </pre>
	 *
	 * @param name
	 * @param separator
	 */
	public LoggerWrapper(String name, String separator) {
		this.nested = LoggerFactory.getLogger(substringBefore(name, separator));
	}

	public LoggerWrapper(Class<?> clazz) {
		this(clazz.getName());
	}

	/**
	 * @see #LoggerWrapper(String, String)
	 */
	public LoggerWrapper(Class<?> clazz, String separator) {
		this(clazz.getName(), separator);
	}

	public Logger getLogger() {
		return nested;
	}

	public void debug(String message) {
		this.debug(() -> message);
	}

	public void info(String message) {
		this.info(() -> message);
	}

	public void warn(String message) {
		this.warn(() -> message);
	}

	public void error(String message) {
		this.error(() -> message);
	}

	public void debug(String message, Throwable error) {
		this.debug(() -> message, error);
	}

	public void info(String message, Throwable error) {
		this.info(() -> message, error);
	}

	public void warn(String message, Throwable error) {
		this.warn(() -> message, error);
	}

	public void error(String message, Throwable error) {
		this.error(() -> message, error);
	}

	public void debug(Supplier<String> supplier) {
		if (nested.isDebugEnabled()) {
			nested.debug(supplier.get());
		}
	}

	public void info(Supplier<String> supplier) {
		if (nested.isInfoEnabled()) {
			nested.info(supplier.get());
		}
	}

	public void warn(Supplier<String> supplier) {
		if (nested.isWarnEnabled()) {
			nested.warn(supplier.get());
		}
	}

	public void error(Supplier<String> supplier) {
		if (nested.isErrorEnabled()) {
			nested.error(supplier.get());
		}
	}

	public void debug(Supplier<String> supplier, Throwable error) {
		if (nested.isDebugEnabled()) {
			nested.debug(supplier.get(), error);
		}
	}

	public void info(Supplier<String> supplier, Throwable error) {
		if (nested.isInfoEnabled()) {
			nested.info(supplier.get(), error);
		}
	}

	public void warn(Supplier<String> supplier, Throwable error) {
		if (nested.isWarnEnabled()) {
			nested.warn(supplier.get(), error);
		}
	}

	public void error(Supplier<String> supplier, Throwable error) {
		if (nested.isErrorEnabled()) {
			nested.error(supplier.get(), error);
		}
	}

	/** substring */
	private static String substringBefore(final String str, final String separator) {
		if (str == null || str.isEmpty() || separator == null) {
			return str;
		}
		if (separator.isEmpty()) {
			return "";
		}
		final int pos = str.indexOf(separator);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

}
