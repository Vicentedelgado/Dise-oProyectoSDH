package com.sdhdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Modalidad;

@Repository
public interface ModalidadRepository extends CrudRepository<Modalidad, Long>{

}
