package model.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioModel {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "Senha")
	private String senha;

	@Column(name = "dataNasc", nullable = false)
	private String dataNasc;

	@Column(name = "genero")
	private String genero;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPergunta")
	private PerguntasModel perguntaSecret;

	@Column(name = "respostaSecret")
	private String respostaSecret;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


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


	public String getDataNasc() {
		return dataNasc;
	}


	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public PerguntasModel getPerguntaSecret() {
		return perguntaSecret;
	}


	public void setPerguntaSecret(PerguntasModel perguntaSecret) {
		this.perguntaSecret = perguntaSecret;
	}


	public String getRespostaSecret() {
		return respostaSecret;
	}


	public void setRespostaSecret(String respostaSecret) {
		this.respostaSecret = respostaSecret;
	}


	public UsuarioModel(){
	}

}
