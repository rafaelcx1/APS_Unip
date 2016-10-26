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

	public boolean atuaizarTopicos(FiltroModel filtro) {
		try {
			if(filtro == null){
				filtro = new FiltroModel();
			}
			List<TopicoModel> topicosList = DAOForum.getTopicos(filtro);
			topicos = new TopicoModel[topicosList.size()];
			topicos = (TopicoModel) topicosList.toArray();
			return true;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
		
	}

	public TopicoModel[] getTopicosMaisCurtidos() {
		try {
			List<TopicoModel> topicosMaisCurtidos = DAOForum.getTopicosMaisCurtidos();
			return (TopicoModel)topicosMaisCurtidos.toArray();
		} catch (Exception e) {
			msgErro = DAOForum.getMsgErro;
			return null;
		}
	}

	public UsuarioAtivoModel[] getUsuariosMaisAtivos() {
		try {
			List<UsuarioAtivoModel> usuariosMaisAtivos = DAOForum.getUsuariosMaisAtivos();
			return (UsuarioAtivoModel)usuariosMaisAtivos.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return null;
		}
	}

	public TagsMaisAtivasModel[] getTagsMaisAtivas() {
		try {
			List<TagsMaisAtivasModel> tagsMaisAtivas = DAOForum.getTagsMaisAtivas();
			return (TagsMaisAtivasModel)tagsMaisAtivas.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return null;
		}
	}

	public String[] getTags() {
		try {
			List<TagsModel> tagsList = DAOForum.getTags();
			return (String) tagsList.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return null;
		}
	}

	public PostagemModel[] getPostagens(int idTopico) {
		try {
			List<PostagemModel> postagensList = DAOForum.getPostagens(idTopico);
			return (PostagemModel)postagensList.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return null;
		}
	}

	public boolean curtirTopico(int idTopico, boolean curtir) {
		try {
			if(DAOForum.curtirTopico(idTopico, curtir)) {
				return true;
			} else {
				msgErro = DAOForum.getMsgErro;
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return false;
		}
	}

	public boolean postarPostagem(int idTopico, PostagemModel postagem) {
		try {
			if(DAOForum.postarPostagem(idTopico, postagem)) {
				return true;
			} else {
				msgErro = DAOForum.getMsgErro;
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return false;
		}
	}

	public boolean criarTopico(TopicoModel topico) {
		try {
			if(DAOForum.criarTopico(topico)){
				return true;
			} else {
				msgErro = DAOForum.getMsgErro();
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro;
			return false;
		}
	}

}