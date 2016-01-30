package com.cenfotec.cenfoteca.services;

import javax.servlet.http.HttpSession;

import com.cenfotec.cenfoteca.contracts.LoginRequest;
import com.cenfotec.cenfoteca.contracts.LoginResponse;
import com.cenfotec.cenfoteca.ejb.Usuario;

public interface LoginServiceInterface {

	public void checkUser(LoginRequest lr, LoginResponse response, HttpSession currentSession);

}
