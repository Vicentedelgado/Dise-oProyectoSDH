package com.sdhdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
import com.sdhdata.repository.RRHHRepository;

@Service
@Transactional
public class RRHHServiceImp implements IRRHHService {
	
	@Autowired
	private RRHHRepository RRHHRepository;

	@Override
	public List<RRHH> listarrrhh() {
		// TODO Auto-generated method stub
		return (List<RRHH>) RRHHRepository.findAll();
	}

	@Override
	public void guardar(RRHH RRHH) {
		// TODO Auto-generated method stub
		RRHHRepository.save(RRHH);

	}

	@Override
	public RRHH buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return RRHHRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		RRHHRepository.deleteById(id);

	}

	@Override
	public List<RRHH> Listaporspirrhh(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return RRHHRepository.Listaporspirrhh(idspi);
	}
	
	@Override
	public List<RRHH> ListaporspirrhhFor(SpiDatos idspi) {
		// TODO Auto-generated method stub
		return RRHHRepository.ListaporspirrhhFor(idspi);
	}
	
	@Override
	public List<RRHH> Listaporzonarrhh(Zona idzona) {
		// TODO Auto-generated method stub
		return RRHHRepository.Listaporzonarrhh(idzona);
	}

	@Override
	public List<RRHH> listarrhhzona1() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona1();
	}

	@Override
	public List<RRHH> listarrhhzona2() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona2();
	}

	@Override
	public List<RRHH> listarrhhzona3() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona3();
	}

	@Override
	public List<RRHH> listarrhhzona4() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona4();
	}

	@Override
	public List<RRHH> listarrhhzona5() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona5();
	}

	@Override
	public List<RRHH> listarrhhzona6() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona6();
	}

	@Override
	public List<RRHH> listarrhhzona7() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona7();
	}

	@Override
	public List<RRHH> listarrhhzona8() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona8();
	}

	@Override
	public List<RRHH> listarrhhzona9() {
		// TODO Auto-generated method stub
		return RRHHRepository.listarrhhzona9();
	}

	@Override
	public List<RRHH> ListaporrrhhActivo() {
		// TODO Auto-generated method stub
		return RRHHRepository.ListaporrrhhActivo();
	}

		

}
