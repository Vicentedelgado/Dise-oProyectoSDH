package com.sdhdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;
import com.sdhdata.repository.ActivoRepository;

@Service
@Transactional
public class ActivoServiceImp implements IActivoService {
	
	@Autowired
	private ActivoRepository ActivoRepository;

	@Override
	public List<Activo> listaactivo() {
		// TODO Auto-generated method stub
		return (List<Activo>) ActivoRepository.findAll();
	}

	@Override
	public void guardar(Activo Activo) {
		// TODO Auto-generated method stub
		ActivoRepository.save(Activo);

	}

	@Override
	public Activo buscarPorId(Long idactivo) {
		Optional<Activo> option = ActivoRepository.findById(idactivo);
		return option.isPresent() ? option.get(): new Activo();
	}

	@Override
	public void eliminar(Long idactivo) {
		// TODO Auto-generated method stub
		ActivoRepository.deleteById(idactivo);

	}

	@Override
	public List<Activo> Buscarportipo(Tipo idtipo) {
		// TODO Auto-generated method stub
		return ActivoRepository.Buscarportipo(idtipo);
	}
	

	
}
