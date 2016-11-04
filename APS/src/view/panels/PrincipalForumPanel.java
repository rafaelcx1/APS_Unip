package view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.models.FiltroModel;
import model.tables.TopicoModel;
import view.BotaoTopicoPanel;

public class PrincipalForumPanel {

	private PanelFiltros panelFiltros;
	private TopicoModel[] topicoModel = new TopicoModel[5];
	private PanelTopicosPrincipal[] topicosPanel;
	private JLabel lblPag;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnCriarTopico;
	private int paginaAtual;

	public void PanelPrincipalForum() {
		// Completar
	}

	public void next() {
		paginaAtual++;
	}

	public void prev() {
		if(paginaAtual > 0) {
			paginaAtual--;
		}
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

	public BotaoTopicoPanel getBtnResponderTopico(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnResponderTopico();
	}

	public BotaoTopicoPanel getBtnVisualizar(int posicaoBotao) {
		return topicosPanel[posicaoBotao].getBtnVisualizar();
	}

	public void setTopicos(TopicoModel[] topicos) {
		topicoModel = topicos;
		//Completar
	}

}
