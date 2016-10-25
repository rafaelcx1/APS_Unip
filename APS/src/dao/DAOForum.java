package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.models.FiltroModel;
import model.tables.TagsModel;
import model.tables.TopicoModel;
import model.tables.UsuarioLoginModel;
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

	@SuppressWarnings("unchecked")
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
			List<TopicoModel> topicos = manager.createQuery("select * from topicos where" + filtros).getResultList();
			return topicos;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao solicitar os tópicos.\nMensagem do erro: " + e.getMessage();
			return null;

		} finally {
			closeConexao();
		}

	}

	@SuppressWarnings("unchecked")
	public static List<TagsModel> getTags() {
		try{
			factory = Persistence.createEntityManagerFactory("forum");
			manager = factory.createEntityManager();
			List<TagsModel> tags = manager.createQuery("select * from tags").getResultList();
			return tags;
		} catch(Exception e) {
			e.printStackTrace();
			msgErro = "Ocorreu um erro ao solicitar as tags.\nMensagem do erro: " + e.getMessage();
			return null;
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