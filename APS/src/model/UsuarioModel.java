package model;

public class UsuarioModel {

	private String nome;
	private String usuario;
	private String senha;
	private String dataNasc;
	private String genero;
	private String estado;
	private String cidade;
	private int perguntaSecret;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getPerguntaSecret() {
		return perguntaSecret;
	}
	public void setPerguntaSecret(int perguntaSecret) {
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
