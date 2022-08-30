package com.sdhdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.RegistrodelSpi;
import com.sdhdata.model.SpiDatos;

@Repository
public interface RegistroDelSpiRepository extends CrudRepository<RegistrodelSpi, Long> {
	
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=1")
	List<RegistrodelSpi> Listaregistrodelspiinstalaciones(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=2")
	List<RegistrodelSpi> Listaregistrodelspibienes(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=3")
	List<RegistrodelSpi> Listaregistrodelspiequipos(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=4")
	List<RegistrodelSpi> Listaregistrodelspiotros(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=5")
	List<RegistrodelSpi> Listaregistrodelspimovilidad(SpiDatos idspi);
	@Query("SELECT u FROM RegistrodelSpi u WHERE u.idspi=:idspi and u.idactivo.idtipo=6")
	List<RegistrodelSpi> Listaregistrodelspiconectividad(SpiDatos idspi);

}
