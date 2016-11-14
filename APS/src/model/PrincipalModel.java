package model;

import java.util.List;

import dao.DAOForum;
import model.models.FiltroModel;
import model.models.TagsMaisAtivasModel;
import model.models.UsuarioAtivoModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;

public class PrincipalModel {

	private TopicoModel[] topicos;
	private String[] tags = {"Hardware|TI", "Redes e Internet|TI", "Edição de Áudio e Vídeo|TI", "Programação|TI", "Sistemas Operacionais|TI", "Jogos", "HQs e Mangás", "Notícias"};
	private String msgErro;

	public PrincipalModel() {

	}

	public TopicoModel[] getTopicos(int numeroPag) {
		if(numeroPag * 5 < this.topicos.length) {
			TopicoModel[] topicos = new TopicoModel[5];
			for(int contador = 0; contador < 5; contador++){
				if(contador + (numeroPag * 5) < this.topicos.length)
					topicos[contador] = this.topicos[contador + (numeroPag * 5)];
			}
			return topicos;
		} else {
			return null;
		}
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
			for(int contador = 0; contador < topicos.length; contador++){
				topicos[contador] = topicosList.get(contador);
			}
			return true;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return false;
		}
	}

	public boolean atualizarPerfil(UsuarioModel usuario) {
		if(DAOForum.atualizarPerfil(usuario)){
			return true;
		} else {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}

	public String[] getTopicosMaisCurtidos() {
		try {
			List<TopicoModel> topicosMaisCurtidosList = DAOForum.getTopicosMaisCurtidos();
			String[] topicosMaisCurtidos = new String[5];
			for(int contador = 0; contador < topicosMaisCurtidosList.size(); contador++) {
				if(topicosMaisCurtidosList.get(contador) != null)
					topicosMaisCurtidos[contador] = "Título: " + topicosMaisCurtidosList.get(contador).getTitulo() + " | Curtidas: " + topicosMaisCurtidosList.get(contador).getQtdCurtidas() + " | Tag: " + topicosMaisCurtidosList.get(contador).getTag() + " | Usuário: " + topicosMaisCurtidosList.get(contador).getUsuario().getUsuario();
			}
			return topicosMaisCurtidos;
		} catch (Exception e) {
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return null;
		}
	}

	public String[] getUsuariosMaisAtivos() {
		try {
			List<UsuarioAtivoModel> usuariosMaisAtivosList = DAOForum.getUsuariosMaisAtivos();
			String[] usuariosMaisAtivos = new String[5];
			for(int contador = 0; contador < usuariosMaisAtivosList.size(); contador++) {
				UsuarioAtivoModel usuarioAtivo = usuariosMaisAtivosList.get(contador);
				if(usuarioAtivo != null)
					usuariosMaisAtivos[contador] = "Usuário: " + usuariosMaisAtivosList.get(contador).getUsuario() + " | Publicações: " + usuariosMaisAtivosList.get(contador).getNumPublicacoes();
			}
			return usuariosMaisAtivos;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return null;
		}
	}

	public String[] getTagsMaisAtivas() {
		try {
			List<TagsMaisAtivasModel> tagsMaisAtivasList = DAOForum.getTagsMaisAtivas();
			String[] tagsMaisAtivas = new String[5];
			for(int contador = 0; contador < tagsMaisAtivasList.size(); contador++) {
				if(tagsMaisAtivasList.get(contador) != null)
					tagsMaisAtivas[contador] = "Tag: " + tagsMaisAtivasList.get(contador).getNome() + " | Publicações: " + tagsMaisAtivasList.get(contador).getNumPublicacoes();
			}
			return tagsMaisAtivas;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return null;
		}
	}

	public String[] getTags() {
		return tags;
	}

	public PostagemModel[] getPostagens(int idTopico) {
		try {
			List<PostagemModel> postagensList = DAOForum.getPostagens(idTopico);
			PostagemModel[] postagens = new PostagemModel[postagensList.size()];
			for(int contador = 0; contador < postagensList.size(); contador++){
				postagens[contador] = postagensList.get(contador);
			}
			return postagens;
		} catch(Exception e) {
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
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

	public boolean postarTopico(PostagemModel topico) {
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
