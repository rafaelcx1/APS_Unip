package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.UsuarioLoginModel;
import model.tables.UsuarioModel;

public class DAOForum {

	private static EntityManagerFactory factory;
	private static EntityManager manager;

	public static UsuarioModel conferirLogin(UsuarioLoginModel usuario){
		factory = Persistence.createEntityManagerFactory("forum");
		manager = factory.createEntityManager();
		UsuarioModel usuarioEncontrado = manager.find(UsuarioModel.class, usuario.getUsuario());
		closeConexao();
		return usuarioEncontrado;
	}

	private static void closeConexao() {
		factory.close();
		manager.close();
		factory = null;
		manager = null;
	}
}
