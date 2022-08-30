package com.sdhdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Unidad;

@Repository
public interface UnidadRepository extends CrudRepository<Unidad, Long>{

}
