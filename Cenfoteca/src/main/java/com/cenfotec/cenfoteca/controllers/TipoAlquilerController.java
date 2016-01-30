package com.cenfotec.cenfoteca.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.cenfoteca.contracts.TipoAlquilerResponse;
import com.cenfotec.cenfoteca.services.TipoAlquilerServiceInterface;
import com.cenfotec.cenfoteca.services.UsersServiceInterface;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/tipoAlquiler")
public class TipoAlquilerController {
	
	@Autowired private UsersServiceInterface usersService;
	@Autowired private TipoAlquilerServiceInterface tipoAlquilerService;
	@Autowired private HttpServletRequest request;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public TipoAlquilerResponse getAll(){	
			
		TipoAlquilerResponse response = new TipoAlquilerResponse();
		response.setCode(200);
		response.setCodeMessage("users fetch success");
		response.setTipoAlquilerList(tipoAlquilerService.getAll());
		return response;		
	}
}
