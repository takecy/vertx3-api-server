/**
 *
 */
package info.takebo.api.annotation;

import info.takebo.api.constant.Role;

/**
 * @author takecy
 */
public @interface RoleCheck {
	Role[] values() default { Role.GENERAL };
}
