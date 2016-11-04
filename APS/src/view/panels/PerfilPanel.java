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
	private UsuarioModel usuario;
	private File arquivoFoto;

	public PerfilPanel(UsuarioModel usuario) {
		setLayout(new BorderLayout());
		
		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		Font titulo2 = new Font("Open Sans", Font.BOLD , 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		
		JPanel panelHeader = new JPanel(new MigLayout());
		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));
		
		panelHeader.setBackground(new Color(0x212121));
		
		lblTitulo = new JLabel("Perfil");
		lblAvatar = new JLabel();
		lblNome = new JLabel();
		
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(defaultLayout);
		
		panelHeader.add(btnVoltar);
		
		add(panelHeader, "North");
		add(main, "Center");
		add(footer, "South");
	}

	public JButton getBtnSalvar() {
		return null;
	}

	public UsuarioModel getUsuarioModel() {
		return null;
	}

}
