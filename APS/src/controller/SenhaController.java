package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			try {
				String senha = senhaView.getSenha();
				String repetirSenha = senhaView.getNovaSenha();

				if(senha.equals(repetirSenha)) {
					senhaModel.trocarSenha(senha);
					senhaView.displayMsg("Senha trocada com sucesso !");
					MainController.abrirTelaLogin();
				} else {
					senhaView.displayMsg("Verfique corretamente os campos ! ");
				}
			} catch (Exception e2) {
				senhaView.displayMsg(senhaModel.getMsgErro());
			}
		}

	}

	private class VoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			try {

				MainController.abrirTelaLogin();

			} catch (Exception e2) {

				senhaView.displayMsg("Ocorreu um erro ao voltar !" + e2.getMessage());
			}

		}

	}

	private class ConferirRespostaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String resposta = senhaView.getResposta();
				if(senhaModel.conferirResposta(resposta)){
					senhaView.setRegiaoNovaSenhaEnable(true);
					senhaView.setLblStatusResposta("Conferido !");
					senhaView.setRegiaoPerguntaEnable(false);
				} else {
					senhaView.setLblStatusResposta("Resposta incorreta!");
				}
			} catch (Exception e2) {
				senhaView.displayMsg(senhaModel.getMsgErro());
			}
		}

	}

	private class ConferirUsuarioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String usuario = senhaView.getUsuario();
				if(senhaModel.conferirUsuario(usuario)){
					senhaView.setRegiaoUsuarioEnable(false);
					senhaView.setRegiaoPerguntaEnable(true);
					String pergunta = senhaModel.getPergunta();
					senhaView.setLblPergunta(pergunta);
					senhaView.setLblStatusUsuario("Conferido!");
				} else {
					senhaView.setLblStatusUsuario("Usuário não encontrado !");
				}
			} catch (Exception e2) {
				senhaView.displayMsg(senhaModel.getMsgErro());
			}
		}

	}

}
