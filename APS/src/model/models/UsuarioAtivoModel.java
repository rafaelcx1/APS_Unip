package model.models;

public class UsuarioAtivoModel {

	private String usuario;
	private long numPublicacoes;

	public UsuarioAtivoModel() {

	}

	public UsuarioAtivoModel(String usuario, long numPublicacoes) {
		this.usuario = usuario;
		this.numPublicacoes = numPublicacoes;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public long getNumPublicacoes() {
		return numPublicacoes;
	}
	public void setNumPublicacoes(long numPublicacoes) {
		this.numPublicacoes = numPublicacoes;
	}

}
