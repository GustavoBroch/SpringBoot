package com.generationbrasil.task.model;

public class Mentalidade {
	
	private String mentalidade;
	private String descricao;
	
	public Mentalidade() {
		super();
	}
	public Mentalidade(String mentalidade, String descricao) {
		super();
		this.mentalidade = mentalidade;
		this.descricao = descricao;
	}
	public String getMentalidade() {
		return mentalidade;
	}
	public void setMentalidade(String mentalidade) {
		this.mentalidade = mentalidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
