package com.adso.siat_v1.service;

import java.util.Set;

import com.adso.siat_v1.entity.Periodo;

public interface PeriodoServiceInterface {
    public Long savePeriodo(Long anioLectivoId, Periodo periodo);
    public Periodo getPeriodoById(Long id);
    public Set<Periodo> getAllPeriodos();
    public void deletePeriodo(Long id);
    public void updatePeriodo(Long id, Periodo periodo);	
}
