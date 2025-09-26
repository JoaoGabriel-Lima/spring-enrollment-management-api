package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Aluno;
import com.jglm.apirestful.model.Inscricao;
import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.repository.InscricaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final AlunoService alunoService;
    private final TurmaService turmaService;

    public List<Inscricao> buscarTodos() {
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarPorId(Long id) {
        return inscricaoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inscrição não encontrada com ID: " + id));
    }

    public Inscricao cadastrar(Inscricao inscricao) {
        // Verificar se o aluno existe
        Aluno aluno = alunoService.buscarPorId(inscricao.getAluno().getId());

        // Verificar se a turma existe
        Turma turma = turmaService.buscarPorId(inscricao.getTurma().getId());

        // Verificar se já existe uma inscrição para este aluno nesta turma
        if (inscricaoRepository.existsByAlunoIdAndTurmaId(aluno.getId(), turma.getId())) {
            throw new IllegalArgumentException("O aluno já está inscrito nesta turma");
        }

        inscricao.setAluno(aluno);
        inscricao.setTurma(turma);
        inscricao.setDataHora(LocalDateTime.now());

        return inscricaoRepository.save(inscricao);
    }

    public void remover(Long id) {
        Inscricao inscricao = buscarPorId(id);
        inscricaoRepository.delete(inscricao);
    }

    public List<Inscricao> buscarPorAluno(Long alunoId) {
        return inscricaoRepository.findByAlunoId(alunoId);
    }

    public List<Inscricao> buscarPorTurma(Long turmaId) {
        return inscricaoRepository.findByTurmaId(turmaId);
    }
}