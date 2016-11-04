package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

import model.tables.PostagemModel;
import net.miginfocom.swing.MigLayout;

public class CriarTopicoPanel extends JPanel {

	private JLabel lblTitulo;
	private JLabel lblTituloTopico;
	private JLabel lblTags;
	private JLabel lblTextoPostagem;
	private JTextField txTitulo;
	private JTextField txTituloTopico;
	private JComboBox cbTags;
	private JTextArea taTextoPostagem;
	private JButton btnPostar;
	private JButton btnVoltar;
	private String tags[];

	CriarTopicoPanel(String[] tags) {
		setLayout(new BorderLayout());
		
		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		Font titulo2 = new Font("Open Sans", Font.BOLD , 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		
		JPanel panelHeader = new JPanel(new MigLayout());
		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));
		
		panelHeader.setBackground(new Color(0x212121));
		
		lblTitulo = new JLabel("Criar tópico");
		lblTituloTopico = new JLabel("Titulo");
		lblTags = new JLabel("Tags");
		lblTextoPostagem = new JLabel("Texto");
		
		lblTitulo.setFont(titulo1);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		lblTituloTopico.setFont(titulo2);
		lblTags.setFont(titulo2);
		lblTextoPostagem.setFont(titulo2);
		
		txTitulo = new JTextField(48);
		txTituloTopico = new JTextField(48);
		
		cbTags = new JComboBox();
		
		taTextoPostagem = new JTextArea();
		
		btnPostar = new JButton("Criar");
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnPostar.setBorder(defaultLayout);
		btnPostar.setBackground(Color.BLACK);
		btnPostar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(defaultLayout);
		
		panelHeader.add(btnVoltar);
		
		main.add(lblTitulo, "wrap 16");
		main.add(lblTituloTopico, "wrap 8");
		main.add(lblTags, "wrap 8");
		main.add(lblTextoPostagem, "wrap 8");
		
		footer.add(btnPostar);
		
		add(panelHeader, "North");
		add(main, "Center");
		add(footer, "South");
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

}
