package com.generationbrasil.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationbrasil.task.model.Habilidade;
import com.generationbrasil.task.model.Mentalidade;

@RestController
@RequestMapping("/task1")
public class TaskController {
	
	@GetMapping
	public String mensagem() {
		return  "Sejam bem vindos(as) !!! Escolha uma sub-rota: /persistencia, /mentalidadecrescimento, /orientacaodetalhes, /trabalhoemequipe";
	}
	@GetMapping("/persistencia")
	public Habilidade habilidade() {
		Habilidade habilidade = new Habilidade("Persistencia","Essa habilidade ajudou-me todas as vezes que apareciam erros durante a criação desse projeto.");
		return habilidade;
	}
	
	@GetMapping("/mentalidadecrescimento")
	public Habilidade habilidade2() {
		Habilidade habilidade = new Habilidade("Mentalidade de Crescimento", "Percebo que quanto mais eu pratico, o processo se torna mais simples.");
		return habilidade;
	}
	
	@GetMapping("/orientacaodetalhes")
	public Mentalidade mentalidade1() {
		Mentalidade mentalidade = new Mentalidade("Orientação aos Detalhes", "É necessário atenção aos detalhes, principalmente nas anotações(bin), passando corretamente o que precisa ser utilizado.");
		return mentalidade;
	}
	@GetMapping("/trabalhoemequipe")
	public Mentalidade mentalidade2() {
		Mentalidade mentalidade = new Mentalidade("Trabalho em equipe", "Em grupo no Discord, trabalhamos coletivamente, ajudando nas trocas de informações, em busca de tirar dúvidas.");
		return mentalidade;
	}
	
}
