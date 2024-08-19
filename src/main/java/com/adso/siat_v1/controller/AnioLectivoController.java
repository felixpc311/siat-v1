package com.adso.siat_v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.siat_v1.entity.AnioLectivo;
import com.adso.siat_v1.service.AnioLectivoServiceImpl;

@RestController
@RequestMapping("/api/v2/aniolectivo")
public class AnioLectivoController {

    @Autowired
    AnioLectivoServiceImpl anioLectivoService;

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<AnioLectivo> getAnioLectivoById(@RequestParam Long id) {
        return ResponseEntity.ok(anioLectivoService.getAnioLectivoById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<Iterable<AnioLectivo>> getAllAnioLectivos() {
        return ResponseEntity.ok(anioLectivoService.getAllAnioLectivos());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveAnioLectivo(@RequestBody AnioLectivo anioLectivo) {
        anioLectivoService.saveAnioLectivo(anioLectivo);
        return ResponseEntity.ok("GUARDADO CORRECTAMENTE");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAnioLectivo(@RequestParam Long id, @RequestBody AnioLectivo anioLectivo) {
        anioLectivoService.updateAnioLectivo(id, anioLectivo);
        return ResponseEntity.ok("ACTUALIZADO CORRECTAMENTE");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnioLectivo(@RequestParam Long id) {
        anioLectivoService.deleteAnioLectivo(id);
        return ResponseEntity.ok("ELIMINADO CORRECTAMENTE");
    }

}
