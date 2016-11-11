package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.tables.PostagemModel;

public class VisualizarTopicoPanel extends JPanel {

	private JButton btnResponder;
	private JButton btnVoltar;
	private ResponderTopicoPanel panelResposta;
	private PanelPostagem[] posts;

	public void PainelVisualizarTopicos(PostagemModel[] posts) {

	}
	
	public int getIdTopico() {
		return posts[0].getTopico().getIdTopico();
	}

	public JButton getBtnResponder() {
		return null;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void abrirPanelResposta() {
		int idTopico = getIdTopico();
	}
}
