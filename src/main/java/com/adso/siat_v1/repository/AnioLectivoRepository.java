package com.adso.siat_v1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adso.siat_v1.entity.AnioLectivo;


@Repository
public interface AnioLectivoRepository extends CrudRepository<AnioLectivo, Long> {
  
}
