package com.cenfotec.cenfoteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.cenfoteca.contracts.TipoUsuarioResponse;
import com.cenfotec.cenfoteca.ejb.TipoUsuario;
import com.cenfotec.cenfoteca.services.TipoUsuarioServiceInterface;

@RestController
@RequestMapping(value ="rest/protected/tipoUsuario")
public class TipoUsuarioController {

	@Autowired private TipoUsuarioServiceInterface tipoUsuarioService;
	
	@RequestMapping(value ="/getAll", method = RequestMethod.GET)
	public TipoUsuarioResponse getAll(){	
			
		TipoUsuarioResponse response = new TipoUsuarioResponse();
		response.setCode(200);
		response.setCodeMessage("users fetch success");
		response.setTipoUsuarioList(tipoUsuarioService.getAll());
		return response;	
		
		
	}
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public TipoUsuarioResponse create(@RequestBody TipoUsuario tUsuario){	
		
		TipoUsuarioResponse rs = new TipoUsuarioResponse();			
		Boolean state = tipoUsuarioService.saveTipoUsuario(tUsuario);
			
		if(state){
			rs.setCode(200);
			rs.setCodeMessage("rent created succesfully");
		}
				
		return rs;		
	}

}
