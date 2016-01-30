package com.cenfotec.cenfoteca.contracts;

import com.cenfotec.cenfoteca.pojo.TipoUsuarioPOJO;

public class TipoUsuarioRequest extends BaseRequest {

	private TipoUsuarioPOJO tipoUsuario;
	
	public TipoUsuarioRequest(String nombretipo){
		super();
	}
	
	public TipoUsuarioPOJO getTipoUsuario(){
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuarioPOJO tipoUsuario){
		this.tipoUsuario = tipoUsuario;
	}
	
	@Override
	public String toString() {
		return "TipoUsuarioRequest [tipoUsuario=" + tipoUsuario + "]";
	}
}
