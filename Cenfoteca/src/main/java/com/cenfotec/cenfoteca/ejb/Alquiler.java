package com.cenfotec.cenfoteca.ejb;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Alquiler database table.
 * 
 */
@Entity
@NamedQuery(name="Alquiler.findAll", query="SELECT a FROM Alquiler a")
public class Alquiler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAlquiler;

	private String description;

	private String image;

	private String name;

	//bi-directional many-to-one association to TipoAlquiler
	@ManyToOne
	private TipoAlquiler tipoAlquiler;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="alquilers")
	private List<Usuario> usuarios;

	public Alquiler() {
	}

	public int getIdAlquiler() {
		return this.idAlquiler;
	}

	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TipoAlquiler getTipoAlquiler() {
		return this.tipoAlquiler;
	}

	public void setTipoAlquiler(TipoAlquiler tipoAlquiler) {
		this.tipoAlquiler = tipoAlquiler;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}