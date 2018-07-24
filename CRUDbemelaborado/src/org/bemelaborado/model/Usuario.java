package org.bemelaborado.model;


// essa classe vai servir para gerar os get e set para os atributos da tabela em quest�o que � uma tabela do banco
// chamada usuario que tem tres colunas: id, nome e idade
public class Usuario {
	private String id;
	private String nome;
	private String idade;
	
	public Usuario() { //construto para listagem
	}
	
	
	public Usuario(String id) {//construtor para delete
		this.id = id;
	}
	
	public Usuario(String nome, String idade, String id) { // construtor para obter dados de um usu�rio espec�fico
		this(nome,idade);
		this.id = id;
	}
	
	public Usuario(String nome, String idade) { // construtor para insert de dados, ou seja, nao precisa do id, pois � AI no banco
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
