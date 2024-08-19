package com.adso.siat_v1.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat_v1.entity.Periodo;

@Repository
public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
    
}
