package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.UsuarioLoginModel;

public class DAOForum {

	public static EntityManagerFactory factory;
	public static EntityManager manager;

	public static boolean conferirLogin(UsuarioLoginModel usuario){
		factory = Persistence.createEntityManagerFactory("forum");
		manager = factory.createEntityManager();
		UsuarioModelLogin usuarioEncontrado = manager.find(UsuarioLoginModel.class, usuario.getUsuario())
	}
}
