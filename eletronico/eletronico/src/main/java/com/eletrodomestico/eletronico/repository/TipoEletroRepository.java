package com.eletrodomestico.eletronico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eletrodomestico.eletronico.model.TipoEletro;

public interface TipoEletroRepository extends JpaRepository<TipoEletro, Long> {

	public List<TipoEletro> findAllByDescricaoContainingIgnoreCase(String descricao);
}
