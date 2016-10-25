package model.tables;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "topicos")
public class TopicoModel {


	private int idTopico;
	private UsuarioModel usuarioAutor;
	private String titulo;
	private String dtCriacao;
	private int qtdCurtidas;
	private int qtdRespostas;
	private TagsModel tag;

	public TopicoModel() {

	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

	public UsuarioModel getUsuario() {
		return usuarioAutor;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuarioAutor = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public int getQtdCurtidas() {
		return qtdCurtidas;
	}

	public void setQtdCurtidas(int qtdCurtidas) {
		this.qtdCurtidas = qtdCurtidas;
	}

	public int getQtdRespostas() {
		return qtdRespostas;
	}

	public void setQtdRespostas(int qtdRespostas) {
		this.qtdRespostas = qtdRespostas;
	}


	public TagsModel getTag() {
		return tag;
	}


	public void setTag(TagsModel tag) {
		this.tag = tag;
	}


}
