package com.adso.siat_v1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.siat_v1.entity.AnioLectivo;
import com.adso.siat_v1.repository.AnioLectivoRepository;

@Service
public class AnioLectivoServiceImpl implements AnioLectivoServiceInterface {
    @Autowired
    private AnioLectivoRepository anioLectivoRepository;

    @Override
    public void saveAnioLectivo(AnioLectivo anioLectivo) {
        anioLectivoRepository.save(anioLectivo);
        
    }

    @Override
    public AnioLectivo getAnioLectivoById(Long id) {
        return anioLectivoRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<AnioLectivo> getAllAnioLectivos() {
        return anioLectivoRepository.findAll();
    }

    @Override
    public void deleteAnioLectivo(Long id) {
        anioLectivoRepository.deleteById(id);
    }

    @Override
    public void updateAnioLectivo(Long id, AnioLectivo anioLectivo) {
        AnioLectivo anioLectivoDB = getAnioLectivoById(id);
        if (anioLectivoDB != null) {
            anioLectivoDB.setAnioLectivo(anioLectivo.getAnioLectivo());
            anioLectivoRepository.save(anioLectivoDB);
        }
    }

}
