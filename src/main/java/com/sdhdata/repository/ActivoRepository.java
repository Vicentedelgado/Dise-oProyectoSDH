package com.sdhdata.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Activo;
import com.sdhdata.model.Tipo;

@Repository
public interface ActivoRepository extends CrudRepository<Activo, Long> {
	
	@Query("SELECT u FROM Activo u WHERE u.idtipo=:idtipo")
	public List<Activo> Buscarportipo(Tipo idtipo);
	
	

}
