package view;

import java.awt.Dimension;
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

	private JPanel contentPane;
	private JPanel mainContent;
	private JScrollPane mainPage;


	public PrincipalView(UsuarioModel usuario) {
		/*this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		barraHorizontal = new BarraHorizontalPanel(usuario);
		barraVertical = new BarraVerticalPanel();

		mainPage = new JScrollPane();
		JScrollPane sideBar = new JScrollPane(barraVertical, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		mainContent.add(mainPage, "grow, height 100%, split");
		mainContent.add(sideBar, "width 20%, height 100%");

		main.add(barraHorizontal, "North");
		main.add(mainContent, "Center");

		getContentPane().add(main);
		setResizable(false);
		*/
		super("JSolve - Fórum | Bem-Vindo!");
		barraHorizontal = new BarraHorizontalPanel(usuario);
		barraVertical = new BarraVerticalPanel();
		mainPage = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane sideBar = new JScrollPane(barraVertical, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1024, 768));
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(null);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));

		mainContent = new JPanel();
		contentPane.add(mainContent, "cell 0 0,grow");
		mainContent.setLayout(new MigLayout("", "[grow][::400,grow]", "[::150,grow][grow,bottom]"));

		mainContent.add(barraHorizontal, "cell 0 0 2 1,grow");
		mainContent.add(sideBar, "cell 1 1, grow");
		mainContent.add(mainPage, "cell 0 1, grow");
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
		mainPage.setViewportView(visualizarTopicoPanel);
	}

	public void abrirCriarTopicoPanel(String[] tags) {
		janelasNull();
		criarTopicoPanel = new CriarTopicoPanel(tags);
		mainPage.setViewportView(criarTopicoPanel);
	}

	public void abrirPrincipalForumPanel(String[] tags, TopicoModel[] topicos) {
		janelasNull();
		principalForumPanel = new PrincipalForumPanel();
		principalForumPanel.setTopicos(topicos);
		principalForumPanel.getPanelFiltros().setTags(tags);
		mainPage.setViewportView(principalForumPanel);
	}

	public void abrirPerfilPanel(UsuarioModel usuarioConectado) {
		janelasNull();
		perfilPanel = new PerfilPanel(usuarioConectado);
		mainPage.setViewportView(perfilPanel);
	}

	private void janelasNull() {
		perfilPanel = null;
		principalForumPanel = null;
		criarTopicoPanel = null;
		visualizarTopicoPanel = null;
	}

	public void atualizar(UsuarioModel usuario, String[] usuariosMaisAtivos, String[] tagsMaisAtivas, String[] topicosMaisCurtidos) {
		barraHorizontal.atualizarDadosUsuario(usuario);
		setBarraVerticalDados(usuariosMaisAtivos, tagsMaisAtivas, topicosMaisCurtidos);
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