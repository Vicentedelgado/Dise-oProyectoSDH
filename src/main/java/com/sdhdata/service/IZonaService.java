package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Zona;

public interface IZonaService {
	
	public List<Zona> listazona();
	public List<Zona> listaporzona(Long idzona);
	public void guardar(Zona Zona);
	public Zona buscarPorId(Long idzona);
	public void eliminar(Long idzona);

}
