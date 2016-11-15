package view.panels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.models.FiltroModel;

@SuppressWarnings("serial")
public class PanelFiltros extends JPanel {
	private JLabel lblTag;
	private JLabel lblUsuario;
	private JLabel lblTitulo;
	private JLabel lblFiltrarData;
	private JComboBox<String> jcTags;
	private JTextField txTitulo;
	private JTextField txUsuario;
	private JButton btnFiltrar;
	private JButton btnCriarTopico;
	private boolean dataAscendente = false;

	public PanelFiltros() {
		setLayout(new FlowLayout());
		setBackground(new Color(0x212121));

		Font word = new Font("Open Sans", Font.BOLD , 12);
		Border defaultLayout = BorderFactory.createEmptyBorder(4, 7, 4, 7);

		lblTag = new JLabel("Tag");
		lblUsuario = new JLabel("Usuário");
		lblTitulo = new JLabel("Título");
		lblFiltrarData = new JLabel("Ordenar por tópicos mais antigos");

		lblTag.setForeground(Color.WHITE);
		lblTag.setFont(word);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(word);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(word);
		lblFiltrarData.setForeground(Color.WHITE);
		lblFiltrarData.setFont(word);

		txTitulo = new JTextField(10);
		txUsuario = new JTextField(10);

		jcTags = new JComboBox<>();
		jcTags.setFont(new Font("Open Sans", Font.BOLD , 12));

		btnFiltrar = new JButton("Filtrar");
		btnCriarTopico = new JButton("Criar Tópico ", new ImageIcon("images/create.png"));

		btnFiltrar.setBackground(Color.BLACK);
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBorder(defaultLayout);
		btnFiltrar.setFocusPainted(false);
		btnCriarTopico.setBackground(Color.BLACK);
		btnCriarTopico.setForeground(Color.WHITE);
		btnCriarTopico.setBorder(defaultLayout);
		btnCriarTopico.setFocusPainted(false);

		add(lblTag);
		add(jcTags);
		add(lblUsuario);
		add(txUsuario);
		add(lblTitulo);
		add(txTitulo);
		add(btnFiltrar);
		add(lblFiltrarData);
		add(btnCriarTopico);
	}

	public void setTags(String[] tags) {
		jcTags.addItem("Todos");
		for(int contador = 0; contador < tags.length; contador++) {
			jcTags.addItem(tags[contador]);
		}
	}

    public FiltroModel getFiltroData() {
	    FiltroModel filtroData = new FiltroModel();
	    filtroData.setOrderDate(dataAscendente);
	    return filtroData;
    }

    public FiltroModel getFiltroModel() {
	    FiltroModel filtroData = new FiltroModel();
	    filtroData.setTitulo(txTitulo.getText());
	    filtroData.setUsuario(txUsuario.getText());
	    if(!((String) jcTags.getSelectedItem()).equals("Todos"))
	    	filtroData.setTag((String) jcTags.getSelectedItem());
	    return filtroData;
    }

    public JLabel getLblFiltrarData() {
	    return lblFiltrarData;
    }

    public JButton getBtnCriarTopico() {
	    return btnCriarTopico;
    }

    public JButton getBtnFiltrar() {
	    return btnFiltrar;
    }

    public void setDataAscendente(boolean dataAscendente) {
	    this.dataAscendente = dataAscendente;
	    if(dataAscendente)
	    	lblFiltrarData.setText("Ordenar por tópicos mais recentes");
	    else
	    	lblFiltrarData.setText("Ordenar por tópicos mais antigos");
    }

    public boolean getDataAscendente() {
	    return dataAscendente;
    }

    public void lblFiltrarDataEntered() {
      @SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblFiltrarData.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			lblFiltrarData.setFont(new Font(atributos));
			lblFiltrarData.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void lblFiltrarDataExited() {
      @SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblFiltrarData.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, -1);
			lblFiltrarData.setFont(new Font(atributos));
			lblFiltrarData.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}