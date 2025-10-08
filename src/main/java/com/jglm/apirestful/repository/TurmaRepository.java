package com.jglm.apirestful.repository;

import com.jglm.apirestful.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    List<Turma> findByProfessorId(Long professorId);

    List<Turma> findByAno(String ano);

    List<Turma> findByPeriodo(String periodo);

    @Query("SELECT DISTINCT t FROM Turma t LEFT JOIN FETCH t.inscricoes i LEFT JOIN FETCH i.aluno")
    List<Turma> findAllWithAlunos();

    @Query("SELECT DISTINCT t FROM Turma t LEFT JOIN FETCH t.inscricoes i LEFT JOIN FETCH i.aluno WHERE t.id = :id")
    Optional<Turma> findByIdWithAlunos(@Param("id") Long id);

    @Query("SELECT DISTINCT t FROM Turma t LEFT JOIN FETCH t.inscricoes i LEFT JOIN FETCH i.aluno WHERE t.professor.id = :professorId")
    List<Turma> findByProfessorIdWithAlunos(@Param("professorId") Long professorId);
}