package model;

import java.util.List;

import dao.DAOForum;
import model.models.FiltroModel;
import model.models.TagsMaisAtivasModel;
import model.models.UsuarioAtivoModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;

public class PrincipalModel {

	private TopicoModel[] topicos;
	private String[] tags = {"Hardware|TI", "Redes e Internet|TI", "EdiÃ§Ã£o de Ã�udio e VÃ­deo|TI", "ProgramaÃ§Ã£o|TI", "Sistemas Operacionais|TI", "Jogos", "HQs e MangÃ¡s", "NotÃ­cias"};
	private String msgErro;

	public PrincipalModel() {

	}

	public TopicoModel[] getTopicos(int numeroPag) {
		return topicos;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public boolean atualizarTopicos(FiltroModel filtro) {
		try {
			if(filtro == null){
				filtro = new FiltroModel();
			}
			List<TopicoModel> topicosList = DAOForum.getTopicos(filtro);
			topicos = new TopicoModel[topicosList.size()];
			topicos = (TopicoModel[]) topicosList.toArray();
			return true;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}

	public TopicoModel[] getTopicosMaisCurtidos() {
		try {
			List<TopicoModel> topicosMaisCurtidos = DAOForum.getTopicosMaisCurtidos();
			return (TopicoModel[])topicosMaisCurtidos.toArray();
		} catch (Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public UsuarioAtivoModel[] getUsuariosMaisAtivos() {
		try {
			List<UsuarioAtivoModel> usuariosMaisAtivos = DAOForum.getUsuariosMaisAtivos();
			return (UsuarioAtivoModel[])usuariosMaisAtivos.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public TagsMaisAtivasModel[] getTagsMaisAtivas() {
		try {
			List<TagsMaisAtivasModel> tagsMaisAtivas = DAOForum.getTagsMaisAtivas();
			return (TagsMaisAtivasModel[])tagsMaisAtivas.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public String[] getTags() {
		return tags;
	}

	public PostagemModel[] getPostagens(int idTopico) {
		try {
			List<PostagemModel> postagensList = DAOForum.getPostagens(idTopico);
			return (PostagemModel[])postagensList.toArray();
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public boolean curtirTopico(int idTopico, boolean curtir) {
		try {
			if(DAOForum.curtirTopico(idTopico, curtir)) {
				return true;
			} else {
				msgErro = DAOForum.getMsgErro();
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}

	public boolean postarPostagem(int idTopico, PostagemModel postagem) {
		try {
			if(DAOForum.postarPostagem(postagem, idTopico)) {
				return true;
			} else {
				msgErro = DAOForum.getMsgErro();
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}

	public boolean postarTopico(TopicoModel topico) {
		try {
			if(DAOForum.postarTopico(topico)){
				return true;
			} else {
				msgErro = DAOForum.getMsgErro();
				return false;
			}
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}



}
