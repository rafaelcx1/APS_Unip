package view.panels;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.models.FiltroModel;

public class PanelFiltros extends JPanel {
    private JButton btnFiltrar;
    private JButton btnCriarTopico;
    private JLabel lblFiltrarData;
    private boolean dataAscendente = false;

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
