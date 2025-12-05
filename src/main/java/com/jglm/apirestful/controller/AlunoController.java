package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Aluno;
import com.jglm.apirestful.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodos() {
        List<Aluno> alunos = alunoService.buscarTodos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@Valid @RequestBody Aluno aluno) {
        Aluno alunoSalvo = alunoService.cadastrar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> alterar(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        Aluno alunoAlterado = alunoService.alterar(id, aluno);
        return ResponseEntity.ok(alunoAlterado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        alunoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}