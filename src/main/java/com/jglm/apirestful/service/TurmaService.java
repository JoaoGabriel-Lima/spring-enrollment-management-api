package com.jglm.apirestful.service;

import com.jglm.apirestful.exception.EntidadeNaoEncontradaException;
import com.jglm.apirestful.model.Disciplina;
import com.jglm.apirestful.model.Professor;
import com.jglm.apirestful.model.ResultadoPaginado;
import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;

    public List<Turma> buscarTodos() {
        return turmaRepository.findAllWithAlunos();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.findByIdWithAlunos(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Turma não encontrada com ID: " + id));
    }

    public ResultadoPaginado<Turma> buscarTurmasPaginado(String search, int page, int perPage) {
        Pageable pageable = PageRequest.of(page - 1, perPage);
        Page<Turma> paginaTurmas = turmaRepository.findBySearchWithPagination(search, pageable);

        // Carregar os alunos para cada turma da página
        List<Turma> turmasComAlunos = paginaTurmas.getContent().stream()
                .map(turma -> turmaRepository.findByIdWithAlunos(turma.getId())
                        .orElse(turma))
                .toList();

        return new ResultadoPaginado<>(
                paginaTurmas.getTotalElements(),
                paginaTurmas.getTotalPages(),
                paginaTurmas.getNumber() + 1,
                turmasComAlunos);
    }

    public Turma cadastrar(Turma turma) {
        // Verificar se o professor existe
        Professor professor = professorService.buscarPorId(turma.getProfessor().getId());
        turma.setProfessor(professor);

        // Verificar se a disciplina existe
        Disciplina disciplina = disciplinaService.buscarPorId(turma.getDisciplina().getId());
        turma.setDisciplina(disciplina);

        return turmaRepository.save(turma);
    }

    public void remover(Long id) {
        Turma turma = buscarPorId(id);
        turmaRepository.delete(turma);
    }

    public List<Turma> buscarPorProfessor(Long professorId) {
        return turmaRepository.findByProfessorIdWithAlunos(professorId);
    }
}