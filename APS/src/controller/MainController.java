package controller;

import dao.DAOForum;
import model.CadastroModel;
import model.LoginModel;
import model.PrincipalModel;
import model.SenhaModel;
import model.tables.UsuarioModel;
import view.CadastroView;
import view.LoginView;
import view.PrincipalView;
import view.SenhaView;

public class MainController {

	private static UsuarioModel usuarioConectado;
	private static LoginController loginController;

	public static void abrirTelaLogin(){
		loginController = new LoginController(new LoginModel(),  new LoginView());
		loginController.setCamposEnabled();
	}

	public static void abrirTelaCadastro(){
		new CadastroController(new CadastroModel(), new CadastroView());
	}

	public static void abrirTelaSenha(){
		new SenhaController(new SenhaModel(), new SenhaView());
	}

	public static void abrirTelaPrincipalUsuario(UsuarioModel usuarioConectado){
		MainController.usuarioConectado = usuarioConectado;
		new PrincipalController(new PrincipalModel(), new PrincipalView(usuarioConectado));
	}

	public static UsuarioModel getUsuarioConectado() {
		usuarioConectado = DAOForum.conferirUsuario(usuarioConectado.getUsuario());
		return usuarioConectado;
	}

	public static void sair() {
		System.exit(0);
	}

	public static void main(String[] args) {
		new Thread() {
			public void run(){
				DAOForum.iniciarFactory();
				loginController.setCamposEnabled();
			}
		}.start();
		loginController = new LoginController(new LoginModel(),  new LoginView());
	}

}
