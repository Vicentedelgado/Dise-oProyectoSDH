package com.sdhdata.service;

import java.util.List;

import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;
public interface IRRHHService {
	
	public List<RRHH> listarrrhh();
	public void guardar(RRHH RRHH);
	public RRHH buscarPorId(Long id);
	public void eliminar(Long id);
	public List<RRHH> Listaporspirrhh(SpiDatos idspi);
	public List<RRHH> ListaporspirrhhFor(SpiDatos idspi);
	public List<RRHH> ListaporrrhhActivo();
	public List<RRHH> Listaporzonarrhh(Zona idzona);
	public List<RRHH> listarrhhzona1();
	public List<RRHH> listarrhhzona2();
	public List<RRHH> listarrhhzona3();
	public List<RRHH> listarrhhzona4();
	public List<RRHH> listarrhhzona5();
	public List<RRHH> listarrhhzona6();
	public List<RRHH> listarrhhzona7();
	public List<RRHH> listarrhhzona8();
	public List<RRHH> listarrhhzona9();

}
