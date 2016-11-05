package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.models.FiltroModel;
import model.models.TagsMaisAtivasModel;
import model.models.UsuarioAtivoModel;
import model.models.UsuarioLoginModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;


public class DAOForum {

	private static String msgErro;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("forum");
	private static EntityManager manager;


	public static String getMsgErro() {
		String msgErroTemp = msgErro;
		msgErro = null;
		return msgErroTemp;
	}

	public static boolean atualizarPerfil(UsuarioModel usuario) {
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e){
			if(manager != null)
				manager.getTransaction().rollback();
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao atualizar o perfil.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}


	public static UsuarioModel conferirUsuario(UsuarioLoginModel usuario){
		try {
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = null;
			if(factory != null & manager != null)
				usuarioEncontrado = manager.find(UsuarioModel.class, usuario.getUsuario());

			return usuarioEncontrado;
		} catch (Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static UsuarioModel conferirUsuario(String usuario){
		try {
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = null;
			if(factory != null & manager != null)
				usuarioEncontrado = manager.find(UsuarioModel.class, usuario);

			return usuarioEncontrado;
		} catch (Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean cadastrarUsuario(UsuarioModel usuario){
		try {
			UsuarioModel temp = conferirUsuario(usuario.getUsuario());
			if(temp == null){
				manager = factory.createEntityManager();
				if(factory != null & manager != null) {
					manager.getTransaction().begin();
					manager.persist(usuario);
					manager.getTransaction().commit();
				}
				return true;
			} else {
				msgErro = "Usuário já existe";
				return false;
			}
		} catch(Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			msgErro = "Ocorreu um erro ao cadastrar usuário.\nMensagem do erro: " + e.getMessage();
			e.printStackTrace();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean trocarSenha(UsuarioModel usuario){
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.merge(usuario);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e){
			if(factory != null & manager != null)
				manager.getTransaction().rollback();

			e.printStackTrace();
			msgErro = "Ocorreu um erro ao trocar a senha.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TopicoModel> getTopicos(FiltroModel filtro) {
		String filtros = "where";
		short contaFiltros = 0;

		if(filtro.getUsuario() != null & !filtro.getUsuario().equals("")) {
			filtros += " t.usuario = " + filtro.getUsuario() + ",";
			contaFiltros++;
		}

		if(filtro.getData() != null & !filtro.getData().equals("")) {
			filtros += " t.data = " + filtro.getData() + ",";
			contaFiltros++;
		}

		if(filtro.getTag() != null & !filtro.getTag().equals("")) {
			filtros += " t.tag = " + filtro.getTag() + ",";
			contaFiltros++;
		}

		if(filtro.getTitulo() != null & !filtro.getTitulo().equals("")) {
			filtros += " t.titulo = " + filtro.getTitulo() + ",";
			contaFiltros++;
		}

		if(contaFiltros > 0)
			filtros.substring(0, filtros.length() - 1);
		else
			filtros = "";

		if(filtro.getOrderDate() == FiltroModel.DESCENDENTE) {
			filtros += " order by t.dtCriacao DESC";
		} else {
			filtros += " order by t.dtCriacao ASC";
		}

		try {
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = null;
			if(factory != null & manager != null)
				topicos = manager.createQuery("from TopicoModel t " + filtros, TopicoModel.class).getResultList();

			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao solicitar os tópicos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}

	}

	public static List<PostagemModel> getPostagens(int idTopico) {
		try {
			manager = factory.createEntityManager();
			List<PostagemModel> postagens = null;
			if(factory != null & manager != null)
				postagens = manager.createQuery("from PostagemModel p where p.idTopico = " + idTopico + " order by p.dataPost", PostagemModel.class).getResultList();

			return postagens;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as postagens.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TopicoModel> getTopicosMaisCurtidos() {
		try {
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = null;

			if(factory != null & manager != null)
				topicos = manager.createQuery("from TopicoModel t where t.qtdCurtidas > 0 order by t.qtdCurtidas DESC", TopicoModel.class).setMaxResults(10).getResultList();

			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os tópicos mais curtidos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<UsuarioAtivoModel> getUsuariosMaisAtivos() {
		try {
			manager = factory.createEntityManager();
			List<UsuarioAtivoModel> usuariosAtivos = null;
			if(factory != null & manager != null)
				usuariosAtivos = manager.createQuery("select new model.models.UsuarioAtivoModel(usuario, count(*) as qtdPostagens) from PostagemModel p group by p.usuario order by qtdPostagens DESC", UsuarioAtivoModel.class).setMaxResults(10).getResultList();

			return usuariosAtivos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os usuários mais ativos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static List<TagsMaisAtivasModel> getTagsMaisAtivas() {
		try {
			manager = factory.createEntityManager();
			List<TagsMaisAtivasModel> tags = null;
			if(factory != null & manager != null)
				tags = manager.createQuery("select new model.models.TagsMaisAtivasModel(t.tag, count(t.idTopico) as qtdPublicacoes) from TopicoModel t group by t.tag order by qtdPublicacoes DESC", TagsMaisAtivasModel.class).setMaxResults(10).getResultList();

			return tags;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as tags mais ativas.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean curtirTopico(int idTopico, boolean curtir){
		try {
			manager = factory.createEntityManager();
			int rows = 0;
			manager.getTransaction().begin();
			if(factory != null & manager != null) {
				if(curtir)
					rows = manager.createQuery("update TopicoModel t set t.qtdCurtidas = t.qtdCurtidas + 1 where t.idTopico = " + idTopico).executeUpdate();
				else
					rows = manager.createQuery("update TopicoModel t set t.qtdCurtidas = t.qtdCurtidas - 1 where t.idTopico = " + idTopico).executeUpdate();
			}
			manager.getTransaction().commit();
			System.out.println(rows + " linhas afetadas");
			return true;
		} catch(Exception e) {
			if(manager != null)
				manager.getTransaction().rollback();
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao curtir/descurtir o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean postarPostagem(PostagemModel postagem, int idTopico) {
		try {
			manager = factory.createEntityManager();
			postagem.setTopico(manager.getReference(TopicoModel.class, idTopico));
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.merge(postagem);
				manager.createQuery("update TopicoModel t set t.qtdRespostas = t.qtdRespostas + 1 where t.idTopico = " + idTopico).executeUpdate();
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar a resposta.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static boolean postarTopico(TopicoModel topico) {
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.merge(topico);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	//Para testar
	public static boolean postarTopico(PostagemModel topico) {
		try {
			manager = factory.createEntityManager();
			if(factory != null & manager != null) {
				manager.getTransaction().begin();
				manager.persist(topico);
				manager.getTransaction().commit();
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexaoEntity();
		}
	}

	public static void closeConexaoFactory() {
		if(factory != null) {
			factory.close();
			factory = null;
		}
	}

	private static void closeConexaoEntity() {
		if(factory != null & manager != null) {
			manager.close();
			manager = null;
		}
	}

}
