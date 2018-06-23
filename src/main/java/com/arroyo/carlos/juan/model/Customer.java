package com.arroyo.carlos.juan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "customer_name", nullable = false)
	private String name;

	@Column(name = "surname", nullable = false)
	private String surname;

	@Column(name = "photo_url")
	private String photoUrl;

	@Column(name = "creator_user_id", nullable = false)
	private Long creatorUserId;

	@Column(name = "last_modifitacion_user_id", nullable = false)
	private Long lastModificationUserId;

	private Customer() {
	}

	public Customer(final String name, final String surname, final Long creatorUserId,
			final Long lastModificationUserId) {
		this.name = name;
		this.surname = surname;
		this.creatorUserId = creatorUserId;
		this.lastModificationUserId = lastModificationUserId;
	}

	public Customer(final String name, final String surname, final String photoUrl, final Long creatorUserId,
			final Long lastModificationUserId) {
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
