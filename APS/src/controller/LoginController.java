package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.LoginModel;
import model.UsuarioLoginModel;
import view.LoginView;

public class LoginController {
	private LoginModel loginModel;
	private LoginView loginView;

	public LoginController(LoginModel loginModel, LoginView loginView){
		this.loginModel = loginModel;
		this.loginView = loginView;

		loginView.setTextFieldEvent(new TextFieldListener());
		loginView.setLblEsqueciSenhaEvent(new LblEsqueciSenhaListener());
		loginView.setLblCadastrarEvent(new LblCadastrarListener());
		loginView.setBtnLogarEvent(new BtnLogarListener());
		loginView.setBtnSairEvent(new BtnSairListener());
		loginView.setVisible(true);
	}


	private class TextFieldListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				loginView.botaoClick();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	private class BtnLogarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String usuario = loginView.getUsuario();
			String senha = loginView.getSenha();
			boolean validado = loginModel.conferirLogin(new UsuarioLoginModel(usuario, senha));
			if(validado == false){
				String msg = loginModel.getMsgErro();
				loginView.displayMsg(msg);
			} else {
				MainController.abrirTelaPrincipalUsuario(loginModel.getUsuarioLogado());
			}
		}

	}

	private class LblEsqueciSenhaListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			MainController.abrirTelaSenha();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			loginView.lblAcaoMouseEntered();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			loginView.lblAcaoMouseExited();
		}

	}

	private class BtnSairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			loginView.fechar();
			System.exit(0);
		}

	}

	private class LblCadastrarListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			MainController.abrirTelaCadastro();
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			loginView.lblAcaoMouseEntered();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			loginView.lblAcaoMouseExited();
		}

	}
}
