/**
 *
 */
package info.takebo.api.guice.interceptor;

import info.takebo.api.logger.LoggerWrapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.Nullable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * {@link MethodInterceptor}のbase
 *
 * @author takecy
 */
public abstract class AbstractInterceptor<T> implements MethodInterceptor {

	protected LoggerWrapper logger = new LoggerWrapper(this.getClass(), "$$");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object invoke(MethodInvocation methodInvocation) throws Throwable {

		final Class<?> invokeClazz = methodInvocation.getThis().getClass();
		final Method invokeMethod = methodInvocation.getMethod();
		final String declaredClassName = invokeMethod.getDeclaringClass().getSimpleName();

		// Objectクラスは無視
		if (declaredClassName.equalsIgnoreCase(Object.class.getSimpleName()))
			return methodInvocation.proceed();

		// 前処理
		T beforeReturn = beforeInvoke(invokeClazz, invokeMethod);

		// メソッド引数一覧
		Object[] args = methodInvocation.getArguments();
		// メソッドの引数アノテーション一覧
		Annotation[][] annotationmap = invokeMethod.getParameterAnnotations();

		// 全引数への処理
		invokeAllArgs(invokeClazz, invokeMethod, beforeReturn, args, annotationmap);

		// 各引数への処理
		for (int i = 0; i < annotationmap.length; i++) {
			boolean isBreak = invokePerArg(invokeClazz, invokeMethod, beforeReturn, args[i], annotationmap[i]);
			if (isBreak)
				break;
		}

		// 本来の処理
		Object obj = methodInvocation.proceed();

		// 後処理
		afterInvoke(invokeClazz, invokeMethod, beforeReturn, args, annotationmap);

		return obj;
	}

	/**
	 * 処理の前に実行する
	 *
	 * @param invokeClazz
	 * @param invokeMethod
	 * @return
	 */
	protected T beforeInvoke(Class<?> invokeClazz, Method invokeMethod) {
		return null;
	};

	/**
	 * 処理の後に実行する
	 *
	 * @param invokeClazz
	 * @param invokeMethod
	 * @param beforeReturn {@link AbstractInterceptor#beforeInvoke(Class, Method)の戻り値}
	 * @param args 引数の配列
	 * @param annotationmap 引数のアノテーション
	 */
	protected void afterInvoke(Class<?> invokeClazz, Method invokeMethod, @Nullable T beforeReturn, Object[] args, Annotation[][] annotationmap) {};

	/**
	 * 各引数に対して実行する
	 *
	 * @param invokeClazz
	 * @param invokeMethod
	 * @param beforeReturn {@link AbstractInterceptor#beforeInvoke(Class, Method)の戻り値}
	 * @param arg 引数の値
	 * @param annotations 引数に付加されているアノテーション
	 * @return breakするか
	 */
	protected boolean invokePerArg(Class<?> invokeClazz, Method invokeMethod, @Nullable T beforeReturn, Object arg, Annotation[] annotations) {
		return false;
	};

	/**
	 * 引数全てに対して実行する
	 *
	 * @param invokeClazz
	 * @param invokeMethod
	 * @param beforeReturn {@link AbstractInterceptor#beforeInvoke(Class, Method)の戻り値}
	 * @param args 引数の配列
	 * @param annotationmap 引数のアノテーション
	 */
	protected void invokeAllArgs(Class<?> invokeClazz, Method invokeMethod, @Nullable T beforeReturn, Object[] args, Annotation[][] annotationmap) {};

}
