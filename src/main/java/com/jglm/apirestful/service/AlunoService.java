package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Aluno;
import com.jglm.apirestful.repository.AlunoRepository;
import com.jglm.apirestful.repository.InscricaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final InscricaoRepository inscricaoRepository;

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno não encontrado com ID: " + id));
    }

    public Aluno cadastrar(Aluno aluno) {
        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new IllegalArgumentException("Já existe um aluno cadastrado com este email: " + aluno.getEmail());
        }
        return alunoRepository.save(aluno);
    }

    public Aluno alterar(Long id, Aluno aluno) {
        Aluno alunoExistente = buscarPorId(id);

        // Verificar se o email não está sendo usado por outro aluno
        if (!alunoExistente.getEmail().equals(aluno.getEmail()) &&
                alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new IllegalArgumentException("Já existe um aluno cadastrado com este email: " + aluno.getEmail());
        }

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());

        return alunoRepository.save(alunoExistente);
    }

    public void remover(Long id) {
        Aluno aluno = buscarPorId(id);
        if (inscricaoRepository.existsByAlunoId(id)) {
            throw new IllegalArgumentException(
                    "Não é possível remover o aluno pois ele está matriculado em uma ou mais turmas.");
        }
        alunoRepository.delete(aluno);
    }
}