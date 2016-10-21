package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.CadastroModel;
import model.UsuarioModel;
import view.CadastroView;
import view.LoginView;

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
			String estado = cadastroView.getEstado();
			String cidade = cadastroView.getCidade();
			int perguntaSecreta = cadastroView.getPerguntaSecret();
			String respostaSecreta = cadastroView.getRespostaSecret();
			
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setNome(nome);
			usuarioModel.setUsuario(usuario);
			usuarioModel.setSenha(senha);
			usuarioModel.setDataNasc(dataNasc);
			usuarioModel.setGenero(genero);
			usuarioModel.setEstado(estado);
			usuarioModel.setCidade(cidade);
			usuarioModel.setPerguntaSecret(perguntaSecreta);
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
