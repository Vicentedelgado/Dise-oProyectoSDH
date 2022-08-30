package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Institucion;
import com.sdhdata.repository.InstitucionRepository;

@Service
@Transactional
public class InstitucionServiceImp implements IInstitucionService {
	
	@Autowired
	private InstitucionRepository InstitucionRepository;

	@Override
	public List<Institucion> listainstitucion() {
		// TODO Auto-generated method stub
		return (List<Institucion>) InstitucionRepository.findAll();
	}

	@Override
	public void guardar(Institucion Institucion) {
		// TODO Auto-generated method stub
		InstitucionRepository.save(Institucion);
	}

	@Override
	public Institucion buscarPorId(Long idinstitucion) {
		// TODO Auto-generated method stub
		return InstitucionRepository.findById(idinstitucion).orElse(null);
	}

	@Override
	public void eliminar(Long idinstitucion) {
		// TODO Auto-generated method stub
		InstitucionRepository.deleteById(idinstitucion);

	}

}
