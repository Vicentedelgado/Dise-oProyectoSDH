package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.Zona;
import com.sdhdata.repository.ZonaRepository;

@Service
@Transactional
public class ZonaServiceImp implements IZonaService {
	
	@Autowired
	private ZonaRepository ZonaRepository;

	@Override
	public List<Zona> listazona() {
		// TODO Auto-generated method stub
		return (List<Zona>) ZonaRepository.findAll();
	}

	@Override
	public void guardar(Zona Zona) {
		// TODO Auto-generated method stub
		ZonaRepository.save(Zona);
	}

	@Override
	public Zona buscarPorId(Long idzona) {
		// TODO Auto-generated method stub
		return ZonaRepository.findById(idzona).orElse(null);
	}

	@Override
	public void eliminar(Long idzona) {
		// TODO Auto-generated method stub
		ZonaRepository.deleteById(idzona);

	}

	@Override
	public List<Zona> listaporzona(Long idzona) {
		// TODO Auto-generated method stub
		return (List<Zona>) ZonaRepository.findAllById(null);
	}

}
