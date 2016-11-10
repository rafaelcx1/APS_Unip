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


	private static LoginController loginController;
	private static LoginView loginView;
	private static LoginModel loginModel;
	private static SenhaController senhaController;
	private static SenhaView senhaView;
	private static SenhaModel senhaModel;
	private static CadastroController cadastroController;
	private static CadastroView cadastroView;
	private static CadastroModel cadastroModel;
	private static PrincipalController principalController;
	private static PrincipalView principalView;
	private static PrincipalModel principalModel;
	private static UsuarioModel usuarioConectado;

	public static void setJanelasNull(){
		MainController.loginController = null;
		MainController.loginView = null;
		MainController.loginModel = null;
		MainController.senhaController = null;
		MainController.senhaModel = null;
		MainController.senhaView = null;
		MainController.cadastroController = null;
		MainController.cadastroModel = null;
		MainController.cadastroView = null;
		MainController.principalController = null;
		MainController.principalModel = null;
		MainController.principalView = null;
	}

	public static void abrirTelaLogin(){
		MainController.loginModel = new LoginModel();
		MainController.loginView = new LoginView();
		MainController.loginController = new LoginController(MainController.loginModel, MainController.loginView);
		setJanelasNull();
	}

	public static void abrirTelaCadastro(){
		MainController.cadastroModel = new CadastroModel();
		MainController.cadastroView = new CadastroView();
		MainController.cadastroController = new CadastroController(MainController.cadastroModel, MainController.cadastroView);
		setJanelasNull();
	}

	public static void abrirTelaSenha(){
		MainController.senhaModel = new SenhaModel();
		MainController.senhaView = new SenhaView();
		MainController.senhaController = new SenhaController(MainController.senhaModel, MainController.senhaView);
		setJanelasNull();
	}

	public static void abrirTelaPrincipalUsuario(UsuarioModel usuarioConectado){
		MainController.usuarioConectado = usuarioConectado;
		MainController.principalModel = new PrincipalModel();
		MainController.principalView = new PrincipalView(MainController.usuarioConectado);
		MainController.principalController = new PrincipalController(MainController.principalModel, MainController.principalView);
		setJanelasNull();
	}

	public static UsuarioModel getUsuarioConectado() {
		return usuarioConectado;
	}

	public static void sair() {
		System.exit(0);
	}

	public static void main(String[] args) {
		DAOForum.iniciarFactory();
		MainController.abrirTelaLogin();
	}

}
