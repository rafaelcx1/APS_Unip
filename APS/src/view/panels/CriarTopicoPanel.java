package view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.tables.PostagemModel;
import model.tables.TopicoModel;

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

	public JButton getBtnPostarTopico() {
		return null;
	}

	public JButton getBtnVoltar() {
		return null;
	}

	public PostagemModel getPostagemModel() {
		return null;
	}

	public TopicoModel getTopicoModel() {
		return null;
	}
}
