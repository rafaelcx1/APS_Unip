package view.panels;

import java.awt.Font;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class BarraVerticalPanel extends JPanel {

	private JLabel lblTituloUsuarios;
	private JLabel lblTituloTags;
	private JLabel lblTituloTopicos;
	private JLabel lblUsuarios;
	private JLabel lblTags;
	private JLabel lblTopicos;
	private String[] usuariosMaisAtivos;
	private String[] tagsMaisUsadas;
	private String[] topicosMaisCurtidos;

	public BarraVerticalPanel() {
		JPanel main = new JPanel(new MigLayout("", "[100%]"));

		Font titulo = new Font("Open Sans", Font.BOLD , 16);

		lblTituloUsuarios = new JLabel("Usuários mais ativos");
		lblTituloTags = new JLabel("Tags mais usadas");
		lblTituloTopicos = new JLabel("Tópicos mais curtidos");

		String texto = null;
		for(int contador = 0; contador < usuariosMaisAtivos.length; contador++) {
			texto = usuariosMaisAtivos[contador] + "\n";
		}
		lblUsuarios.setText(texto);

		for(int contador = 0; contador < tagsMaisUsadas.length; contador++) {
			texto = tagsMaisUsadas[contador] + "\n";
		}
		lblTags.setText(texto);

		for(int contador = 0; contador < topicosMaisCurtidos.length; contador++) {
			texto = topicosMaisCurtidos[contador] + "\n";
		}
		lblTopicos.setText(texto);

		lblTituloUsuarios.setFont(titulo);
		lblTituloTags.setFont(titulo);
		lblTituloTopicos.setFont(titulo);

		main.add(lblTituloUsuarios, "wrap 10, center");
		main.add(lblUsuarios, "wrap 8, center");
		main.add(lblTituloTags, "wrap 10, center");
		main.add(lblTags, "wrap 8, center");
		main.add(lblTituloTopicos, "wrap 10, center");
		main.add(lblTopicos, "wrap 8, center");

		add(main);
	}

	public void setUsuariosMaisAtivos(String[] usuariosMaisAtivos) {
		this.usuariosMaisAtivos = usuariosMaisAtivos;
	}

	public void setTagsMaisUsadas(String[] tagsMaisUsadas) {
		this.tagsMaisUsadas = tagsMaisUsadas;
	}

	public void setTopicosMaisCurtidos(String[] topicosMaisCurtidas) {
		this.topicosMaisCurtidos = topicosMaisCurtidas;
	}

	public void setLblTituloUsuarios(String titulo) {

	}

	public void setLblTituloTags(String titulo) {

	}

	public void setLblTituloTopicos(String titulo) {

	}

}
