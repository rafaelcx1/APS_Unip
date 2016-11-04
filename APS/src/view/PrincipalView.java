package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

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
import view.panels.ResponderTopicoPanel;
import view.panels.VisualizarTopicoPanel;

public class PrincipalView extends JFrame implements IView{

	private BarraHorizontalPanel barraHorizontal;
	private BarraVerticalPanel barraVertical;
	private PerfilPanel perfilPanel;
	private PrincipalForumPanel principalForumPanel;
	private CriarTopicoPanel criarTopicoPanel;
	private VisualizarTopicoPanel visualizarTopicoPanel;
	private ResponderTopicoPanel responderTopicoPanel;

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
		return perfilPanel;
	}

	public CriarTopicoPanel getCriarTopicoPanel() {
		return criarTopicoPanel;
	}

	public PrincipalForumPanel getPrincipalForumPanel() {
		return principalForumPanel;
	}

	public VisualizarTopicoPanel getVisualizarTopicoPanel() {
		return visualizarTopicoPanel;
	}

	public ResponderTopicoPanel getResponderTopicoPanel() {
		return responderTopicoPanel;
	}

	public void setBarraVerticalDados(String[] usuariosMaisAtivos, String[] tagsMaisAtivas, String[] topicosMaisCurtidos) {
		barraVertical.setUsuariosMaisAtivos(usuariosMaisAtivos);
		barraVertical.setTagsMaisUsadas(tagsMaisAtivas);
		barraVertical.setTopicosMaisCurtidos(topicosMaisCurtidos);
	}

	public void setTopicos(TopicoModel[] topicos) {
		principalForumPanel.setTopicos(topicos);
	}

	public void abrirPerfilPanel(UsuarioModel usuario) {
		//Completar
	}

	public void abrirPrincipalForumPanel() {
		//Completar
	}

	public void abrirCriarTopicoPanel(String[] tags) {
		//Completar
	}

	public void abrirVisualizarTopicoPanel(PostagemModel[] posts) {
		//Completar
	}

	public void setBtnInicioListener(ActionListener event) {
		barraHorizontal.getBtnInicio().addActionListener(event);
	}

	public void setBtnMeuPerfilListener(ActionListener event) {
		barraHorizontal.getBtnPerfil().addActionListener(event);
	}

	public void setBtnMinhasPostagensListener(ActionListener event) {
		barraHorizontal.getBtnPostagens().addActionListener(event);
	}

	public void setBtnSairListener(ActionListener event) {
		barraHorizontal.getBtnSair().addActionListener(event);
	}

	public void setBtnNextListener(ActionListener event) {
		principalForumPanel.getBtnNext().addActionListener(event);
	}

	public void setBtnPreviousListener(ActionListener event) {
		principalForumPanel.getBtnPrevious().addActionListener(event);
	}

	public void setBtnFiltrarListener(ActionListener event) {
		principalForumPanel.getPanelFiltros().getBtnFiltrar().addActionListener(event);
	}
	
	public void setFiltrarDataTopicosListener(MouseListener event) {
		principalForumPanel.getPanelFiltros().getLblFiltrarData().addMouseListener(event);
	}
	
	public void setBtnCriarTopicoListener(ActionListener event) {
		principalForumPanel.getPanelFiltros().getBtnCriarTopico().addActionListener(event);
	}

	public void setBtnCurtirListener(ActionListener event) {
		for(int contador = 0; contador < 5; contador++) {
			principalForumPanel.getBtnCurtir(contador).addActionListener(event);
		}
	}

	public void setBtnVisualizarListener(ActionListener event) {
		for(int contador = 0; contador < 5; contador++) {
			principalForumPanel.getBtnCurtir(contador).addActionListener(event);
		}
	}
	
	public void setBtnResponderTopicoListener(ActionListener event) {
		for(int contador = 0; contador < 5; contador++) {
			principalForumPanel.getBtnResponderTopico(contador).addActionListener(event);
		}
	}
	
	public void setBtnPostarRespostaListener(ActionListener event) {
		responderTopicoPanel.getBtnPostarResposta().addActionListener(event);
	}

	public void setBtnPostarTopicoListener(ActionListener event) {
		criarTopicoPanel.getBtnPostarTopico().addActionListener(event);
	}

	public void setBtnSalvarPerfilListener(ActionListener event) {
		perfilPanel.getBtnSalvar().addActionListener(event);
	}

	@Override
	public void displayMsg(String msg) {
		//Completar
	}

}
