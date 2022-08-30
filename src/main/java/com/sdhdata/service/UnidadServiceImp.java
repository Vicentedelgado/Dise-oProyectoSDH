package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Unidad;
import com.sdhdata.repository.UnidadRepository;

@Service
@Transactional
public class UnidadServiceImp implements IUnidadService {
	
	@Autowired
	private UnidadRepository UnidadRepository;

	@Override
	public List<Unidad> listaunidad() {
		// TODO Auto-generated method stub
		return (List<Unidad>) UnidadRepository.findAll();
	}

	@Override
	public void guardar(Unidad Unidad) {
		// TODO Auto-generated method stub
		UnidadRepository.save(Unidad);

	}

	@Override
	public Unidad buscarporId(Long idunidad) {
		// TODO Auto-generated method stub
		return UnidadRepository.findById(idunidad).orElse(null);
	}

	@Override
	public void eliminar(Long idunidad) {
		// TODO Auto-generated method stub
		UnidadRepository.deleteById(idunidad);

	}

}
