package br.com.teste;

public class Pessoa {

	private String nome;
	private String cidade;
	private String estado;

	public Pessoa() {

	}

	public Pessoa(String nome, String cidade, String estado) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
