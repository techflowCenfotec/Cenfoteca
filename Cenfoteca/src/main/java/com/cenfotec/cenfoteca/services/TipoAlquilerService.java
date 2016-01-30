package com.cenfotec.cenfoteca.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cenfotec.cenfoteca.ejb.TipoAlquiler;
import com.cenfotec.cenfoteca.pojo.TipoAlquilerPOJO;
import com.cenfotec.cenfoteca.repositories.TipoAlquilerRepository;

@Service
public class TipoAlquilerService implements TipoAlquilerServiceInterface{

	@Autowired private TipoAlquilerRepository tipoAlquilerRepository;
	
	@Override
	@Transactional
	public List<TipoAlquilerPOJO> getAll() {
		List<TipoAlquiler> tipos = tipoAlquilerRepository.findAll();
		List<TipoAlquilerPOJO> dtos = new ArrayList<TipoAlquilerPOJO>();
		tipos.stream().forEach(ta ->{
			TipoAlquilerPOJO dto = new TipoAlquilerPOJO();
			BeanUtils.copyProperties(ta, dto);
			dtos.add(dto);
		});
		return dtos;
	}

	@Override
	public TipoAlquiler getTipoAlquilerById(int idTipoAlquiler) {
		return tipoAlquilerRepository.findOne(idTipoAlquiler);
	}
}