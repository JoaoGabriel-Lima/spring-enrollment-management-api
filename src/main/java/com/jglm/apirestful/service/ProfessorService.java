package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Professor;
import com.jglm.apirestful.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Professor não encontrado com ID: " + id));
    }

    public Professor cadastrar(Professor professor) {
        if (professorRepository.existsByEmail(professor.getEmail())) {
            throw new IllegalArgumentException(
                    "Já existe um professor cadastrado com este email: " + professor.getEmail());
        }
        return professorRepository.save(professor);
    }

    public Professor alterar(Long id, Professor professor) {
        Professor professorExistente = buscarPorId(id);

        // Verificar se o email não está sendo usado por outro professor
        if (!professorExistente.getEmail().equals(professor.getEmail()) &&
                professorRepository.existsByEmail(professor.getEmail())) {
            throw new IllegalArgumentException(
                    "Já existe um professor cadastrado com este email: " + professor.getEmail());
        }

        professorExistente.setNome(professor.getNome());
        professorExistente.setEmail(professor.getEmail());

        return professorRepository.save(professorExistente);
    }

    public void remover(Long id) {
        Professor professor = buscarPorId(id);
        professorRepository.delete(professor);
    }
}