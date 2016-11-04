package view.panels;

import javax.swing.*;

public class BarraVerticalPanel {

	private JLabel lblTitulosUsuarios;
	private JLabel lblTituloTags;
	private JLabel lblTitulosTopicos;
	private JLabel[] lblUsuarios;
	private JLabel[] lblTags;
	private JLabel[] lblTopicos;
	private String[] usuariosMaisAtivos;
	private String[] tagsMaisUsadas;
	private String[] topicosMaisCurtidos;

	public BarraVerticalPanel() {

	}

	public void setUsuariosMaisAtivos(String[] usuariosMaisAtivos) {
		this.usuariosMaisAtivos = usuariosMaisAtivos;
	}

	public void setTagsMaisUsadas(String[] tagsMaisUsadas) {
		this.tagsMaisUsadas = tagsMaisUsadas;
	}

	public void setTopicosMaisCurtidos(String[] topicosMaisCurtidas) {
		this.topicosMaisCurtidas = topicosMaisCurtidas;
	}

	public void setLblTituloUsuarios(String titulo) {

	}

	public void setLblTituloTags(String titulo) {

	}

	public void setLblTituloTopicos(String titulo) {

	}

}
