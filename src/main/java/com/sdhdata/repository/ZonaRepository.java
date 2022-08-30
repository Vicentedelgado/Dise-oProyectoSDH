package com.sdhdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Zona;

@Repository
public interface ZonaRepository extends CrudRepository<Zona, Long> {

}
