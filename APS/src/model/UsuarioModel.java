package model;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private UsuarioLoginModel usuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "senha")
	private UsuarioLoginModel senha;

	@Column(name = "dataNasc", nullable = false)
	private String dataNasc;

	@Column(name = "genero")
	private String genero;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstado")
	private EstadoModel estado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCidade")
	private CidadeModel cidade;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPergunta")
	private PerguntasModel perguntaSecret;

	@Column(name = "respostaSecret")
	private String respostaSecret;


	public void setEstado(EstadoModel estado) {
		this.estado = estado;
	}


	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public UsuarioLoginModel getUsuario() {
		return usuario;
	}



	public void setUsuario(UsuarioLoginModel usuario) {
		this.usuario = usuario;
	}



	public UsuarioLoginModel getSenha() {
		return senha;
	}



	public void setSenha(UsuarioLoginModel senha) {
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



	public CidadeModel getCidade() {
		return cidade;
	}



	public void setCidade(CidadeModel cidade) {
		this.cidade = cidade;
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



	public EstadoModel getEstado() {
		return estado;
	}



	public UsuarioModel(){
	}

}
