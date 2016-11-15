package model.models;

public class TagsMaisAtivasModel {

	private String nome;
	private long numPublicacoes;

	public TagsMaisAtivasModel(){}

	public TagsMaisAtivasModel(String nome, long numPublicacoes) {
		this.nome = nome;
		this.numPublicacoes = numPublicacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getNumPublicacoes() {
		return numPublicacoes;
	}

	public void setNumPublicacoes(long numPublicacoes) {
		this.numPublicacoes = numPublicacoes;
	}

}