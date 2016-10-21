package model;

public class SenhaModel {
	
	private String usuario;
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	private String pergunta;
	private String msgErro;

	public SenhaModel() {
		// Inserir Código
	}

	public String getPergunta() {
		return pergunta;
	}

	public boolean conferirUsuario(String usuario) {
		// Inserir Código
		return true;
	}

	public boolean conferirResposta(String resposta) {
		// Inserir Código
		return true;
	}

	public boolean trocarSenha(String usuario, String novaSenha) {
		// Inserir Código
		return true;
	}
}
