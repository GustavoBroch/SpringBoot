package com.leao.farmarcia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leao.farmarcia.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public Optional<Funcionario> findByEmail(String email);
}
