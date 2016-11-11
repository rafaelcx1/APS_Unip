package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.PrincipalModel;
import model.models.FiltroModel;
import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;
import view.BotaoTopicoPanel;
import view.PrincipalView;

public class PrincipalController {
	private PrincipalModel principalModel;
	private PrincipalView principalView;

	public PrincipalController(PrincipalModel principalModel, PrincipalView principalView){
		this.principalModel = principalModel;
		this.principalView = principalView;

		principalView.setBtnCriarTopicoListener(new BtnCriarTopicoListener());
		principalView.setBtnCurtirListener(new BtnCurtirListener());
		principalView.setBtnFiltrarListener(new BtnFiltrarListener());
		principalView.setBtnInicioListener(new BtnInicioListener());
		principalView.setBtnMeuPerfilListener(new BtnMeuPerfilListener());
		principalView.setBtnMinhasPostagensListener(new BtnMinhasPostagensListener());
		principalView.setBtnNextListener(new BtnNextListener());
		principalView.setBtnPreviousListener(new BtnPreviousListener());
		principalView.setBtnPostarRespostaListener(new BtnPostarRespostaListener());
		principalView.setBtnPostarTopicoListener(new BtnPostarTopicoListener());
		principalView.setBtnSairListener(new BtnSairListener());
		principalView.setBtnSalvarPerfilListener(new BtnSalvarPerfilListener());
		principalView.setBtnVisualizarListener(new BtnVisualizarListener());
		principalView.setBtnFiltrarListener(new BtnFiltrarListener());
		principalView.setFiltrarDataTopicosListener(new LblFiltrarDataTopicosListener());
		principalView.setBtnResponderTopicoListener(new BtnResponderTopicoListener());
		principalView.setBtnVoltarListener(new BtnVoltarListener());
		principalView.setVisible(true);
	}


	private class BtnCurtirListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BotaoTopicoPanel botaoTopicoPanel = (BotaoTopicoPanel) e.getSource();
			int idTopico = botaoTopicoPanel.getIdTopico();
			boolean curtir = principalView.getPrincipalForumPanel().getTopicoPanel(idTopico).isCurtido();
			if(principalModel.curtirTopico(idTopico, curtir)) {
				principalView.getPrincipalForumPanel().curtir(idTopico);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
		}

	}

	private class BtnSalvarPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel = principalView.getPerfilPanel().getUsuarioModel();
			if(principalModel.atualizarPerfil(usuarioModel)){
				principalView.displayMsg("Perfil atualizado !");
			}else{
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnSairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainController.sair();
		}

	}

	private class BtnMinhasPostagensListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FiltroModel filtroModel = new FiltroModel();
			filtroModel.setUsuario(MainController.getUsuarioConectado().getUsuario());
			if(principalModel.atualizarTopicos(filtroModel)) {
				principalView.setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(1);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
			
		}

	}

	private class BtnMeuPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirPerfilPanel(MainController.getUsuarioConectado());
			principalView.setBtnVoltarListener(new BtnVoltarListener());
		}

	}

	private class BtnInicioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirPrincipalForumPanel(principalModel.getTags());
		}

	}

	private class BtnFiltrarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FiltroModel filtroModel = new FiltroModel();
			filtroModel = principalView.getPrincipalForumPanel().getPanelFiltros().getFiltroData();
			if(principalModel.atualizarTopicos(filtroModel)) {
				principalView.setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(1);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
		}

	}

	private class BtnNextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.getPrincipalForumPanel().next();
			int pagina = principalView.getPrincipalForumPanel().getPagina();
			principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(pagina));
		}

	}

	private class BtnPreviousListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.getPrincipalForumPanel().prev();
			int pagina = principalView.getPrincipalForumPanel().getPagina();
			principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(pagina));
		}

	}

	private class BtnVoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirPrincipalForumPanel(principalModel.getTags());
		}

	}

	private class BtnPostarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PostagemModel postagem = principalView.getCriarTopicoPanel().getPostagemModel();
			postagem.setUsuario(MainController.getUsuarioConectado());
			postagem.getTopico().setUsuario(MainController.getUsuarioConectado());
			if(principalModel.postarTopico(postagem)) {
				principalView.displayMsg("Tópico postado com sucesso!");
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnPostarRespostaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PostagemModel postagem = principalView.getResponderTopicoPanel().getPostagemModel();
			postagem.setUsuario(MainController.getUsuarioConectado());
			int idTopico = principalView.getResponderTopicoPanel().getIdTopico();
			if(principalModel.postarPostagem(idTopico, postagem)) {
				principalView.displayMsg("Postagem feita com sucesso!");
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnVisualizarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BotaoTopicoPanel botaoTopicoPanel = (BotaoTopicoPanel) e.getSource();
			try {
				principalView.abrirVisualizarTopicoPanel(principalModel.getPostagens(botaoTopicoPanel.getIdTopico()));
			} catch(Exception e) {
				principalView.displayMsg(principalModel.getMsgErro());
			}
			principalView.setBtnVoltarListener(new BtnVoltarListener());
		}

	}

	private class BtnCriarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirCriarTopicoPanel(principalModel.getTags());
			principalView.setBtnVoltarListener(new BtnVoltarListener());
		}

	}

	private class LblFiltrarDataTopicosListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			FiltroModel filtroData = principalView.getPrincipalForumPanel().getPanelFiltros().getFiltroData();
			boolean dataAscendente = principalView.getPrincipalForumPanel().getPanelFiltros().getDataAscendente();
			principalView.getPrincipalForumPanel().getPanelFiltros().setDataAscendente(!dataAscendente);
			if(principalModel.atualizarTopicos(filtroData)) {
				principalView.setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(1);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			principalView.getPrincipalForumPanel().getPanelFiltros().lblFiltrarDataEntered();

		}

		@Override
		public void mouseExited(MouseEvent e) {
			principalView.getPrincipalForumPanel().getPanelFiltros().lblFiltrarDataExited();
		}

	}

	private class BtnResponderTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.getVisualizarTopicoPanel().abrirPanelResposta();
		}

	}
}
