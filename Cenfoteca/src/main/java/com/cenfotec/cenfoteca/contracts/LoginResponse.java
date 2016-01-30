package com.cenfotec.cenfoteca.contracts;


public class LoginResponse extends BaseResponse {
	
	private int idUser;
	private String firstName;
	private String lastName; 

	public LoginResponse() {
		super();
	}
	
	public int getIdUsuario() {
		return idUser;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUser = idUsuario;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

}
