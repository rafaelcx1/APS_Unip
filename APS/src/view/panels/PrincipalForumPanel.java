package view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tables.TopicoModel;
import view.BotaoTopicoPanel;

public class PrincipalForumPanel extends JPanel {

	private PanelFiltros panelFiltros;
	private TopicoModel[] topicoModel = new TopicoModel[5];
	private PanelTopicosPrincipal[] topicosPanel = new PanelTopicosPrincipal[5];
	private JLabel lblPag;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnCriarTopico;
	private int paginaAtual;

	public void PanelPrincipalForum(String[] tags) {
		// Completar
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
		lblPag.setText(String.valueOf(paginaAtual));
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

	//Posição botao = posição do array de botoes dos tópicos
	public BotaoTopicoPanel getBtnCurtir(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnCurtir();
	}

	public BotaoTopicoPanel getBtnVisualizar(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnVisualizar();
	}

	public void setTopicos(TopicoModel[] topicos) {
		topicoModel = topicos;
		//Completar
	}

	public void curtir(int idTopico) {


	}

	public PanelTopicosPrincipal getTopicoPanel(int idTopico) {
		PanelTopicosPrincipal panelTopicosPrincipal = null;
		for(int contador = 0; contador < 5; contador++) {
			if(topicosPanel[contador].getIdTopico() == idTopico){
				panelTopicosPrincipal = topicosPanel[contador];
			}
		}
		return panelTopicosPrincipal;
	}

}
