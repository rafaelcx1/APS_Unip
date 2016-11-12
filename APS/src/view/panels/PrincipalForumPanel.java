package view.panels;

import java.awt.BorderLayout;
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
	private JButton btnCriarTopico;
	private int paginaAtual;

	public PrincipalForumPanel() {
		setLayout(new BorderLayout());
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		panelFiltros = new PanelFiltros();

		panelFiltros.setBackground(new Color(0x212121));

		JPanel header = new JPanel(new MigLayout("fillx"));
		main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout());

		header.setBackground(new Color(0x212121));

		btnNext = new JButton("", new ImageIcon("images/next.png"));
		btnPrevious = new JButton("", new ImageIcon("images/prev.png"));
		btnCriarTopico = new JButton("", new ImageIcon("images/create.png"));
		btnPag = new JButton("1");
		paginaAtual = 0;

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

		main.add(footer);

		add(header, "North");
		add(main, "Center");
	}

	private void atualizarPagina() {
		btnPag.setText(String.valueOf(paginaAtual));
	}

	public void next() {
		setPaginaAtual(paginaAtual++);
		atualizarPagina();
	}

	public void prev() {
		if(paginaAtual > 0) {
			setPaginaAtual(paginaAtual--);
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
		if(topicos != null) {
			for(int contador = 0; contador < topicos.length; contador++) {
				if(topicos[contador] != null & topicosPanel[contador] != null){
					topicosPanel[contador] = new PanelTopicosPrincipal(topicos[contador]);
					main.add(topicosPanel[contador], "wrap 16, grow");
				} else {
					break;
				}
			}
		}
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
