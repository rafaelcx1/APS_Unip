package view;

import java.awt.event.*;

import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;
import view.panels.BarraHorizontalPanel;
import view.panels.BarraVerticalPanel;
import view.panels.CriarTopicoPanel;
import view.panels.PerfilPanel;
import view.panels.PrincipalForumPanel;
import view.panels.VisualizarTopicoPanel;

public class PrincipalView {

	private BarraHorizontalPanel barraHorizontal;
	private BarraVerticalPanel barraVertical;
	private PerfilPanel perfilPanel;
	private PrincipalForumPanel principalForumPanel;
	private CriarTopicoPanel criarTopicoPanel;
	private VisualizarTopicoPanel visualizarTopicoPanel;

	public PrincipalView(UsuarioModel usuario) {

	}

	public view.panels.PerfilPanel getPerfilPanel() {
		return null;
	}

	public view.panels.CriarTopicoPanel getCriarTopicoPanel() {
		return null;
	}

	public view.panels.PrincipalForumPanel getPrincipalForumPanel() {
		return null;
	}

	public view.panels.VisualizarTopicoPanel getVisualizarTopicoPanel() {
		return null;
	}

	public void setBarraVerticalDados(String[] usuariosMaisAtivos, String[] tagsMaisAtivos, String[] topicosMaisCurtidos) {

	}

	public void setTopicos(TopicoModel[] topicos) {

	}

	public void abrirPerfilPanel(UsuarioModel usuario) {

	}

	public void abrirPrincipalForumPanel() {

	}

	public void abrirCriarTopicoPanel(String[] tags) {

	}

	public void abrirVisualizarTopicoPanel(PostagemModel[] posts) {

	}

	public void setBtnInicioListener(ActionListener event) {

	}

	public void setBtnCriarTopicoListener(ActionListener event) {

	}

	public void setBtnMeuPerfilListener(ActionListener event) {

	}

	public void setBtnMinhasPostagensListener(ActionListener event) {

	}

	public void setBtnSairListener(ActionListener event) {

	}

	public void setBtnNextListener(ActionListener event) {

	}

	public void setBtnPreviousListener(ActionListener event) {

	}

	public void setBtnFiltrarListener(ActionListener event) {

	}

	public void setBtnCurtirListener(ActionListener event) {

	}

	public void setBtnPostarRespostaListener(ActionListener event) {

	}

	public void setBtnVisualizarListener(ActionListener event) {

	}

	public void setBtnPostarTopicoListener(ActionListener event) {

	}

	public void setBtnVoltarCriarTopicoListener(ActionListener event) {

	}

	public void setBtnSalvarPerfilListener(ActionListener event) {

	}

	public void setFiltrarDataTopicosListener(MouseListener event) {

	}

}
