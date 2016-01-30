package com.cenfotec.cenfoteca.contracts;

import java.util.List;

import com.cenfotec.cenfoteca.pojo.TipoAlquilerPOJO;

public class TipoAlquilerResponse extends BaseResponse{
	
	private List<TipoAlquilerPOJO> tipoAlquilerList;

	public TipoAlquilerResponse() {
		super();
	}

	public List<TipoAlquilerPOJO> getTipoAlquilerList() {
		return tipoAlquilerList;
	}

	public void setTipoAlquilerList(List<TipoAlquilerPOJO> tipoAlquilerList) {
		this.tipoAlquilerList = tipoAlquilerList;
	}
	
}
