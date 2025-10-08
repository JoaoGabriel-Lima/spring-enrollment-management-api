package com.jglm.apirestful.controller;

import com.jglm.apirestful.model.Disciplina;
import com.jglm.apirestful.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> buscarTodos() {
        List<Disciplina> disciplinas = disciplinaService.buscarTodos();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id) {
        Disciplina disciplina = disciplinaService.buscarPorId(id);
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public ResponseEntity<Disciplina> cadastrar(@RequestBody Disciplina disciplina) {
        Disciplina disciplinaSalva = disciplinaService.cadastrar(disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> alterar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAlterada = disciplinaService.alterar(id, disciplina);
        return ResponseEntity.ok(disciplinaAlterada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        disciplinaService.remover(id);
        return ResponseEntity.noContent().build();
    }
}
