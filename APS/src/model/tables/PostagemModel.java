package model.tables;


public class PostagemModel {

	private TopicoModel idTopico;
	private UsuarioModel usuario;
	private String textoPost;
	private String dataPost;

	public PostagemModel(){

	}

	public TopicoModel getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(TopicoModel idTopico) {
		this.idTopico = idTopico;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public String getTextoPost() {
		return textoPost;
	}

	public void setTextoPost(String textoPost) {
		this.textoPost = textoPost;
	}

	public String getDataPost() {
		return dataPost;
	}

	public void setDataPost(String dataPost) {
		this.dataPost = dataPost;
	}

}

