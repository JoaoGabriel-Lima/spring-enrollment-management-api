package com.jglm.apirestful.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "turmas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ano é obrigatório")
    @Column(nullable = false)
    private String ano;

    @NotBlank(message = "Período é obrigatório")
    @Column(nullable = false)
    private String periodo;

    @NotNull(message = "Professor é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @NotNull(message = "Disciplina é obrigatória")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disciplina_id", nullable = false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Inscricao> inscricoes;

    @JsonProperty("alunos")
    public List<Aluno> getAlunosInscritos() {
        if (inscricoes == null) {
            return new ArrayList<>();
        }
        return inscricoes.stream()
                .map(Inscricao::getAluno)
                .collect(Collectors.toList());
    }
}