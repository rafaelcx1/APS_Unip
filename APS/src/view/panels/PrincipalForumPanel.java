package view.panels;

import javax.swing.JButton;
import javax.swing.JLabel;

import model.models.FiltroModel;
import model.tables.TopicoModel;
import view.BotaoTopicoPanel;

public class PrincipalForumPanel {

	private PanelFiltros panelFiltros;
	private TopicoModel[] topicoModel;
	private PanelTopicosPrincipal[] topicos;
	private JLabel lblPag;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnCriarTopico;
	private int paginaAtual;

	public void PanelPrincipalForum() {

	}

	public void next() {

	}

	public void prev() {

	}

	public PanelFiltros getPanelFiltros() {
		return panelFiltros;
	}
	
	public int getPagina() {
		return 0;
	}

	public JLabel getFiltrarData() {
		return null;
	}

	public JButton getBtnCriarTopico() {
		return null;
	}

	public JButton getBtnNext() {
		return null;
	}

	public JButton getBtnPrevious() {
		return null;
	}

	public JButton getBtnFiltar() {
		return null;
	}
	
	//Posição botao = posição do array de botoes dos tópicos
	public BotaoTopicoPanel getBtnCurtir(int posicaoBotao) {
		return null;
	}

	public BotaoTopicoPanel getBtnResponderTopico(int posicaoBotao) {
		return null;
	}

	public BotaoTopicoPanel getBtnVisualizar(int posicaoBotao) {
		return null;
	}

	public FiltroModel[] getFiltro() {
		return null;
	}

	public void setTopicos(TopicoModel[] topicos) {

	}

}
