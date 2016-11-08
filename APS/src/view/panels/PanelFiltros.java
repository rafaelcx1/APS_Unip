package view.panels;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.models.FiltroModel;

public class PanelFiltros extends JPanel {
	private JLabel lblTag;
	private JLabel lblData;
	private JLabel lblUsuario;
	private JLabel lblTitulo;
	private JLabel lblFiltrarData;
	private JComboBox<Integer> jcDia;
	private JComboBox<Integer> jcMes;
	private JComboBox<Integer> jcAno;
	private JComboBox<String> jcTags;
	private JTextField txTitulo;
	private JTextField txUsuario;
	private JButton btnFiltrar;
	private JButton btnCriarTopico;
	private String[] tags;
	private boolean dataAscendente = false;

	public PanelFiltros(String[] tags) {
		this.tags = tags;
		// Completar
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
