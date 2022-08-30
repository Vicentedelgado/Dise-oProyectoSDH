package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Modalidad;
import com.sdhdata.repository.ModalidadRepository;

@Service
@Transactional
public class ModalidadServiceImp implements IModalidadService {
	
	@Autowired
	private ModalidadRepository ModalidadRepository;

	@Override
	public List<Modalidad> listamodalidad() {
		// TODO Auto-generated method stub
		return (List<Modalidad>) ModalidadRepository.findAll();
	}

	@Override
	public void guardar(Modalidad Modalidad) {
		// TODO Auto-generated method stub
		ModalidadRepository.save(Modalidad);

	}

	@Override
	public Modalidad buscarporId(Long idmodalidad) {
		// TODO Auto-generated method stub
		return ModalidadRepository.findById(idmodalidad).orElse(null);
	}

	@Override
	public void eliminar(Long idmodalidad) {
		// TODO Auto-generated method stub
		ModalidadRepository.deleteById(idmodalidad);

	}

}
