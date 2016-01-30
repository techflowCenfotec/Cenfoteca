package com.cenfotec.cenfoteca.services;

import java.util.List;

import com.cenfotec.cenfoteca.ejb.TipoUsuario;
import com.cenfotec.cenfoteca.pojo.TipoUsuarioPOJO;

public interface TipoUsuarioServiceInterface {
	List<TipoUsuarioPOJO> getAll();
	TipoUsuario getTipoUsuarioById(int idTipoUsuario);
	Boolean saveTipoUsuario(TipoUsuario tipoUsuario);
}
