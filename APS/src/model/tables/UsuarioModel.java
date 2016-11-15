package model.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioModel {

	@Id
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "senha", nullable = false)
	private String senha;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "dataNasc")
	private String dataNasc;
	@Column(name = "genero")
	private String genero;
	@Column(name = "estado")
	private String estado;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "perguntaSecret", nullable = false)
	private String perguntaSecret;
	@Column(name = "respostaSecret", nullable = false)
	private String respostaSecret;
	@Column(name = "dataCadastro")
	private String dataCadastro;
	@Column(name = "qtdPostagens")
	private int qtdPostagens;
	@Column(name = "avatar")
 	private int avatar;

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

	public String getEstado(){
		return estado;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getCidade(){
		return cidade;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public String getPerguntaSecret() {
		return perguntaSecret;
	}

	public void setPerguntaSecret(String perguntaSecret) {
		this.perguntaSecret = perguntaSecret;
	}

	public String getRespostaSecret() {
		return respostaSecret;
	}

	public void setRespostaSecret(String respostaSecret) {
		this.respostaSecret = respostaSecret;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getQtdPostagens() {
		return qtdPostagens;
	}

	public void setQtdPostagens(int qtdPostagens) {
		this.qtdPostagens = qtdPostagens;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public UsuarioModel(){
	}
}