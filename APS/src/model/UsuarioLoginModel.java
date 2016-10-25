package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarioLogin")
public class UsuarioLoginModel {

	@Id
	@Column(name = "usuario", nullable = false)
	private String usuario;

	@Column(name = "senha", nullable = false)
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
