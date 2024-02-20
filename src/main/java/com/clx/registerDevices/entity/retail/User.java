package com.clx.registerDevices.entity.retail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	private static final long serialVersionUID = -3836909091472938282L;

	@Id
	@Column(name = "USER_ID", length=64)
	private String guid;
	
	@Column(name = "USER_NAME", length=100)
	private String username;

	@Column(name = "UUID_TRUSTED")
	private String uuidTrusted;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUuidTrusted() {
		return uuidTrusted;
	}

	public void setUuidTrusted(String uuidTrusted) {
		this.uuidTrusted = uuidTrusted;
	}
}
