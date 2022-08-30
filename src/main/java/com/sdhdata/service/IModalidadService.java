package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Modalidad;

public interface IModalidadService {
	
	public List<Modalidad> listamodalidad();
	public void guardar (Modalidad Modalidad);
	public Modalidad buscarporId(Long idmodalidad);
	public void eliminar(Long idmodalidad);

}
