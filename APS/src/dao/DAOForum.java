package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.UsuarioLoginModel;
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

	private static void closeConexao() {
		factory.close();
		manager.close();
		factory = null;
		manager = null;
	}
}
