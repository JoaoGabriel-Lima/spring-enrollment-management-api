package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Aluno;
import com.jglm.apirestful.model.ResultadoPaginado;
import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.service.TurmaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TurmaController {

    private final TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodos() {
        List<Turma> turmas = turmaService.buscarTodos();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ResultadoPaginado<Turma>> buscarTurmasPaginado(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(name = "per_page", defaultValue = "10") int perPage) {

        if (page < 1) {
            page = 1;
        }
        if (perPage < 1) {
            perPage = 10;
        }

        ResultadoPaginado<Turma> resultado = turmaService.buscarTurmasPaginado(search, page, perPage);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Turma turma = turmaService.buscarPorId(id);
        return ResponseEntity.ok(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> cadastrar(@Valid @RequestBody Turma turma) {
        Turma turmaSalva = turmaService.cadastrar(turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        turmaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Turma>> buscarPorProfessor(@PathVariable Long professorId) {
        List<Turma> turmas = turmaService.buscarPorProfessor(professorId);
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/disciplina/{disciplinaId}")
    public ResponseEntity<List<Turma>> buscarPorDisciplina(@PathVariable Long disciplinaId) {
        List<Turma> turmas = turmaService.buscarPorDisciplina(disciplinaId);
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunosPorTurma(@PathVariable Long id) {
        List<Aluno> alunos = turmaService.buscarAlunosPorTurma(id);
        return ResponseEntity.ok(alunos);
    }
}