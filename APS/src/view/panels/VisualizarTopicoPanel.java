package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.tables.PostagemModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class VisualizarTopicoPanel extends JPanel {

	private JButton btnResponder;
	private JButton btnVoltar;
	private PanelPostagem[] posts;
	private ResponderTopicoPanel panelResposta;
	private JPanel main;

	public VisualizarTopicoPanel() {
		setLayout(new BorderLayout());

		Border btnLayout = BorderFactory.createEmptyBorder(10, 16, 10, 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		JPanel header = new JPanel(new MigLayout());
		main = new JPanel(new MigLayout("fillx"));

		header.setBackground(new Color(0x212121));

		btnResponder = new JButton("Responder");
		btnVoltar = new JButton("", new ImageIcon("images/back.png"));

		btnResponder.setBackground(Color.BLACK);
		btnResponder.setForeground(Color.WHITE);
		btnResponder.setBorder(defaultLayout);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(btnLayout);

		header.add(btnVoltar);
		header.add(btnResponder, "gapleft 85%");

		add(header, "North");
		add(main, "Center");
	}

	public int getIdTopico() {
		return posts[0].getPostagem().getTopico().getIdTopico();
	}

	public JButton getBtnResponder() {
		return null;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void abrirPanelResposta() {
		int idTopico = getIdTopico();
		panelResposta = new ResponderTopicoPanel(idTopico);
		main.add(panelResposta, "grow, wrap 16");
	}

	public JButton getBtnPostarResposta() {
		if(panelResposta != null) {
			return panelResposta.getBtnPostarResposta();
		} else {
			return null;
		}
	}

	public ResponderTopicoPanel getResponderTopicoPanel() {
		return panelResposta;
	}

	public void setPostagens(PostagemModel[] postagens) {
		for(int contador = 0; contador < postagens.length; contador++) {
			posts[contador] = new PanelPostagem(postagens[contador]);
			main.add(posts[contador], "grow, wrap 16");
		}
	}
}
