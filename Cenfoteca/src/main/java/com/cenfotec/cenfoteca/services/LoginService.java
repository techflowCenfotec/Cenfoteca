package com.cenfotec.cenfoteca.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cenfotec.cenfoteca.contracts.LoginRequest;
import com.cenfotec.cenfoteca.contracts.LoginResponse;
import com.cenfotec.cenfoteca.ejb.Usuario;
import com.cenfotec.cenfoteca.repositories.LoginRepository;

@Service
public class LoginService implements LoginServiceInterface{

	@Autowired private LoginRepository loginRepository;
	
	@Override
	@Transactional
	public void checkUser(LoginRequest lr, LoginResponse response, HttpSession currentSession) {
		Usuario loggedUser = loginRepository.findByEmailAndPassword(lr.getEmail(), lr.getPassword());
		if(loggedUser == null){
			response.setCode(401);
			response.setErrorMessage("Unauthorized User");
		}else{
			response.setCode(200);
			response.setCodeMessage("User authorized");
			
			//CREATE AND SET THE VALUES FOR THE CONTRACT OBJECT
			response.setIdUsuario(loggedUser.getIdUsuario());
			response.setFirstName(loggedUser.getFirstname());
			response.setLastName(loggedUser.getLastname());
			//
			currentSession.setAttribute("idUser", loggedUser.getIdUsuario());
		}
	}		
}