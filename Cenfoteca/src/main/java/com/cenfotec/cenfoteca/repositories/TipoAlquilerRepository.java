package com.cenfotec.cenfoteca.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cenfotec.cenfoteca.ejb.TipoAlquiler;

public interface TipoAlquilerRepository extends CrudRepository<TipoAlquiler,Integer> {
	List<TipoAlquiler> findAll();
}
