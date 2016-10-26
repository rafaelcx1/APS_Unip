package model;

import model.models.FiltroModel;
import model.models.TagsMaisAtivasModel;
import model.models.UsuarioAtivoModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;

public class PrincipalModel {

	private TopicoModel[] topicos;
	private String msgErro;

	public PrincipalModel() {

	}

	public TopicoModel[] getTopicos(int numeroPag) {
		return topicos;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void atuaizarTopicos(FiltroModel filtro) {

	}

	public TopicoModel[] getTopicosMaisCurtidos() {
		return null;
	}

	public UsuarioAtivoModel[] getUsuariosMaisAtivos() {
		return null;
	}

	public TagsMaisAtivasModel[] getTagsMaisAtivas() {
		return null;
	}

	public String[] getTags() {
		return null;
	}

	public PostagemModel[] getPostagens(int idTopico) {
		return null;
	}

	public boolean curtirTopico(int idTopico, boolean curtir) {
		return false;
	}

	public boolean postarPostagem(int idTopico, PostagemModel postagem) {
		return false;
	}

	public boolean criarTopico(TopicoModel topico) {
		return false;
	}

}
