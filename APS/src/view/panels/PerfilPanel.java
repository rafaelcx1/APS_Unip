package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;

import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;

public class PerfilPanel extends JPanel {

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
	private JComboBox<String> cbGenero;
	private JTextField dpDataNasc;
	private JComboBox<String> cbEstado;
	private JComboBox<String> cbCidade;
	private JComboBox<String> cbPerguntaSecret;
	private JTextField txRespostaSecret;
	private JPasswordField txConfirmarSenha;
	private JPasswordField txNovaSenha;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private UsuarioModel usuario;
	private JComboBox<Integer> arquivoFoto;

	public PerfilPanel(UsuarioModel usuario) {
		setLayout(new BorderLayout());

		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		Font titulo2 = new Font("Open Sans", Font.BOLD , 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));

		lblTitulo = new JLabel("Perfil");
		lblAvatar = new JLabel();
		lblNome = new JLabel();

		add(main, "Center");
		add(footer, "South");
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public UsuarioModel getUsuarioModel() {
		return null;
	}

}
