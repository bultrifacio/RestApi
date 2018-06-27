package com.arroyo.carlos.juan.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private Long id;
	
	@Column(name = "customer_name", nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String surname;
	
	@Column(name = "photo_url")
	private String photoURL;
	
	@Column(name = "creator_user_id", updatable = false)
	private Long creatorUserId;
	
	@Column(name = "last_modification_user_id")
	private Long lastModificationUserId;
	
	public Customer() {}
	
	public Customer(String name, String surname, Long creatorUserId, Long lastModificationUserId) {
		super();
		this.name = name;
		this.surname = surname;
		this.creatorUserId = creatorUserId;
		this.lastModificationUserId = lastModificationUserId;
	}

	public Customer(String name, String surname, String photoURL, Long creatorUserId,
			Long lastModificationUserId) {
		super();
		this.name = name;
		this.surname = surname;
		this.photoURL = photoURL;
		this.creatorUserId = creatorUserId;
		this.lastModificationUserId = lastModificationUserId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public Long getCreatorUserId() {
		return creatorUserId;
	}

	public Long getLastModificationUserId() {
		return lastModificationUserId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public void setCreatorUserId(Long creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public void setLastModificationUserId(Long lastModificationUserId) {
		this.lastModificationUserId = lastModificationUserId;
	}

	
}
