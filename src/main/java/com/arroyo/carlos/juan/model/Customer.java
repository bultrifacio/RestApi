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
	private Long creatorUserId;
	
	private Long lastModificationUserId;
	
	private Customer() {}
	
	public Customer(final String name, final String surname, final Long creatorUserId, final Long lastModificationUserId) {
		this.name = name;
		this.surname = surname;
		this.creatorUserId = creatorUserId;
		this.lastModificationUserId = lastModificationUserId;
	}
	
	public Customer(final String name, final String surname, final String photoUrl, final Long creatorUserId, final Long lastModificationUserId) {
		this.name = name;
		this.surname = surname;
		this.photoUrl = photoUrl;
		this.creatorUserId = creatorUserId;
		this.lastModificationUserId = lastModificationUserId;
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


	public void setName(String name) {
		this.name = name;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public Long getLastModificationUserId() {
		return lastModificationUserId;
	}

	public void setLastModificationUserId(Long lastModificationUserId) {
		this.lastModificationUserId = lastModificationUserId;
	}

	
}
