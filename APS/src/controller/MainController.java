package controller;

import model.CadastroModel;
import model.LoginModel;
import model.PrincipalModel;
import model.SenhaModel;
import model.UsuarioModel;
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
	private static UsuarioModel usuarioModel;

	public MainController(){
	}

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
		setJanelasNull();
		MainController.loginModel = new LoginModel();
		MainController.loginView = new LoginView();
		MainController.loginController = new LoginController(MainController.loginModel, MainController.loginView);
	}

	public static void abrirTelaCadastro(){
		setJanelasNull();
		MainController.cadastroModel = new CadastroModel();
		MainController.cadastroView = new CadastroView();
		MainController.cadastroController = new CadastroController(MainController.cadastroModel, MainController.cadastroView);
	}

	public static void abrirTelaSenha(){
		setJanelasNull();
		MainController.senhaModel = new SenhaModel();
		MainController.senhaView = new SenhaView();
		MainController.senhaController = new SenhaController(MainController.senhaModel, MainController.senhaView);
	}

	public static void abrirTelaPrincipalUsuario(UsuarioModel usuarioConectado){
		setJanelasNull();
		MainController.principalModel = new PrincipalModel();
		MainController.principalView = new PrincipalView(MainController.usuarioModel);
		MainController.principalController = new PrincipalController(MainController.principalModel, MainController.principalView, MainController.usuarioModel);
	}

	public static void main(String[] args) {
		MainController.abrirTelaLogin();
	}

}
