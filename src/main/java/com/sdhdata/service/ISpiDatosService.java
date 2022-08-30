package com.sdhdata.service;

import java.util.List;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;

public interface ISpiDatosService {
	
	public List<SpiDatos> listaspidatos();
	public void guardar(SpiDatos SpiDatos);
	public SpiDatos buscarPorId(Long idspi);
	public void eliminar(Long idspi);
	public List<SpiDatos> Listaporspi(Long idspi);
	public List<SpiDatos>  FindByZona(Zona idzona);

}
