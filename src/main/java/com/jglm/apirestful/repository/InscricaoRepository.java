package com.jglm.apirestful.repository;

import com.jglm.apirestful.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    List<Inscricao> findByAlunoId(Long alunoId);

    List<Inscricao> findByTurmaId(Long turmaId);

    Optional<Inscricao> findByAlunoIdAndTurmaId(Long alunoId, Long turmaId);

    boolean existsByAlunoIdAndTurmaId(Long alunoId, Long turmaId);
}