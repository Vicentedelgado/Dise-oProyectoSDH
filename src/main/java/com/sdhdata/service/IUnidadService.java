package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Unidad;

public interface IUnidadService{
	
	public List<Unidad> listaunidad();
	public void guardar (Unidad Unidad);
	public Unidad buscarporId(Long idunidad);
	public void eliminar(Long idunidad);

}
