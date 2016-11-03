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
import view.PrincipalView;

public class PrincipalController {
	private PrincipalModel principalModel;
	private PrincipalView principalView;
	private UsuarioModel usuarioConectado;

	public PrincipalController(PrincipalModel principalModel, PrincipalView principalView, UsuarioModel usuario){
		this.principalModel = principalModel;
		this.principalView = principalView;
		this.usuarioConectado = usuario;

		// Inserir CÃ³digo
	}


	private class BtnCurtirListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnSalvarPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnSairListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnMinhasPostagensListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnMeuPerfilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnInicioListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnFiltrarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnNextListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnPreviousListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnVoltarCriarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnPostarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			TopicoModel topico = principalView.getCriarTopicoPanel().getTopicoModel();
			PostagemModel postagemInicial = principalView.getCriarTopicoPanel().getPostagemModel();
			if(principalModel.postarTopico(topico)) {
				if(principalModel.postarPostagem(topico.getIdTopico(), postagemInicial)) {
					principalView.displayMsg("Tópico postado com sucesso!");
				} else {
					principalView.displayMsg(principalModel.getMsgErro());
				}
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnPostarRespostaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			PostagemModel postagem = principalView.getResponderTopicoPanel().getPostagemModel();
			if(principalModel.postarPostagem(postagem.getTopico().getIdTopico(), postagem)) {
				principalView.displayMsg("Postagem feita com sucesso!");
			} else {
				principalView.displayMsg(principalModel.getMsgErro());
			}

		}

	}

	private class BtnVisualizarListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnNextPagTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnPrevPagTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class BtnCriarTopicoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class LblFiltrarDataTopicosListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			FiltroModel filtroData = principalView.getPrincipalForumPanel().getPanelFiltros().getFiltroData();
			boolean dataAscendente = principalView.getPrincipalForumPanel().getPanelFiltros().getDataAscendente();
			principalView.getPrincipalForumPanel().getPanelFiltros().setDataAscendente(!dataAscendente);
			if(principalModel.atualizarTopicos(filtroData)) {
				TopicoModel[] topicos = principalModel.getTopicos(0);
				principalView.setTopicos(topicos);
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

}
