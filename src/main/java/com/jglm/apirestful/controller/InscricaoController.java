package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Inscricao;
import com.jglm.apirestful.service.InscricaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<List<Inscricao>> buscarTodos() {
        List<Inscricao> inscricoes = inscricaoService.buscarTodos();
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable Long id) {
        Inscricao inscricao = inscricaoService.buscarPorId(id);
        return ResponseEntity.ok(inscricao);
    }

    @PostMapping
    public ResponseEntity<Inscricao> cadastrar(@RequestBody Inscricao inscricao) {
        Inscricao inscricaoSalva = inscricaoService.cadastrar(inscricao);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        inscricaoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Inscricao>> buscarPorAluno(@PathVariable Long alunoId) {
        List<Inscricao> inscricoes = inscricaoService.buscarPorAluno(alunoId);
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<Inscricao>> buscarPorTurma(@PathVariable Long turmaId) {
        List<Inscricao> inscricoes = inscricaoService.buscarPorTurma(turmaId);
        return ResponseEntity.ok(inscricoes);
    }
}