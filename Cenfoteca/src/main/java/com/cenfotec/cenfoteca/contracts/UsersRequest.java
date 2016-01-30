package com.cenfotec.cenfoteca.contracts;

import com.cenfotec.cenfoteca.pojo.UsuarioPOJO;

public class UsersRequest extends BaseRequest {
	
	private UsuarioPOJO user;
	
	public UsersRequest() {
		super();
	}
	
	public UsuarioPOJO getUser() {
		return user;
	}
	
	public void setUser(UsuarioPOJO user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UsersRequest [user=" + user + "]";
	}
}
