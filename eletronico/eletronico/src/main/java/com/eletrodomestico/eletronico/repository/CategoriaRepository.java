package com.eletrodomestico.eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eletrodomestico.eletronico.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
