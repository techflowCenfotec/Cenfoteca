package com.cenfotec.cenfoteca.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cenfotec.cenfoteca.contracts.RentResponse;
import com.cenfotec.cenfoteca.ejb.Alquiler;
import com.cenfotec.cenfoteca.services.RentServiceInterface;
import com.cenfotec.cenfoteca.services.TipoAlquilerServiceInterface;
import com.cenfotec.cenfoteca.utils.Utils;


/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping(value ="rest/protected/rent")
public class RentController {
	
	@Autowired private ServletContext servletContext;
	@Autowired private TipoAlquilerServiceInterface tipoAlquilerService;
	@Autowired private RentServiceInterface rentService;
	
	@RequestMapping(value ="/create", method = RequestMethod.POST)
	public RentResponse create(
			@RequestParam("file") MultipartFile file,
			@RequestParam("idTipoAlquiler") int idTipoAlquiler,
			@RequestParam("name") String name,
			@RequestParam("description") String description){	
		
		RentResponse rs = new RentResponse();
		String resultFileName = Utils.writeToFile(file,servletContext);
		if(!resultFileName.equals("")){
			
			Alquiler alquiler = new Alquiler();
			alquiler.setName(name);
			alquiler.setDescription(description);
			alquiler.setImage(resultFileName);
			alquiler.setTipoAlquiler(tipoAlquilerService.getTipoAlquilerById(idTipoAlquiler));
			
			Boolean state = rentService.saveRent(alquiler);
			
			if(state){
				rs.setCode(200);
				rs.setCodeMessage("rent created succesfully");
			}
			
		}else{
			//create a common webservice error codes enum or statics
			rs.setCode(409);
			rs.setErrorMessage("create/edit conflict");
		}
	
		return rs;		
	}
	
}
