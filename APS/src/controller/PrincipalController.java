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

		principalView.setBtnInicioListener(new BtnInicioListener());
		principalView.setBtnMeuPerfilListener(new BtnMeuPerfilListener());
		principalView.setBtnMinhasPostagensListener(new BtnMinhasPostagensListener());
		principalView.setBtnSairListener(new BtnSairListener());

		principalView.setVisible(true);
		abrirPrincipalForumPanel();


	}

	private void atualizar() {
		String[] usuariosMaisAtivos = principalModel.getUsuariosMaisAtivos();
		String[] tagsMaisAtivas = principalModel.getTagsMaisAtivas();
		String[] topicosMaisCurtidos = principalModel.getTopicosMaisCurtidos();
		principalView.atualizar(MainController.getUsuarioConectado(), usuariosMaisAtivos, tagsMaisAtivas, topicosMaisCurtidos);
	}

	private void abrirPrincipalForumPanel() {
		String[] usuariosMaisAtivos = principalModel.getUsuariosMaisAtivos();
		String[] tagsMaisAtivas = principalModel.getTagsMaisAtivas();
		String[] topicosMaisCurtidos = principalModel.getTopicosMaisCurtidos();
		if(usuariosMaisAtivos == null || tagsMaisAtivas== null || topicosMaisCurtidos == null) {
			principalView.displayMsg("Ocorreu um erro ao buscar as dados da barra lateral. " + principalModel.getMsgErro());
		}

		principalView.setBarraVerticalDados(principalModel.getUsuariosMaisAtivos(), principalModel.getTagsMaisAtivas(), principalModel.getTopicosMaisCurtidos());
		principalModel.atualizarTopicos(null);
		principalView.abrirPrincipalForumPanel(principalModel.getTags(), principalModel.getTopicos(0));

		principalView.setBtnCriarTopicoListener(new BtnCriarTopicoListener());
		principalView.setBtnNextListener(new BtnNextListener());
		principalView.setBtnPreviousListener(new BtnPreviousListener());
		principalView.setBtnFiltrarListener(new BtnFiltrarListener());
		principalView.setFiltrarDataTopicosListener(new LblFiltrarDataTopicosListener());

		principalView.setBtnCurtirListener(new BtnCurtirListener());
		principalView.setBtnVisualizarListener(new BtnVisualizarListener());
	}

	private class BtnCurtirListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			BotaoTopicoPanel botaoTopicoPanel = (BotaoTopicoPanel) e.getSource();
			int idTopico = botaoTopicoPanel.getIdTopico();
			boolean curtir = principalView.getPrincipalForumPanel().getTopicoPanel(idTopico).isCurtido();
			if(principalModel.curtirTopico(idTopico, curtir)) {
				principalView.getPrincipalForumPanel().getTopicoPanel(idTopico).curtir();
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
		}

	}

	private class BtnSalvarPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!principalView.getPerfilPanel().trocarSenha()) {
				UsuarioModel usuarioModel = new UsuarioModel();
				usuarioModel = principalView.getPerfilPanel().getUsuarioModel();
				if(principalModel.atualizarPerfil(usuarioModel)){
					principalView.displayMsg("Perfil atualizado !");
					abrirPrincipalForumPanel();
					atualizar();
				}else{
					principalView.displayMsg(principalModel.getMsgErro());
				}
			} else if(principalView.getPerfilPanel().validarSenha() & principalView.getPerfilPanel().trocarSenha()){
				UsuarioModel usuarioModel = new UsuarioModel();
				usuarioModel = principalView.getPerfilPanel().getUsuarioModel();
				if(principalModel.atualizarPerfil(usuarioModel)){
					principalView.displayMsg("Perfil atualizado !");
					abrirPrincipalForumPanel();
					atualizar();
				}else{
					principalView.displayMsg(principalModel.getMsgErro());
				}
			} else {
				principalView.displayMsg("Os campos de senha tem que conter valores iguais!");
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
				abrirPrincipalForumPanel();
				principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(0);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnMeuPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirPerfilPanel(MainController.getUsuarioConectado());
			principalView.setBtnSalvarPerfilListener(new BtnSalvarPerfilListener());
			principalView.setBtnVoltarListener(new BtnVoltarListener());
		}

	}

	private class BtnInicioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abrirPrincipalForumPanel();
		}

	}

	private class BtnFiltrarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			FiltroModel filtroModel = new FiltroModel();
			filtroModel = principalView.getPrincipalForumPanel().getPanelFiltros().getFiltroModel();
			if(principalModel.atualizarTopicos(filtroModel)) {
				principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(0);
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}
		}

	}

	private class BtnNextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int pagina = principalView.getPrincipalForumPanel().getPagina() + 1;
			TopicoModel[] topicos = principalModel.getTopicos(pagina);
			if(topicos != null) {
				principalView.getPrincipalForumPanel().setTopicos(topicos);
				principalView.getPrincipalForumPanel().next();
				principalView.setBtnCurtirListener(new BtnCurtirListener());
				principalView.setBtnVisualizarListener(new BtnVisualizarListener());
			}
		}

	}

	private class BtnPreviousListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.getPrincipalForumPanel().prev();
			int pagina = principalView.getPrincipalForumPanel().getPagina();
			principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(pagina));
			principalView.setBtnCurtirListener(new BtnCurtirListener());
			principalView.setBtnVisualizarListener(new BtnVisualizarListener());
		}

	}

	private class BtnVoltarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			abrirPrincipalForumPanel();
			atualizar();
		}

	}

	private class BtnPostarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PostagemModel postagem = principalView.getCriarTopicoPanel().getPostagemModel();
			UsuarioModel usuario = MainController.getUsuarioConectado();
			postagem.setUsuario(usuario);
			postagem.getTopico().setUsuario(usuario);
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
			PostagemModel postagem = principalView.getVisualizarTopicoPanel().getResponderTopicoPanel().getPostagemModel();
			UsuarioModel usuario = MainController.getUsuarioConectado();
			postagem.setUsuario(usuario);
			int idTopico = principalView.getVisualizarTopicoPanel().getResponderTopicoPanel().getIdTopico();
			if(principalModel.postarPostagem(idTopico, postagem)) {
				principalView.displayMsg("Postagem feita com sucesso!");
				principalView.abrirVisualizarTopicoPanel(principalModel.getPostagens(idTopico));
				principalView.setBtnResponderTopicoListener(new BtnResponderTopicoListener());
				principalView.setBtnVoltarListener(new BtnVoltarListener());
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
				principalView.setBtnResponderTopicoListener(new BtnResponderTopicoListener());
				principalView.setBtnVoltarListener(new BtnVoltarListener());
			} catch(Exception e1) {
				principalView.displayMsg(principalModel.getMsgErro());
				e1.printStackTrace();
			}
		}

	}

	private class BtnCriarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.abrirCriarTopicoPanel(principalModel.getTags());
			principalView.setBtnPostarTopicoListener(new BtnPostarTopicoListener());
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
				principalView.getPrincipalForumPanel().setTopicos(principalModel.getTopicos(0));
				principalView.getPrincipalForumPanel().setPaginaAtual(0);
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
			principalView.setBtnVoltarListener(new BtnVoltarListener());
			principalView.setBtnResponderTopicoListener(new BtnResponderTopicoFecharListener());
			principalView.setBtnPostarRespostaListener(new BtnPostarRespostaListener());
		}

	}

	private class BtnResponderTopicoFecharListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			principalView.getVisualizarTopicoPanel().fecharPanelResposta();
			principalView.abrirVisualizarTopicoPanel(principalModel.getPostagens(principalView.getVisualizarTopicoPanel().getIdTopico()));
			principalView.setBtnVoltarListener(new BtnVoltarListener());
			principalView.setBtnResponderTopicoListener(new BtnResponderTopicoListener());
		}

	}
}