package model.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "topicos")
public class TopicoModel {

	@Id @GeneratedValue
	private int idTopico;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private UsuarioModel usuario;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "dtCriacao")
	private String dtCriacao;
	@Column(name = "qtdCurtidas")
	private int qtdCurtidas;
	@Column(name = "qtdRespostas")
	private int qtdRespostas;
	@Column(name = "tag")
	private String tag;

	public TopicoModel() {
		qtdRespostas = 0;
		qtdCurtidas = 0;
	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
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


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


}
