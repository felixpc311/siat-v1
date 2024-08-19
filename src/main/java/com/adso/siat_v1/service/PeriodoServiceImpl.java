package com.adso.siat_v1.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat_v1.entity.AnioLectivo;
import com.adso.siat_v1.entity.Periodo;
import com.adso.siat_v1.repository.AnioLectivoRepository;
import com.adso.siat_v1.repository.PeriodoRepository;
@Service
public class PeriodoServiceImpl implements PeriodoServiceInterface{

    @Autowired
    private AnioLectivoRepository anioLectivoRepository;
    @Autowired PeriodoRepository periodoRepository;

    @Override
    public Long savePeriodo(Long anioLectivoId, Periodo periodo) {
        // Guardar un nuevo periodo en la base de datos
        // Pasos:
        // 1. Obtener el objeto AnioLectivo por su id
        Optional<AnioLectivo> anioLectivo = anioLectivoRepository.findById(anioLectivoId);
        // 2. Agregar el periodo al conjunto de periodos del anio lectivo
        anioLectivo.get().getPeriodos().add(periodo);
        // 3. Guardar el anio lectivo en la base de datos
        anioLectivoRepository.save(anioLectivo.get());

        return periodo.getId();
        
        
        
    }

    @Override
    public Periodo getPeriodoById(Long id) {
        return periodoRepository.findById(id).orElse(null);
    }
    @Override
    public Set<Periodo> getAllPeriodos() {
        return (Set<Periodo>) periodoRepository.findAll();
    }
    @Override
    public void deletePeriodo(Long periodoId) {
        Optional<Periodo> p = periodoRepository.findById(periodoId);
        if(p.isPresent()) {
            periodoRepository.delete(p.get());
        }
        
    }
        

    @Override
    public void updatePeriodo(Long id, Periodo periodo) {
        Optional<Periodo> p = periodoRepository.findById(id);
        if(p.isPresent()) {
            p.get().setPeriodoNumero(periodo.getPeriodoNumero());
            periodoRepository.save(p.get());
        }
    }
        

}
