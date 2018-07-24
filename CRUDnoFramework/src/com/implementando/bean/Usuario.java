package com.implementando.bean;

public class Usuario {
	private String id;
	private String nome;
	private String idade;
	public Usuario() {
		super();
	}
	
	public Usuario(String nome) {
		super();
		this.nome = nome;
	}
	public Usuario(String nome, String idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
}
