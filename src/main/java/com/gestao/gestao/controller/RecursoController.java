package com.gestao.gestao.controller;

import com.gestao.gestao.model.Recurso;
import com.gestao.gestao.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<Recurso> getAllRecursos() {
        return recursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable Long id) {
        Recurso recurso = recursoService.findById(id);
        if (recurso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public Recurso createRecurso(@RequestBody Recurso recurso) {
        return recursoService.save(recurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecurso(@PathVariable Long id, @RequestBody Recurso recursoDetails) {
        Recurso recurso = recursoService.findById(id);
        if (recurso == null) {
            return ResponseEntity.notFound().build();
        }
        recurso.setTitulo(recursoDetails.getTitulo());
        recurso.setDescricao(recursoDetails.getDescricao());
        recurso.setTipo(recursoDetails.getTipo());
        recurso.setDisponivel(recursoDetails.isDisponivel());
        Recurso updatedRecurso = recursoService.save(recurso);
        return ResponseEntity.ok(updatedRecurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecurso(@PathVariable Long id) {
        Recurso recurso = recursoService.findById(id);
        if (recurso == null) {
            return ResponseEntity.notFound().build();
        }
        recursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


