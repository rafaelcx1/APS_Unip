package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.SenhaModel;
import view.SenhaView;

public class SenhaController {
	private SenhaModel senhaModel;
	private SenhaView senhaView;

	public SenhaController(SenhaModel senhaModel, SenhaView senhaView){
		this.senhaModel = senhaModel;
		this.senhaView = senhaView;
		
		senhaView.setConferirUsuarioListener(new ConferirUsuarioListener());
		senhaView.setConferirRespostaListener(new ConferirRespostaListener());
		senhaView.setConcluirListener(new ConcluirListener());
		senhaView.setVoltarListener(new VoltarListener());

		
		
	}


	private class ConcluirListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

	private class VoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

	private class ConferirRespostaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

	private class ConferirUsuarioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserir Código

		}

	}

}
