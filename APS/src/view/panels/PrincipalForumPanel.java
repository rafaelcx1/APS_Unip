package view.panels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import javax.swing.border.Border;
=======
>>>>>>> b6b6b1c3ec601421db5e4140bac8391999995a28

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

<<<<<<< HEAD
	public PrincipalForumPanel() {
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		
		btnNext = new JButton("", new ImageIcon("next.png"));
		btnPrevious = new JButton("", new ImageIcon("prev.png"));
		btnCriarTopico = new JButton("", new ImageIcon("create.png"));
		
		btnNext.setBorder(defaultLayout);
		btnNext.setBackground(Color.BLACK);
		btnPrevious.setBorder(defaultLayout);
		btnPrevious.setBackground(Color.BLACK);
		btnCriarTopico.setBorder(defaultLayout);
		btnCriarTopico.setBackground(Color.BLACK);
		
		add(btnPrevious);
		add(btnNext);
		add(btnCriarTopico);
=======
	public void PanelPrincipalForum(String[] tags) {
		// Completar
>>>>>>> b6b6b1c3ec601421db5e4140bac8391999995a28
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
		return topicosPanel[posicaoBotao].getBtnResponder();
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
