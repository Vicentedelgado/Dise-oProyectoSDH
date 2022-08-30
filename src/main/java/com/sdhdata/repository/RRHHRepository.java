package com.sdhdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sdhdata.model.RRHH;
import com.sdhdata.model.SpiDatos;
import com.sdhdata.model.Zona;

@Repository
public interface RRHHRepository extends CrudRepository<RRHH, Long> {
	
	@Query("SELECT u FROM RRHH u WHERE u.idspi=:idspi")
	List<RRHH> Listaporspirrhh(SpiDatos idspi);
	@Query("SELECT u FROM RRHH u WHERE u.idspi=:idspi and u.estado= 'Activo'")
	List<RRHH> ListaporspirrhhFor(SpiDatos idspi);
	@Query("SELECT u FROM RRHH u WHERE u.estado= 'Activo'")
	List<RRHH> ListaporrrhhActivo();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=:idzona")
	List<RRHH> Listaporzonarrhh(Zona idzona);
	@Query("SELECT u FROM RRHH u WHERE u.idzona=1")
	List<RRHH> listarrhhzona1();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=2")
	List<RRHH> listarrhhzona2();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=3")
	List<RRHH> listarrhhzona3();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=4")
	List<RRHH> listarrhhzona4();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=5")
	List<RRHH> listarrhhzona5();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=6")
	List<RRHH> listarrhhzona6();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=7")
	List<RRHH> listarrhhzona7();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=8")
	List<RRHH> listarrhhzona8();
	@Query("SELECT u FROM RRHH u WHERE u.idzona=9")
	List<RRHH> listarrhhzona9();

}
