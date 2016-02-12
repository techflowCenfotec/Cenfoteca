package com.cenfotec.cenfoteca.pojo;

import com.cenfotec.cenfoteca.ejb.TipoAlquiler;

public class AlquilerPOJO{
	
	private int idAlquiler;
	private String name;
	private String description;
	private String image;
	private TipoAlquilerPOJO tipoAlquiler;
	

	public AlquilerPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public TipoAlquilerPOJO getTipoAlquiler() {
		return tipoAlquiler;
	}

	public void setTipoAlquilerPOJO(TipoAlquilerPOJO tipoAlquiler) {
		this.tipoAlquiler = tipoAlquiler;
	}
}
