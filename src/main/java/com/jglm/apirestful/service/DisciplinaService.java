package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Disciplina;
import com.jglm.apirestful.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<Disciplina> buscarTodos() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Disciplina não encontrada com ID: " + id));
    }

    public Disciplina cadastrar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina alterar(Long id, Disciplina disciplina) {
        Disciplina disciplinaExistente = buscarPorId(id);

        disciplinaExistente.setNome(disciplina.getNome());
        disciplinaExistente.setCargaHoraria(disciplina.getCargaHoraria());

        return disciplinaRepository.save(disciplinaExistente);
    }

    public void remover(Long id) {
        Disciplina disciplina = buscarPorId(id);
        disciplinaRepository.delete(disciplina);
    }
}
