package com.sdhdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Institucion;

@Repository
public interface InstitucionRepository extends CrudRepository<Institucion, Long> {

}
