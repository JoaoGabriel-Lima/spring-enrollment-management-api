package com.jglm.apirestful.repository;

import com.jglm.apirestful.model.Turma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("SELECT t FROM Turma t WHERE (:id IS NULL OR t.id = :id)")
    Page<Turma> findByIdWithPagination(@Param("id") Long id, Pageable pageable);

    @Query(value = "SELECT DISTINCT t.* FROM turmas t " +
            "LEFT JOIN inscricoes i ON t.id = i.turma_id " +
            "LEFT JOIN alunos a ON i.aluno_id = a.id " +
            "WHERE (:id IS NULL OR t.id = :id)", countQuery = "SELECT COUNT(DISTINCT t.id) FROM turmas t WHERE (:id IS NULL OR t.id = :id)", nativeQuery = true)
    Page<Turma> findByIdWithPaginationNative(@Param("id") Long id, Pageable pageable);

    @Query(value = "SELECT DISTINCT t.* FROM turmas t " +
            "LEFT JOIN professores p ON t.professor_id = p.id " +
            "LEFT JOIN disciplinas d ON t.disciplina_id = d.id " +
            "WHERE :search IS NULL OR " +
            "CAST(t.id AS CHAR) LIKE CONCAT('%', :search, '%') OR " +
            "LOWER(p.nome) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(t.ano) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.nome) LIKE LOWER(CONCAT('%', :search, '%'))", countQuery = "SELECT COUNT(DISTINCT t.id) FROM turmas t "
                    +
                    "LEFT JOIN professores p ON t.professor_id = p.id " +
                    "LEFT JOIN disciplinas d ON t.disciplina_id = d.id " +
                    "WHERE :search IS NULL OR " +
                    "CAST(t.id AS CHAR) LIKE CONCAT('%', :search, '%') OR " +
                    "LOWER(p.nome) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                    "LOWER(t.ano) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                    "LOWER(d.nome) LIKE LOWER(CONCAT('%', :search, '%'))", nativeQuery = true)
    Page<Turma> findBySearchWithPagination(@Param("search") String search, Pageable pageable);
}