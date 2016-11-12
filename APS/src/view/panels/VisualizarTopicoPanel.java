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

public class VisualizarTopicoPanel extends JPanel {

	private JButton btnResponder;
	private JButton btnVoltar;
	private PanelPostagem[] posts;
	private ResponderTopicoPanel panelResposta;

	public VisualizarTopicoPanel(PostagemModel[] posts) {
		setLayout(new BorderLayout());
		
		Border btnLayout = BorderFactory.createEmptyBorder(10, 16, 10, 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		
		JPanel header = new JPanel(new MigLayout());
		JPanel main = new JPanel(new MigLayout("fillx"));
	
		header.setBackground(new Color(0x212121));
		
		btnResponder = new JButton("Responder");
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnResponder.setBackground(Color.BLACK);
		btnResponder.setForeground(Color.WHITE);
		btnResponder.setBorder(defaultLayout);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(btnLayout);
		
		header.add(btnVoltar);
		header.add(btnResponder, "gapleft 85%");
		
		main.add(new PanelPostagem(null), "grow, wrap 16");
		main.add(new ResponderTopicoPanel(0), "grow, wrap 16");
		
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
	}
}
