package com.adso.siat_v1.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.siat_v1.entity.Periodo;
import com.adso.siat_v1.service.PeriodoServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v2/periodo")
public class PeriodoController {

    @Autowired
    private PeriodoServiceImpl periodoService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Periodo> getPeriodoById(@RequestParam Long id) {
        return ResponseEntity.ok(periodoService.getPeriodoById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<Set<Periodo>> getAllPeriodos() {
        return ResponseEntity.ok(periodoService.getAllPeriodos());
    }

    @PostMapping("/aniolectivo/{id}")
    public ResponseEntity<Long> savePeriodo(@RequestParam Long id, @RequestBody Periodo periodo) {
        return ResponseEntity.ok(periodoService.savePeriodo(id,periodo));
    }
    

    @PutMapping("/update")
    public ResponseEntity<String> updatePeriodo(@RequestParam Long id, @RequestBody Periodo periodo) {
        periodoService.updatePeriodo(id,periodo);
        return ResponseEntity.ok("ACTUALIZADO CORRECTAMENTE");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePeriodo(@RequestParam Long id) {
        periodoService.deletePeriodo(id);
        return ResponseEntity.ok("ELIMINADO CORRECTAMENTE");
    }
}
