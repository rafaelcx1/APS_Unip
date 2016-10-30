package view.panels;

import java.io.File;
import javax.swing.*;
import model.tables.UsuarioModel;

public class PerfilPanel {

	private JLabel lblTitulo;
	private JLabel lblAvatar;
	private JLabel lblNome;
	private JLabel lblGenero;
	private JLabel lblDataNasc;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblPerguntaSecret;
	private JLabel lblRespostaSecret;
	private JLabel lblConfirmarSenha;
	private JLabel lblNovaSenha;
	private JFileChooser fotoChooser;
	private JTextField txnome;
	private JComboBox cbGenero;
	private JTextField dpDataNasc;
	private JComboBox cbEstado;
	private JComboBox cbCidade;
	private JComboBox cbPerguntaSecret;
	private JTextField txRespostaSecret;
	private JPasswordField txConfirmarSenha;
	private JPasswordField txNovaSenha;
	private JButton btnSalvar;
	private JButton btnEnviarFoto;
	private JButton btnVoltar;
	private UsuarioModel usuario;
	private File arquivoFoto;

	PerfilPanel(UsuarioModel usuario) {

	}

	public JButton getBtnSalvar() {
		return null;
	}

	public JButton getBtnVoltar() {
		return null;
	}

	public UsuarioModel getUsuarioModel() {
		return null;
	}

}
