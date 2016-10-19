package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.CadastroModel;
import view.CadastroView;

public class CadastroController {
	private CadastroModel cadastroModel;
	private CadastroView cadastroView;

	public CadastroController(CadastroModel cadastroModel, CadastroView cadastroView){
		this.cadastroModel = cadastroModel;
		this.cadastroView = cadastroView;

		// Inserir Código
	}


	private class BtnCadastroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

	private class BtnVoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

}
