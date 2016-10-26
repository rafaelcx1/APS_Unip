package model.models;

public class UsuarioAtivoModel {

	private String nome;
	private int numPublicacoes;

	public UsuarioAtivoModel() {

	}

	public UsuarioAtivoModel(String nome, int numPublicacoes) {
		this.nome = nome;
		this.numPublicacoes = numPublicacoes;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumPublicacoes() {
		return numPublicacoes;
	}
	public void setNumPublicacoes(int numPublicacoes) {
		this.numPublicacoes = numPublicacoes;
	}

}
