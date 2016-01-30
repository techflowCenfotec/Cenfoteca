package com.cenfotec.cenfoteca.contracts;

import java.util.List;

import com.cenfotec.cenfoteca.pojo.TipoUsuarioPOJO;


public class TipoUsuarioResponse extends BaseResponse{

	private List<TipoUsuarioPOJO> tipoUsuarioList;

	public TipoUsuarioResponse() {
		super();
	}

	public List<TipoUsuarioPOJO> getTipoUsuarioList() {
		return tipoUsuarioList;
	}

	public void setTipoUsuarioList(List<TipoUsuarioPOJO> tipoUsuarioList) {
		this.tipoUsuarioList = tipoUsuarioList;
	}
}
