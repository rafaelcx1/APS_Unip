package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import model.tables.PostagemModel;
import model.tables.TopicoModel;
import model.tables.UsuarioModel;
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

	public PrincipalView(UsuarioModel usuario) {

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
		barraVertical.setTagsMaisAtivas(tagsMaisAtivas);
		barraVertical.setTopicosMaisCurtidos(topicosMaisCurtidos);
	}

	public void setTopicos(TopicoModel[] topicos) {
		principalForumPanel.setTopicos(topicos);
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
		perfilPanel.getBtnSalvarPerfil().addActionListener(event);
	}

	@Override
	public void displayMsg(String msg) {
	}

}
