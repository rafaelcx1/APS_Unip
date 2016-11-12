package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import model.CadastroModel;
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
		cadastroView.focus();
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
			String perguntaSecreta = cadastroView.getPerguntaSecret();
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
			usuarioModel.setQtdPostagens(0);
			usuarioModel.setDataCadastro(LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonth() + "/" + LocalDate.now().getYear());
			usuarioModel.setAvatar(0);

			if(cadastroModel.cadastrarUsuario(usuarioModel)) {
				cadastroView.displayMsg("Usuário cadastrado com sucesso!");
				MainController.abrirTelaLogin();
				cadastroView.fechar();
			} else {
				cadastroView.displayMsg(cadastroModel.getMsgErro());
			}
		}
	}

	private class BtnVoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				MainController.abrirTelaLogin();
				cadastroView.fechar();
			} catch (Exception e2) {
				cadastroView.displayMsg("Ocorreu um erro ao voltar!" + e2.getMessage());
			}

		}

	}



}
