package com.generationbrasil.task.model;

public class Habilidade {
	
	private String habilidade;
	private String descricao;
	
	public Habilidade() {
		super();
	}
	public Habilidade(String habilidade, String descricao) {
		super();
		this.habilidade = habilidade;
		this.descricao = descricao;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
