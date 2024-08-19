package com.adso.siat_v1.service;

import com.adso.siat_v1.entity.AnioLectivo;

public interface AnioLectivoServiceInterface {
    public void saveAnioLectivo(AnioLectivo anioLectivo);

    public AnioLectivo getAnioLectivoById(Long id);
    public Iterable<AnioLectivo> getAllAnioLectivos();
    public void deleteAnioLectivo(Long id);
    public void updateAnioLectivo(Long id, AnioLectivo anioLectivo);

}
