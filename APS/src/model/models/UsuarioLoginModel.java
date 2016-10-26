package model.models;

public class UsuarioLoginModel {

	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioLoginModel(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
	}
}
