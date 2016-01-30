package com.cenfotec.cenfoteca.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cenfotec.cenfoteca.ejb.Alquiler;

public interface RentRepository extends CrudRepository<Alquiler,Integer> {
}
