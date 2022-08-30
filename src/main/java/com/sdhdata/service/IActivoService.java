package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;

public interface IActivoService {
	
	public List<Activo> listaactivo();
	public void guardar(Activo Activo);
	public Activo buscarPorId(Long idactivo);
	public void eliminar(Long idactivo);
	public List<Activo> Buscarportipo(Tipo idtipo);
	

}
