package view.panels;

import model.tables.UsuarioModel;
import javax.swing.*;

public class BarraHorizontalPanel {

	private JButton btnInicio;
	private JButton BtnPerfil;
	private JButton btnPostagens;
	private JButton btnSair;
	private JLabel lblUsuario;
	private JLabel lblData;

	public void PanelBarraHorizontal(UsuarioModel usuario) {

	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public JButton getBtnPerfil() {
		return BtnPerfil;
	}

	public JButton getBtnPostagens() {
		return btnPostagens;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

}
