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
import model.tables.TagsModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;


public class DAOForum {

	private static String msgErro;
	private static EntityManagerFactory factory;
	private static EntityManager manager;


	public static String getMsgErro() {
		String msgErroTemp = msgErro;
		msgErro = null;
		return msgErroTemp;
	}

	public static UsuarioModel conferirUsuario(UsuarioLoginModel usuario){
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = manager.find(UsuarioModel.class, usuario.getUsuario());
			closeConexao();
			return usuarioEncontrado;
		} catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static UsuarioModel conferirUsuario(String usuario){
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			UsuarioModel usuarioEncontrado = manager.find(UsuarioModel.class, usuario);
			closeConexao();
			return usuarioEncontrado;
		} catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao conferir usuário.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static boolean cadastrarUsuario(UsuarioModel usuario){
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			closeConexao();
			return true;
		} catch(Exception e){
			manager.getTransaction().rollback();
			msgErro = "Ocorreu um erro ao cadastrar usuário.\nMensagem do erro: " + e.getMessage();
			e.printStackTrace();
			return false;
		} finally {
			closeConexao();
		}
	}

	public static boolean trocarSenha(UsuarioModel usuario){
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			return true;
		} catch(Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao trocar a senha.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexao();
		}
	}

	public static List<TopicoModel> getTopicos(FiltroModel filtro) {
		String filtros = "";

		if(filtro.getUsuario() != null & !filtro.getUsuario().equals("")) {
			filtros += " usuario = " + filtro.getUsuario() + ",";
		}

		if(filtro.getData() != null & !filtro.getData().equals("")) {
			filtros += " data = " + filtro.getData() + ",";
		}

		if(filtro.getTag() != null & !filtro.getTag().equals("")) {
			filtros += " tag = " + filtro.getTag() + ",";
		}

		if(filtro.getTitulo() != null & !filtro.getTitulo().equals("")) {
			filtros += " titulo = " + filtro.getTitulo() + ",";
		}

		filtros.substring(0, filtros.length() - 1);

		if(filtro.getOrderDate() == FiltroModel.DESCENDENTE) {
			filtros += " order by data DESC";
		} else {
			filtros += " order by data ASC";
		}

		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = manager.createQuery("select * from topicos where" + filtros, TopicoModel.class).getResultList();
			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao solicitar os tópicos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}

	}

	public static List<PostagemModel> getPostagens(int idTopico) {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<PostagemModel> postagens = manager.createQuery("select * from postagens where idTopico = " + idTopico + " order by data DESC", PostagemModel.class).getResultList();
			return postagens;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as postagens.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static List<TagsModel> getTags() {
		try{
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<TagsModel> tags = manager.createQuery("select * from tags", TagsModel.class).getResultList();
			return tags;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as tags.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}

	}

	public static List<TopicoModel> getTopicosMaisCurtidos() {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<TopicoModel> topicos = manager.createQuery("select * from topicos where qtdCurtidas > 0 order by qtdCurtidas DESC", TopicoModel.class).setMaxResults(10).getResultList();
			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os tópicos mais curtidos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static List<UsuarioAtivoModel> getUsuariosMaisAtivos() {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<UsuarioAtivoModel> usuariosAtivos = manager.createQuery("select new UsuarioAtivoModel(usuario, count(*) as qtdPostagens) from postagens group by usuario order by qtdPostagens DESC", UsuarioAtivoModel.class).setMaxResults(10).getResultList();
			return usuariosAtivos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar os usuários mais ativos.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static List<TagsMaisAtivasModel> getTagsMaisAtivas() {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<TagsMaisAtivasModel> tags = manager.createQuery("select new TagsMaisAtivasModel(tag, count(*) as qtdPublicacoes) from topicos group by tag order by qtdPublicacoes DESC", TagsMaisAtivasModel.class).setMaxResults(10).getResultList();
			return tags;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao consultar as tags mais ativas.\nMensagem do erro: " + e.getMessage();
			return null;
		} finally {
			closeConexao();
		}
	}

	public static boolean curtirTopico(int idTopico, boolean curtir){
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			int rows = 0;

			if(curtir)
				rows = manager.createQuery("update topicos set qtdCurtidas = qtdCurtidas + 1 where idTopico = " + idTopico).executeUpdate();
			else
				rows = manager.createQuery("update topicos set qtdCurtidas = qtdCurtidas - 1 where idTopico = " + idTopico).executeUpdate();

			System.out.println(rows + " linhas afetadas");
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao curtir/descurtir o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexao();
		}
	}

	public static boolean postarPostagem(PostagemModel postagem) {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(postagem);
			manager.getTransaction().commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar a resposta.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexao();
		}
	}

	public static boolean postarTopico(TopicoModel topico) {
		try {
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(topico);
			manager.getTransaction().commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao postar o tópico.\nMensagem do erro: " + e.getMessage();
			return false;
		} finally {
			closeConexao();
		}
	}

	private static void closeConexao() {
		factory.close();
		manager.close();
		factory = null;
		manager = null;
	}
}