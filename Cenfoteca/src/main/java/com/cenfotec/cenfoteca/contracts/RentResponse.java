package com.cenfotec.cenfoteca.contracts;

import java.util.List;

import com.cenfotec.cenfoteca.pojo.AlquilerPOJO;

public class RentResponse extends BaseResponse{
	
	private List<AlquilerPOJO> alquilerList;
	
	public RentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<AlquilerPOJO> getAlquilerList() {
		return alquilerList;
	}

	public void setAlquilerList(List<AlquilerPOJO> alquilerList) {
		this.alquilerList = alquilerList;
	}
}
