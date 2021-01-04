package com.leao.farmarcia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leao.farmarcia.model.Funcionario;
import com.leao.farmarcia.model.FuncionarioLogin;
import com.leao.farmarcia.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<FuncionarioLogin> Autentication(@RequestBody Optional<FuncionarioLogin> funcionario){
		return funcionarioService.Logar(funcionario).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	@PostMapping("/cadastrar")
	public ResponseEntity<Funcionario> Post(@RequestBody Funcionario funcionario){
		//Alteração Marcelo - Funcionario
		Funcionario func = funcionarioService.CadastrarFuncionario(funcionario);
		//Alteração Marcelo If até o último return.
		if(func == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(func);
	}

}
