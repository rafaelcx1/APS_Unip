package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.tables.PostagemModel;
import model.tables.TopicoModel;
import net.miginfocom.swing.MigLayout;
import util.DataUtil;

public class CriarTopicoPanel extends JPanel{

	private JLabel lblTitulo;
	private JLabel lblTag;
	private JLabel lblTextoPostagem;
	private JTextField txTitulo;
	private JComboBox<String> cbTag;
	private JTextArea taTextoPostagem;
	private JButton btnPostarTopico;
	private JButton btnVoltar;
	private String tags[];

	public CriarTopicoPanel(String[] tags) {
		setLayout(new BorderLayout());
		
		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		Font titulo2 = new Font("Open Sans", Font.BOLD , 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		
		JPanel panelHeader = new JPanel(new MigLayout());
		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));
		
		panelHeader.setBackground(new Color(0x212121));
		
		lblTitulo = new JLabel("Criar tópico");
		lblTag = new JLabel("Tags");
		lblTextoPostagem = new JLabel("Texto");
		
		lblTitulo.setFont(titulo1);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		lblTitulo.setFont(titulo2);
		lblTag.setFont(titulo2);
		lblTextoPostagem.setFont(titulo2);
		
		txTitulo = new JTextField(48);
		
		cbTag = new JComboBox();
		
		taTextoPostagem = new JTextArea();
		
		btnPostarTopico = new JButton("Criar");
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnPostarTopico.setBorder(defaultLayout);
		btnPostarTopico.setBackground(Color.BLACK);
		btnPostarTopico.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(defaultLayout);
		
		panelHeader.add(btnVoltar);
		
		main.add(lblTitulo, "wrap 16");
		main.add(lblTag, "wrap 8");
		main.add(lblTextoPostagem, "wrap 8");
		
		footer.add(btnPostarTopico);
		
		add(panelHeader, "North");
		add(main, "Center");
		add(footer, "South");
	}

	public JButton getBtnPostarTopico() {
		return btnPostarTopico;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public PostagemModel getPostagemModel() {
		PostagemModel postagem = new PostagemModel();
		postagem.setTopico(getTopicoModel());
		postagem.setTextoPost(taTextoPostagem.getText());
		postagem.setDataPost(DataUtil.format(LocalDate.now()));
		return postagem;
	}

	private TopicoModel getTopicoModel() {
		TopicoModel topico = new TopicoModel();
		topico.setTitulo(txTitulo.getText());
		topico.setTag((String) cbTag.getSelectedItem());
		topico.setDtCriacao(DataUtil.format(LocalDate.now()));
		return topico;
	}
}
