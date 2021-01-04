package com.leao.farmarcia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leao.farmarcia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	
}
