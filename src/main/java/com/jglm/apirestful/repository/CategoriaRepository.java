package com.jglm.apirestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jglm.apirestful.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
