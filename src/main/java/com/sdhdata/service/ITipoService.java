package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.Tipo;

public interface ITipoService {
	
	public List<Tipo> listatipos();
	public void guardar (Tipo Tipo);
	public Tipo buscarporId(Long idtipo);
	public void eliminar(Long idtipo);

}
