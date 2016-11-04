package model.models;

import model.tables.UsuarioModel;

public class UsuarioAtivoModel {

	private UsuarioModel usuario;
	private long numPublicacoes;

	public UsuarioAtivoModel() {

	}

	public UsuarioAtivoModel(UsuarioModel usuario, long numPublicacoes) {
		this.usuario = usuario;
		this.numPublicacoes = numPublicacoes;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	public long getNumPublicacoes() {
		return numPublicacoes;
	}
	public void setNumPublicacoes(long numPublicacoes) {
		this.numPublicacoes = numPublicacoes;
	}

}
