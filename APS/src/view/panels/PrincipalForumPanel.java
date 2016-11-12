package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.tables.TopicoModel;
import net.miginfocom.swing.MigLayout;
import view.BotaoTopicoPanel;

public class PrincipalForumPanel extends JPanel {

	private PanelFiltros panelFiltros;
	private TopicoModel[] topicoModel = new TopicoModel[5];
	private PanelTopicosPrincipal[] topicosPanel = new PanelTopicosPrincipal[5];
	private JButton btnPag;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnCriarTopico;
	private int paginaAtual;

	public PrincipalForumPanel() {
		setLayout(new BorderLayout());
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		panelFiltros = new PanelFiltros(new String[]{"hey", "hey"});

		panelFiltros.setBackground(new Color(0x212121));

		JPanel header = new JPanel(new MigLayout("fillx"));
		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout());

		header.setBackground(new Color(0x212121));

		btnNext = new JButton("", new ImageIcon("next.png"));
		btnPrevious = new JButton("", new ImageIcon("prev.png"));
		btnCriarTopico = new JButton("", new ImageIcon("create.png"));
		btnPag = new JButton("1");

		btnNext.setBorder(defaultLayout);
		btnNext.setBackground(Color.BLACK);
		btnPrevious.setBorder(defaultLayout);
		btnPrevious.setBackground(Color.BLACK);
		btnCriarTopico.setBorder(defaultLayout);
		btnCriarTopico.setBackground(Color.BLACK);
		btnPag.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
		btnPag.setBackground(Color.BLACK);
		btnPag.setForeground(Color.WHITE);
		
		btnPag.setEnabled(false);

		header.add(panelFiltros);

		footer.add(btnPrevious);
		footer.add(btnPag);
		footer.add(btnNext);
		footer.add(btnCriarTopico);

		main.add(new PanelTopicosPrincipal(), "wrap 16, grow");
		main.add(new PanelTopicosPrincipal(), "wrap 16, grow");
		main.add(new PanelTopicosPrincipal(), "wrap 16, grow");
		main.add(new PanelTopicosPrincipal(), "wrap 16, grow");
		main.add(new PanelTopicosPrincipal(), "wrap 16, grow");
		main.add(footer);

		add(header, "North");
		add(main, "Center");
	}

	public void next() {
		setPaginaAtual(paginaAtual++);
	}

	public void prev() {
		if(paginaAtual > 0) {
			setPaginaAtual(paginaAtual--);
		}
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
		btnPag.setText(String.valueOf(paginaAtual));
	}

	public PanelFiltros getPanelFiltros() {
		return panelFiltros;
	}

	public int getPagina() {
		return paginaAtual;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnPrevious() {
		return btnPrevious;
	}

	// Posição botao = posição do array de botoes dos tópicos
	public BotaoTopicoPanel getBtnCurtir(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnCurtir();
	}

	public BotaoTopicoPanel getBtnVisualizar(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnVisualizar();
	}

	public void setTopicos(TopicoModel[] topicos) {
		topicoModel = topicos;
		// Completar
	}

	public void curtir(int idTopico) {

	}

	public PanelTopicosPrincipal getTopicoPanel(int idTopico) {
		PanelTopicosPrincipal panelTopicosPrincipal = null;
		for (int contador = 0; contador < 5; contador++) {
			if (topicosPanel[contador].getIdTopico() == idTopico) {
				panelTopicosPrincipal = topicosPanel[contador];
			}
		}
		return panelTopicosPrincipal;
	}

}
