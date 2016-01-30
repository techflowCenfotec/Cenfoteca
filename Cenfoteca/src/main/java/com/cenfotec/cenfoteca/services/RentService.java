package com.cenfotec.cenfoteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.cenfoteca.ejb.Alquiler;
import com.cenfotec.cenfoteca.repositories.RentRepository;

@Service
public class RentService implements RentServiceInterface{

	@Autowired private RentRepository rentRepository;
	
	@Override
	public Boolean saveRent(Alquiler alquiler) {
		Alquiler nalquiler = rentRepository.save(alquiler);
		return (nalquiler == null) ? false : true;
	}
}