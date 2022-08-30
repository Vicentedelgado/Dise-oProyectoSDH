package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Institucion;

public interface IInstitucionService {
	
	public List<Institucion> listainstitucion();
	public void guardar(Institucion Institucion);
	public Institucion buscarPorId(Long idinstitucion);
	public void eliminar(Long idinstitucion);

}
