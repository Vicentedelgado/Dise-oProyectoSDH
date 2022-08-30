package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.SpiDatosRepository;

@Service
@Transactional
public class SpiDatosImp implements ISpiDatosService {

	@Autowired
	private SpiDatosRepository SpiDatosRepository;
	
	@Override
	public List<SpiDatos> listaspidatos() {
		// TODO Auto-generated method stub
		return (List<SpiDatos>) SpiDatosRepository.findAll();
	}

	@Override
	public void guardar(SpiDatos SpiDatos) {
		// TODO Auto-generated method stub
		SpiDatosRepository.save(SpiDatos);

	}

	@Override
	public SpiDatos buscarPorId(Long idspi) {
		// TODO Auto-generated method stub
		return SpiDatosRepository.findById(idspi).orElse(null);
	}

	@Override
	public void eliminar(Long idspi) {
		// TODO Auto-generated method stub
		SpiDatosRepository.deleteById(idspi);

	}

	@Override
	public List<SpiDatos> Listaporspi(Long idspi) {
		// TODO Auto-generated method stub
		return SpiDatosRepository.Listaporspi(idspi);
	}

	@Override
	public List<SpiDatos> FindByZona(Zona idzona) {
		// TODO Auto-generated method stub
		return SpiDatosRepository.FindByZona(idzona);
	}

	
	
}
