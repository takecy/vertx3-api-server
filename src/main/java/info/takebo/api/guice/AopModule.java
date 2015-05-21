package info.takebo.api.guice;

import info.takebo.api.annotation.RoleCheck;
import info.takebo.api.guice.interceptor.RoleCheckInterceptor;
import info.takebo.api.guice.matcher.PublicOrProtectedMethodMatcher;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @author takecy
 */
public class AopModule extends AbstractModule {
	@Override
	protected void configure() {
		bindInterceptor(Matchers.any(),
		                (new PublicOrProtectedMethodMatcher()).and(Matchers.annotatedWith(RoleCheck.class)),
						new RoleCheckInterceptor());
	}
}
