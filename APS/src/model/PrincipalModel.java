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

	public String[] getTopicosMaisCurtidos() {
		try {
			List<TopicoModel> topicosMaisCurtidosList = DAOForum.getTopicosMaisCurtidos();
			String[] topicosMaisCurtidos = new String[topicosMaisCurtidosList.size()];
			for(int contador = 0; contador < topicosMaisCurtidos.length; contador++) {
				topicosMaisCurtidos[contador] = "Título: " + topicosMaisCurtidosList.get(contador).getTitulo() + " | Curtidas: " + topicosMaisCurtidosList.get(contador).getQtdCurtidas() + " | Tag: " + topicosMaisCurtidosList.get(contador).getTag() + " | Usuário: " + topicosMaisCurtidosList.get(contador).getUsuario().getUsuario();
			}
			return topicosMaisCurtidos;
		} catch (Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public String[] getUsuariosMaisAtivos() {
		try {
			List<UsuarioAtivoModel> usuariosMaisAtivosList = DAOForum.getUsuariosMaisAtivos();
			String[] usuariosMaisAtivos = new String[usuariosMaisAtivosList.size()];
			for(int contador = 0; contador < usuariosMaisAtivos.length; contador++) {
				usuariosMaisAtivos[contador] = "Usuário: " + usuariosMaisAtivosList.get(contador).getUsuario().getNome() + " | Publicações: " + usuariosMaisAtivosList.get(contador).getNumPublicacoes();
			}
			return usuariosMaisAtivos;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			return null;
		}
	}

	public String[] getTagsMaisAtivas() {
		try {
			List<TagsMaisAtivasModel> tagsMaisAtivasList = DAOForum.getTagsMaisAtivas();
			String[] tagsMaisAtivas = new String[tagsMaisAtivas.size()];
			for(int contador = 0; contador < tagsMaisAtivas.length; contador++) {
				tagsMaisAtivas[contador] = "Tag: " + tagsMaisAtivasList.get(contador).getNome() + " | Publicações: " + tagsMaisAtivasList.get(contador).getNumPublicacoes();
			}
			return tagsMaisAtivas;
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
