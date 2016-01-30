package com.cenfotec.cenfoteca.ejb;


import java.io.Serializable;
import javax.persistence.*;



@Entity
@NamedQuery(name="TipoUsuario.findAll", query="SELECT t FROM TipoUsuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtipousuario;
	
	private String nombretipo;
	
	public TipoUsuario(){
		
	}

	public int getIdtipo() {
		return idtipousuario;
	}

	public void setIdtipo(int idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	public String getNombretipo() {
		return nombretipo;
	}

	public void setNombretipo(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	
	
}
