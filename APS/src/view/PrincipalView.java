package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;
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

	PrincipalView(UsuarioModel usuario) {
		JPanel main = new JPanel(new BorderLayout());
		JPanel mainContent = new JPanel(new MigLayout("", "[100%]"));
		barraHorizontal = new BarraHorizontalPanel(usuario);
		barraVertical = new BarraVerticalPanel();
		perfilPanel = new PerfilPanel(usuario);
		
		barraHorizontal.setBackground(new Color(0x212121));
		
		JScrollPane mainPage = new JScrollPane(perfilPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane sideBar = new JScrollPane(barraVertical, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		mainContent.add(mainPage, "grow, height 100%, split");
		mainContent.add(sideBar, "width 20%, height 100%");
		
		main.add(barraHorizontal, "North");
		main.add(mainContent, "Center");
		
		getContentPane().add(main);
		pack();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public PerfilPanel getPerfilPanel() {
		return null;
	}

	public CriarTopicoPanel getCriarTopicoPanel() {
		return null;
	}

	public PrincipalForumPanel getPrincipalForumPanel() {
		return null;
	}

	public VisualizarTopicoPanel getVisualizarTopicoPanel() {
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

	public void setBtnResponderListener(ActionListener event) {

	}

	public void setBtnVisualizarListener(ActionListener event) {

	}

	public void setBtnPostarListener(ActionListener event) {

	}

	public void setBtnVoltarCriarTopicoListener(ActionListener event) {

	}

	public void setBtnSalvarPerfilListener(ActionListener event) {

	}

	public void setFiltrarDataTopicosListener(MouseListener event) {

	}

}
