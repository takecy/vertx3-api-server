/**
 * takecy
 */
package info.takebo.api.entity;

import info.takebo.api.enums.Gender;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author takecy
 */
public class User {

	private String id;
	private String name;
	private Integer age;
	private String address;
	private String mail;
	private Gender gender;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
