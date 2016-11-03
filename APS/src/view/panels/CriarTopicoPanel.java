package view.panels;

import javax.swing.*;
import model.tables.PostagemModel;

public class CriarTopicoPanel {

	private JLabel lblTitulo;
	private JLabel lblTituloTopico;
	private JLabel lblTags;
	private JLabel lblTextoPostagem;
	private JTextField txTitulo;
	private JTextField txTituloTopico;
	private JComboBox cbTags;
	private JTextArea taTextoPostagem;
	private JButton btnPostarTopico;
	private JButton btnVoltar;
	private String tags[];

	CriarTopicoPanel(String[] tags) {
		
	}

	public JButton getBtnPostar() {
		return null;
	}

	public JButton getBtnVoltar() {
		return null;
	}

	public PostagemModel getPostagemModel() {
		return null;
	}

	public TopicoModel getTopicoModel() {
		
	}
}
