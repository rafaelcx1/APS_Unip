package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.LoginModel;
import view.LoginView;

public class LoginController {
	private LoginModel loginModel;
	private LoginView loginView;

	public LoginController(LoginModel loginModel, LoginView loginView){
		this.loginModel = loginModel;
		this.loginView = loginView;
		//Inserir C�digo
	}


	private class TextFieldListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			//Inserir C�digo

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	private class BtnLogarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir C�digo

		}

	}

	private class LblEsqueciSenhaListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// Inserir C�digo

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// Inserir C�digo

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// Inserir C�digo

		}

	}

	private class BtnSairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir C�digo

		}

	}

}
