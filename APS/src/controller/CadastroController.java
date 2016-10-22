package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CadastroModel;
import model.tables.PerguntasModel;
import model.tables.UsuarioModel;
import view.CadastroView;

public class CadastroController {
	private CadastroModel cadastroModel;
	private CadastroView cadastroView;

	public CadastroController(CadastroModel cadastroModel, CadastroView cadastroView){
		this.cadastroModel = cadastroModel;
		this.cadastroView = cadastroView;

		cadastroView.setBtnCadastroListener(new BtnCadastroListener());
		cadastroView.setBtnVoltarListener(new BtnVoltarListener());
		cadastroView.setVisible(true);
	}


	private class BtnCadastroListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String nome = cadastroView.getNome();
			String usuario = cadastroView.getUsuario();
			String senha = cadastroView.getSenha();
			String dataNasc = cadastroView.getDataNasc();
			String genero = cadastroView.getGenero();
			int perguntaSecreta = cadastroView.getPerguntaSecret();
			String respostaSecreta = cadastroView.getRespostaSecret();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setNome(nome);
			usuarioModel.setUsuario(usuario);
			usuarioModel.setSenha(senha);
			usuarioModel.setDataNasc(dataNasc);
			usuarioModel.setGenero(genero);
			usuarioModel.setPerguntaSecret(new PerguntasModel(perguntaSecreta));
			usuarioModel.setRespostaSecret(respostaSecreta);

			try {
				cadastroModel.cadastrarUsuario(usuarioModel);
			} catch (Exception e2) {
				cadastroView.displayMsg("Ocorreu um erro na aplicação !" +e2.getMessage());
			}



		}

	}

	private class BtnVoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				MainController.abrirTelaLogin();
			} catch (Exception e2) {
				cadastroView.displayMsg("Ocorreu um erro na aplicação !" + e2.getMessage());
			}

		}

	}



}
