package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

@SuppressWarnings("serial")
public class PrincipalView extends JFrame implements IView{

	private BarraHorizontalPanel barraHorizontal;
	private BarraVerticalPanel barraVertical;
	private PerfilPanel perfilPanel;
	private PrincipalForumPanel principalForumPanel;
	private CriarTopicoPanel criarTopicoPanel;
	private VisualizarTopicoPanel visualizarTopicoPanel;
	private JPanel main = new JPanel(new BorderLayout());
	private JPanel mainContent = new JPanel(new MigLayout("", "[100%]"));
	private JScrollPane mainPage;

	public PrincipalView(UsuarioModel usuario) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		barraHorizontal = new BarraHorizontalPanel(usuario);
		barraVertical = new BarraVerticalPanel();

		barraHorizontal.setBackground(new Color(0x212121));

		mainPage = new JScrollPane(null, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane sideBar = new JScrollPane(barraVertical, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		mainContent.add(mainPage, "grow, height 100%, split");
		mainContent.add(sideBar, "width 20%, height 100%");

		main.add(barraHorizontal, "North");
		main.add(mainContent, "Center");

		getContentPane().add(main);
		pack();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setVisible(true);
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

	public void abrirVisualizarTopicoPanel(PostagemModel[] postagens) {
		janelasNull();
		visualizarTopicoPanel = new VisualizarTopicoPanel();
		visualizarTopicoPanel.setPostagens(postagens);
		mainPage = new JScrollPane(visualizarTopicoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainContent.remove(mainPage);
		mainContent.add(mainPage, "grow, height 100%, split");
	}

	public void abrirCriarTopicoPanel(String[] tags) {
		janelasNull();
		criarTopicoPanel = new CriarTopicoPanel(tags);
		mainPage = new JScrollPane(criarTopicoPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainContent.remove(mainPage);
		mainContent.add(mainPage, "grow, height 100%, split");
	}

	public void abrirPrincipalForumPanel(String[] tags, TopicoModel[] topicos) {
		janelasNull();
		principalForumPanel = new PrincipalForumPanel();
		principalForumPanel.setTopicos(topicos);
		principalForumPanel.getPanelFiltros().setTags(tags);
		mainPage = new JScrollPane(principalForumPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainContent.remove(mainPage);
		mainContent.add(mainPage, "grow, height 100%, split");
	}

	public void abrirPerfilPanel(UsuarioModel usuarioConectado) {
		janelasNull();
		perfilPanel = new PerfilPanel(usuarioConectado);
		mainPage = new JScrollPane(perfilPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		mainContent.remove(mainPage);
		mainContent.add(mainPage, "grow, height 100%, split");
	}

	private void janelasNull() {
		perfilPanel = null;
		principalForumPanel = null;
		criarTopicoPanel = null;
		visualizarTopicoPanel = null;
	}

	public void setBarraVerticalDados(String[] usuariosMaisAtivos, String[] tagsMaisAtivas, String[] topicosMaisCurtidos) {
		barraVertical.setUsuariosMaisAtivos(usuariosMaisAtivos);
		barraVertical.setTagsMaisUsadas(tagsMaisAtivas);
		barraVertical.setTopicosMaisCurtidos(topicosMaisCurtidos);
	}

	public void setBtnPreviousListener(ActionListener event) {
		if(principalForumPanel != null)
			principalForumPanel.getBtnPrevious().addActionListener(event);
	}

	public void setBtnFiltrarListener(ActionListener event) {
		if(principalForumPanel != null)
			principalForumPanel.getPanelFiltros().getBtnFiltrar().addActionListener(event);
	}

	public void setFiltrarDataTopicosListener(MouseListener event) {
		if(principalForumPanel != null)
			principalForumPanel.getPanelFiltros().getLblFiltrarData().addMouseListener(event);
	}

	public void setBtnCriarTopicoListener(ActionListener event) {
		if(principalForumPanel != null)
			principalForumPanel.getPanelFiltros().getBtnCriarTopico().addActionListener(event);
	}

	public void setBtnCurtirListener(ActionListener event) {
		if(principalForumPanel != null) {
			for(int contador = 0; contador < 5; contador++) {
				if(principalForumPanel.getBtnCurtir(contador) != null)
					principalForumPanel.getBtnCurtir(contador).addActionListener(event);
			}
		}
	}

	public void setBtnVisualizarListener(ActionListener event) {
		if(principalForumPanel != null) {
			for(int contador = 0; contador < 5; contador++) {
				if(principalForumPanel.getBtnVisualizar(contador) != null)
					principalForumPanel.getBtnVisualizar(contador).addActionListener(event);
			}
		}
	}

	public void setBtnResponderTopicoListener(ActionListener event) {
		if(visualizarTopicoPanel != null) {
			visualizarTopicoPanel.getBtnResponder().addActionListener(event);
		}
	}

	public void setBtnPostarRespostaListener(ActionListener event) {
		if(visualizarTopicoPanel != null)
			visualizarTopicoPanel.getBtnPostarResposta().addActionListener(event);
	}

	public void setBtnPostarTopicoListener(ActionListener event) {
		if(criarTopicoPanel != null)
			criarTopicoPanel.getBtnPostarTopico().addActionListener(event);
	}

	public void setBtnSalvarPerfilListener(ActionListener event) {
		if(perfilPanel != null)
			perfilPanel.getBtnSalvar().addActionListener(event);
	}

	public void setBtnVoltarListener(ActionListener event) {
		if(perfilPanel != null) {
			perfilPanel.getBtnVoltar().addActionListener(event);
		}

		if(criarTopicoPanel != null) {
			criarTopicoPanel.getBtnVoltar().addActionListener(event);
		}

		if(visualizarTopicoPanel != null) {
			visualizarTopicoPanel.getBtnVoltar().addActionListener(event);
		}
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

	public void setBtnNextListener(ActionListener event) {
		if(principalForumPanel != null)
			principalForumPanel.getBtnNext().addActionListener(event);

	}

	public void setBtnSairListener(ActionListener event) {
		barraHorizontal.getBtnSair().addActionListener(event);

	}

	@Override
	public void displayMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	@Override
	public void fechar() {
		this.dispose();
	}

}