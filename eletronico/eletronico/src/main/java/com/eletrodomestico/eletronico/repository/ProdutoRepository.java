package com.eletrodomestico.eletronico.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eletrodomestico.eletronico.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public List<Produto> findAllByPrecoBetween(BigDecimal preco1, BigDecimal preco2);
	
	@Query(value = "select*from tb_produto where preco between :valor1 and :valor2", nativeQuery = true)
	public List<Produto> findAllByPrecoQuery(@Param("valor1") BigDecimal preco1, @Param("valor2") BigDecimal preco2);
	
	@Query(value = "select * from tb_produto inner join tb_tipo_eletro on tb_produto.id = tb_tipo_eletro.id where tb_tipo_eletro.descricao like :descricao% and tb_produto.preco <= :valor", nativeQuery = true)
	public List<Produto> findAllByTipoPrecoQuery(@Param("descricao") String descricao, @Param("valor") BigDecimal preco);
}
