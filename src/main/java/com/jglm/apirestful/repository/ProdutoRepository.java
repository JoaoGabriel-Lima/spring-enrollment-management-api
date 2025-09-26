package com.jglm.apirestful.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jglm.apirestful.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Produto p where p.id = :id")
    Optional<Produto> recuperarProdutoPorIdComLock(@Param("id") Long id);

    @Query("select p from Produto p left outer join fetch p.categoria order by p.id")
    List<Produto> recuperarProdutos();

    @Query("select p from Produto p left outer join fetch p.categoria where p.id = :id")
    Optional<Produto> recuperarProdutoPorIdComCategoria(@Param("id") Long id);

    @Query("select p from Produto p where p.id = :id")
    Optional<Produto> recuperarProdutoPorIdSemCategoria(@Param("id") Long id);

    @Query(value = "select p from Produto p left outer join fetch p.categoria order by p.id", countQuery = "select count(p) from Produto p")
    Page<Produto> recuperarProdutosComPaginacao(Pageable pageable);
}
