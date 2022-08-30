package com.sdhdata.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sdhdata.model.Tipo;

@Repository
public interface TipoRepository extends CrudRepository<Tipo, Long> {
		

}
