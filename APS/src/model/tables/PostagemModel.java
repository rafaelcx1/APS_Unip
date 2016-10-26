package model.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "postagens")
public class PostagemModel {

	@Id @GeneratedValue
	private int idPostagem;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTopico")
	private TopicoModel idTopico;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private UsuarioModel usuario;
	@Column(name = "textoPost")
	private String textoPost;
	@Column(name = "dataPost")
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

