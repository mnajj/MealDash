package com.mealdash.entities.keys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuthorityKey implements Serializable {
	private String userName;

	private String authority;

	public AuthorityKey() {
	}

	public AuthorityKey(String userName, String authority) {
		this.userName = userName;
		this.authority = authority;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AuthorityKey)) return false;
		AuthorityKey that = (AuthorityKey) o;
		return Objects.equals(getUserName(), that.getUserName()) &&
						Objects.equals(getAuthority(), that.getAuthority());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserName(), getAuthority());
	}
}
