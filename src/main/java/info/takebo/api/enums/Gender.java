/**
 * takecy
 */
package info.takebo.api.enums;

import com.google.common.base.CaseFormat;

/**
 * @author takecy
 */
public enum Gender {
	MALE,
	FEMALE;

	@Override
	public String toString() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, this.name());
	}
}
