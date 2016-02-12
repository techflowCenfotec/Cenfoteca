package com.cenfotec.cenfoteca.services;

import java.util.List;

import com.cenfotec.cenfoteca.ejb.Alquiler;
import com.cenfotec.cenfoteca.pojo.AlquilerPOJO;


public interface RentServiceInterface {
	List<AlquilerPOJO> getAll();
	Alquiler saveRent(Alquiler alquiler);
	Boolean deleteRent(int idRent);
}
