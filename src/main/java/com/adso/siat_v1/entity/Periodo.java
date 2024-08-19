package com.adso.siat_v1.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periodo_id")
    private Long id;

    @Column(name = "periodo_numero")
    private int periodoNumero;

    @ManyToMany
    @JoinTable(
        name = "anios_periodos",
        joinColumns = @JoinColumn(name = "anio_lectivo_id"),
        inverseJoinColumns = @JoinColumn(name = "periodo_id")
    )
    private Set<AnioLectivo> anioLectivos;

}
