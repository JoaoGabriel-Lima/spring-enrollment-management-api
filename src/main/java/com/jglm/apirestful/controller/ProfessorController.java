package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Professor;
import com.jglm.apirestful.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodos() {
        List<Professor> professores = professorService.buscarTodos();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Professor professor = professorService.buscarPorId(id);
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> cadastrar(@Valid @RequestBody Professor professor) {
        Professor professorSalvo = professorService.cadastrar(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> alterar(@PathVariable Long id, @Valid @RequestBody Professor professor) {
        Professor professorAlterado = professorService.alterar(id, professor);
        return ResponseEntity.ok(professorAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        professorService.remover(id);
        return ResponseEntity.noContent().build();
    }
}