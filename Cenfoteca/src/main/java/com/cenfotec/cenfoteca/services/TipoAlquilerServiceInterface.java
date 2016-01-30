package com.cenfotec.cenfoteca.services;

import java.util.List;

import com.cenfotec.cenfoteca.ejb.TipoAlquiler;
import com.cenfotec.cenfoteca.pojo.TipoAlquilerPOJO;

public interface TipoAlquilerServiceInterface {

	List<TipoAlquilerPOJO> getAll();
	TipoAlquiler getTipoAlquilerById(int idTipoAlquiler);

}
