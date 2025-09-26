package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Professor;
import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorService professorService;

    public List<Turma> buscarTodos() {
        return turmaRepository.findAll();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Turma não encontrada com ID: " + id));
    }

    public Turma cadastrar(Turma turma) {
        // Verificar se o professor existe
        Professor professor = professorService.buscarPorId(turma.getProfessor().getId());
        turma.setProfessor(professor);

        return turmaRepository.save(turma);
    }

    public void remover(Long id) {
        Turma turma = buscarPorId(id);
        turmaRepository.delete(turma);
    }

    public List<Turma> buscarPorProfessor(Long professorId) {
        return turmaRepository.findByProfessorId(professorId);
    }
}