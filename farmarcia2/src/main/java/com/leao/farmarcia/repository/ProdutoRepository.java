package com.leao.farmarcia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leao.farmarcia.model.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
