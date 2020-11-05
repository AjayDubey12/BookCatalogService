package com.dubey.entity;

public class Author extends GenericBean {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	
	public Author() {}

	public Author(long id, String firstName, String lastName) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + "]";
	};
	
	
}
