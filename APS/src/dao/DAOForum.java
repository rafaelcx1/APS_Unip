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
		return msgErro;
	}

	public static UsuarioModel conferirLogin(UsuarioLoginModel usuario){
		factory = Persistence.createEntityManagerFactory("forum");
		manager = factory.createEntityManager();
		UsuarioModel usuarioEncontrado = manager.find(UsuarioModel.class, usuario.getUsuario());
		closeConexao();
		return usuarioEncontrado;
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
			msgErro = "Ocorreu um erro ao cadastrar usuário. \n Erro: " + e.getMessage();
			e.printStackTrace();
			return false;
		}
	}

	private static void closeConexao() {
		factory.close();
		manager.close();
		factory = null;
		manager = null;
	}
}
