package com.arroyo.carlos.juan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String surname;
	
	private String photoUrl;
	
	@OneToOne
	private User userWhoCreated;
	
	private User lastUserWhoModified;
	
	private Customer() {}
	
	public Customer(final String name, final String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Customer(final String name, final String surname, final String photoUrl) {
		this.name = name;
		this.surname = surname;
		this.photoUrl = photoUrl;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public User getUserWhoCreated() {
		return userWhoCreated;
	}

	public User getLastUserWhoModified() {
		return lastUserWhoModified;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public void setLastUserWhoModified(User lastUserWhoModified) {
		this.lastUserWhoModified = lastUserWhoModified;
	}
	
}
