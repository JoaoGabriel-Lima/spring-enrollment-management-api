package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Turma;
import com.jglm.apirestful.service.TurmaService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Long id) {
        Turma turma = turmaService.buscarPorId(id);
        return ResponseEntity.ok(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> cadastrar(@RequestBody Turma turma) {
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
}