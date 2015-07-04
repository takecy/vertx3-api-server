/**
 *
 */
package info.takebo.api.annotation;

import info.takebo.api.constant.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author takecy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
public @interface RoleCheck {
    Role[] values() default {Role.GENERAL};
}
