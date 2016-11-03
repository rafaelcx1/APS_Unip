package view.panels;

public class PanelFiltros extends JPanel {
    private JLabel lblFiltrarData;
    private boolean dataAscendente = false;
	
    public FiltroModel getFiltroData() {
	    FiltroModel filtroData = new FiltroModel();
	    filtroData.setOrderDate(dataAscendente);
	    return filtroData;
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
