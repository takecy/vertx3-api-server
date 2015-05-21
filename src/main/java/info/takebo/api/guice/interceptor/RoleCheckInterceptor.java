/**
 *
 */
package info.takebo.api.guice.interceptor;

import info.takebo.api.annotation.RoleCheck;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 権限チェック
 *
 * @author takecy
 */
public class RoleCheckInterceptor extends AbstractInterceptor<RoleCheck> {

	@Override
	protected RoleCheck beforeInvoke(Class<?> invokeClazz, Method invokeMethod) {
		return invokeMethod.getAnnotation(RoleCheck.class);
	}

	@Override
	protected boolean invokePerArg(Class<?> invokeClazz, Method invokeMethod, RoleCheck beforeReturn, Object arg, Annotation[] annotations) {
		if (beforeReturn == null)
			return true;

		// TODO check authorization
		return true;
	}

}
