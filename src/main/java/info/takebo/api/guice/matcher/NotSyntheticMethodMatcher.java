/**
 *
 */
package info.takebo.api.guice.matcher;

import java.lang.reflect.Method;

import com.google.inject.matcher.AbstractMatcher;

/**
 * 合成メソッドを除外するMatcher
 *
 * @author takecy
 */
public class NotSyntheticMethodMatcher extends AbstractMatcher<Method> {

	@Override
	public boolean matches(Method method) {
		return method.isSynthetic() == false;
	}

}
