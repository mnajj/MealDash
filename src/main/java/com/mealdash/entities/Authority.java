package com.mealdash.entities;

import com.mealdash.entities.keys.AuthorityKey;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityKey.class)
public class Authority {
	@Id
	@Column(name = "username")
	private String userName;
	@Id
	@Column(name = "authority")
	private String authority;

	public Authority() {
	}


}
