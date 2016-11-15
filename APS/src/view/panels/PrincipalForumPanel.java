package view.panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.tables.TopicoModel;
import net.miginfocom.swing.MigLayout;
import view.BotaoTopicoPanel;

@SuppressWarnings("serial")
public class PrincipalForumPanel extends JPanel {

	private JPanel main;
	private PanelFiltros panelFiltros;
	private PanelTopicosPrincipal[] topicosPanel = new PanelTopicosPrincipal[5];
	private JButton btnPag;
	private JButton btnNext;
	private JButton btnPrevious;
	private int paginaAtual;

	public PrincipalForumPanel() {
		setLayout(new MigLayout("", "[grow]", "[::120][::70,grow][][][][][]"));
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		panelFiltros = new PanelFiltros();

		//JPanel header = new JPanel(new MigLayout("fillx"));
		main = new JPanel();
		//JPanel footer = new JPanel(new MigLayout());

		//header.setBackground(new Color(0x212121));

		btnNext = new JButton("", new ImageIcon("images/next.png"));
		btnPrevious = new JButton("", new ImageIcon("images/prev.png"));
		btnPag = new JButton("1");
		paginaAtual = 0;

		btnNext.setBorder(defaultLayout);
		btnNext.setBackground(Color.BLACK);
		btnNext.setFocusPainted(false);
		btnPrevious.setBorder(defaultLayout);
		btnPrevious.setBackground(Color.BLACK);
		btnPrevious.setFocusPainted(false);
		btnPag.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
		btnPag.setBackground(Color.BLACK);
		btnPag.setForeground(Color.WHITE);

		btnPag.setEnabled(false);

		main.add(btnPrevious);
		main.add(btnPag);
		main.add(btnNext);

		add(panelFiltros, "cell 0 0, grow");
		add(main, "cell 0 1,growx,aligny top");

		//header.add(panelFiltros);

		//footer.add(btnPrevious);
		//footer.add(btnPag);
		//footer.add(btnNext);

		//main.add(footer);

		//add(header, "North");
		//add(main, "Center");
	}

	private void atualizarPagina() {
		btnPag.setText(String.valueOf(paginaAtual + 1));
	}

	public void next() {
		setPaginaAtual(paginaAtual + 1);
		atualizarPagina();
	}

	public void prev() {
		if(paginaAtual > 0) {
			setPaginaAtual(paginaAtual - 1);
		}
		atualizarPagina();
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
		atualizarPagina();
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

	public BotaoTopicoPanel getBtnCurtir(int posicaoBotao) {
		if(topicosPanel[posicaoBotao] != null) {
			return topicosPanel[posicaoBotao].getBtnCurtir();
		} else {
			return null;
		}
	}

	public BotaoTopicoPanel getBtnVisualizar(int posicaoBotao) {
		if(topicosPanel[posicaoBotao] != null) {
			return topicosPanel[posicaoBotao].getBtnVisualizar();
		} else {
			return null;
		}
	}

	public void setTopicos(TopicoModel[] topicos) {
		removerTopicos();
		if(topicos != null) {
			for(int contador = 0; contador < topicos.length; contador++) {
				if(topicos[contador] != null){
					topicosPanel[contador] = new PanelTopicosPrincipal(topicos[contador]);
					String miglayout =  "cell 0 " + (contador + 2) + ", grow";
					add(topicosPanel[contador], miglayout);
					topicosPanel[contador].atualizarLayout();
				}
			}
		}
	}

	private void removerTopicos() {
		for(int contador = 0; contador < 5; contador++){
			if(topicosPanel[contador] != null)
				remove(topicosPanel[contador]);
		}
		revalidate();
		repaint();
	}

	public PanelTopicosPrincipal getTopicoPanel(int idTopico) {
		PanelTopicosPrincipal panelTopicosPrincipal = null;
		for (int contador = 0; contador < 5; contador++) {
			PanelTopicosPrincipal topicoPanel = topicosPanel[contador];
			if (topicoPanel != null) {
				if(topicosPanel[contador].getIdTopico() == idTopico)
					panelTopicosPrincipal = topicosPanel[contador];
			}
		}
		return panelTopicosPrincipal;
	}

}
