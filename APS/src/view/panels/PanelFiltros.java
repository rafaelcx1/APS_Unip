package view.panels;

import java.awt.Color;
import java.awt.Cursor;
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
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelFiltros extends JPanel {
	private JLabel lblTag;
	private JLabel lblData;
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
		setLayout(new MigLayout());

		Font word = new Font("Open Sans", Font.BOLD , 14);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		lblTag = new JLabel("Tag");
		lblData = new JLabel("Data");
		lblUsuario = new JLabel("Usu�rio");
		lblTitulo = new JLabel("T�tulo");
		lblFiltrarData = new JLabel("Recentes");

		lblTag.setForeground(Color.WHITE);
		lblTag.setFont(word);
		lblData.setForeground(Color.WHITE);
		lblData.setFont(word);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(word);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(word);
		lblFiltrarData.setForeground(Color.WHITE);
		lblFiltrarData.setFont(word);

		txTitulo = new JTextField(16);
		txUsuario = new JTextField(16);

		jcTags = new JComboBox<>();

		btnFiltrar = new JButton("Filtrar");
		btnCriarTopico = new JButton("", new ImageIcon("images/create.png"));

		btnFiltrar.setBackground(Color.BLACK);
		btnFiltrar.setForeground(Color.WHITE);
		btnFiltrar.setBorder(defaultLayout);
		btnCriarTopico.setBackground(Color.BLACK);
		btnCriarTopico.setForeground(Color.WHITE);
		btnCriarTopico.setBorder(defaultLayout);

		add(lblTag);
		add(jcTags);
		add(lblData, "gapleft 16px");
		add(lblFiltrarData);
		add(lblUsuario, "gapleft 16px");
		add(txUsuario);
		add(lblTitulo, "gapleft 16px");
		add(txTitulo);
		add(btnFiltrar, "gapleft 16px");
		add(btnCriarTopico, "gapleft 32px");
	}


	public void setTags(String[] tags) {
		for(int contador = 0; contador < tags.length; contador++) {
			jcTags.addItem(tags[contador]);
		}
	}

    public FiltroModel getFiltroData() {
	    FiltroModel filtroData = new FiltroModel();
	    filtroData.setOrderDate(dataAscendente);
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
