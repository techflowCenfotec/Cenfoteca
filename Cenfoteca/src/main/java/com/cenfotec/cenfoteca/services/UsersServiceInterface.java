package com.cenfotec.cenfoteca.services;

import java.util.List;

import com.cenfotec.cenfoteca.contracts.UsersRequest;
import com.cenfotec.cenfoteca.pojo.UsuarioPOJO;

public interface UsersServiceInterface {

	List<UsuarioPOJO> getAll(UsersRequest ur);
	List<UsuarioPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
	List<UsuarioPOJO> getAlquileres(UsersRequest ur);
}
