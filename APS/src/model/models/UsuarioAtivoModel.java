package model.models;

public class UsuarioAtivoModel {

	private String usuario;
	private int numPublicacoes;

	public UsuarioAtivoModel() {

	}

	public UsuarioAtivoModel(String usuario, int numPublicacoes) {
		this.usuario = usuario;
		this.numPublicacoes = numPublicacoes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getNumPublicacoes() {
		return numPublicacoes;
	}

	public void setNumPublicacoes(int numPublicacoes) {
		this.numPublicacoes = numPublicacoes;
	}

}