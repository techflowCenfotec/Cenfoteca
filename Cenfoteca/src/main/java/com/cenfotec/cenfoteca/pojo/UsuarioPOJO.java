package com.cenfotec.cenfoteca.pojo;

import java.util.List;

public class UsuarioPOJO{
	
	private int idUsuario;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	private List<AlquilerPOJO> alquileres;
	
	public UsuarioPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AlquilerPOJO> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<AlquilerPOJO> alquileres) {
		this.alquileres = alquileres;
	}
}
