package com.adso.siat_v1.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "anio_lectivo")
public class AnioLectivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anio_lectivo_id")
    private Long id;

    @Column(name = "anio_lectivo", nullable = false, unique = true)
    private int anioLectivo;

    @ManyToMany
    (mappedBy = "anioLectivos")
    private Set<Periodo> periodos;

}
