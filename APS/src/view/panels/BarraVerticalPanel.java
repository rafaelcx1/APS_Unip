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

	public BarraVerticalPanel() {
		setLayout(new MigLayout("", "[grow]", "[30][][30][][30][][10px]"));

		Font titulo = new Font("Open Sans", Font.BOLD , 16);

		lblTituloUsuarios = new JLabel("Usuários mais ativos");
		lblTituloTags = new JLabel("Tags mais usadas");
		lblTituloTopicos = new JLabel("Tópicos mais curtidos");
		lblUsuarios = new JLabel("");
		lblTags = new JLabel("");
		lblTopicos = new JLabel("");

		lblTituloUsuarios.setFont(titulo);
		lblTituloTags.setFont(titulo);
		lblTituloTopicos.setFont(titulo);

		add(lblTituloUsuarios, "cell 0 0,alignx center,aligny center");
		add(lblUsuarios, "cell 0 1,alignx left,aligny top, grow");
		add(lblTituloTags, "cell 0 2,alignx center,aligny center");
		add(lblTags, "cell 0 3,alignx left,aligny top, grow");
		add(lblTituloTopicos, "cell 0 4,alignx center,aligny center");
		add(lblTopicos, "cell 0 5,alignx left,aligny top, grow");
	}

	public void setUsuariosMaisAtivos(String[] usuariosMaisAtivos) {
		String texto = "<html>";
		for(int contador = 0; contador < usuariosMaisAtivos.length; contador++) {
			if(usuariosMaisAtivos[contador] == null)
				texto += (contador + 1) + "- " + "" + "<br>";
			else
				texto += (contador + 1) + "- " + usuariosMaisAtivos[contador] + "<br>";
		}
		texto += "</html>";
		lblUsuarios.setText(texto);
	}

	public void setTagsMaisUsadas(String[] tagsMaisUsadas) {
		String texto = "<html>";
		for(int contador = 0; contador < tagsMaisUsadas.length; contador++) {
			if (tagsMaisUsadas[contador] == null)
				texto += (contador + 1) + "- " + "" + "<br>";
			else
				texto += (contador + 1) + "- " + tagsMaisUsadas[contador] + "<br>";
		}
		texto += "</html>";
		lblTags.setText(texto);
	}

	public void setTopicosMaisCurtidos(String[] topicosMaisCurtidos) {
		String texto = "<html>";
		for(int contador = 0; contador < topicosMaisCurtidos.length; contador++) {
			if(topicosMaisCurtidos[contador] == null)
				texto += (contador + 1) + "- " + "" + "<br>";
			else
				texto += (contador + 1) + "- " + topicosMaisCurtidos[contador] + "<br>";
		}
		texto += "</html>";
		lblTopicos.setText(texto);
	}

	public void setLblTituloUsuarios(String titulo) {

	}

	public void setLblTituloTags(String titulo) {

	}

	public void setLblTituloTopicos(String titulo) {

	}

}
