package model;

public class SenhaModel {

	private String usuario;
	private String pergunta;
	private String msgErro;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPergunta() {
		return pergunta;
	}

	public boolean conferirUsuario(String usuario) {
		// Inserir C�digo
		return true;
	}

	public boolean conferirResposta(String resposta) {
		// Inserir C�digo
		return true;
	}

	public boolean trocarSenha(String usuario, String novaSenha) {
		// Inserir C�digo
		return true;
	}
}
