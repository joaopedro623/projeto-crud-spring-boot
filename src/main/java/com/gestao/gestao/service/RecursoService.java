package com.gestao.gestao.service;

import com.gestao.gestao.model.Recurso;
import com.gestao.gestao.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> findAll() {
        return recursoRepository.findAll();
    }

    public Recurso findById(Long id) {
        Optional<Recurso> optionalRecurso = recursoRepository.findById(id);
        return optionalRecurso.orElse(null);
    }

    public Recurso save(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    public void deleteById(Long id) {
        recursoRepository.deleteById(id);
    }
}
