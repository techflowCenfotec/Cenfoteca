package com.cenfotec.cenfoteca.contracts;

import java.util.List;

import com.cenfotec.cenfoteca.pojo.UsuarioPOJO;

public class UsersResponse extends BaseResponse{
	
	private List<UsuarioPOJO> usuarios;

	public UsersResponse() {
		super();
	}
	
	public List<UsuarioPOJO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPOJO> usuarios) {
		this.usuarios = usuarios;
	}

}
