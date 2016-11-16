package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PerfilPanel extends JPanel implements ItemListener{

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
	private JTextField txNome;
	private JComboBox<String> cbFoto;
	private JComboBox<String> cbGenero;
	private JComboBox<String> cbDiaNasc;
	private JComboBox<String> cbMesNasc;
	private JComboBox<String> cbAnoNasc;
	private JComboBox<String> cbEstado;
	private JTextField txCidade;
	private JComboBox<String> cbPerguntaSecret;
	private JTextField txRespostaSecret;
	private JPasswordField txConfirmarSenha;
	private JPasswordField txNovaSenha;
	private JButton btnSalvar;
	private JButton btnVoltar;
	private UsuarioModel usuario;

	public PerfilPanel(UsuarioModel usuario) {
		this.usuario = usuario;
		setLayout(new BorderLayout());

		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		Font word = new Font("Open Sans", Font.BOLD , 14);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel fieldset = new JPanel(new MigLayout());
		JPanel profile = new JPanel(new MigLayout("", "[center]"));

		Icon avatar = new ImageIcon();
		switch (usuario.getAvatar()) {
			case 0: {
				avatar = new ImageIcon("avatar/default.png");
				break;
			}
			case 1: {
				avatar = new ImageIcon("avatar/avatar1.png");
				break;
			}
			case 2: {
				avatar = new ImageIcon("avatar/avatar2.png");
				break;
			}
			case 3: {
				avatar = new ImageIcon("avatar/avatar3.png");
				break;
			}
			case 4: {
				avatar = new ImageIcon("avatar/avatar4.png");
				break;
			}
			case 5: {
				avatar = new ImageIcon("avatar/avatar5.png");
				break;
			}
			case 6: {
				avatar = new ImageIcon("avatar/avatar6.png");
				break;
			}

			case 7: {
				avatar = new ImageIcon("avatar/avatar7.png");
				break;
			}

			case 8: {
				avatar = new ImageIcon("avatar/avatar8.png");
				break;
			}

			case 9: {
				avatar = new ImageIcon("avatar/avatar9.png");
				break;
			}

			case 10: {
				avatar = new ImageIcon("avatar/avatar10.png");
				break;
			}

			case 11: {
				avatar = new ImageIcon("avatar/avatar11.png");
				break;
			}

			case 12: {
				avatar = new ImageIcon("avatar/avatar12.png");
				break;
			}

			case 13: {
				avatar = new ImageIcon("avatar/avatar13.png");
				break;
			}

			case 14: {
				avatar = new ImageIcon("avatar/avatar14.png");
				break;
			}

			case 15: {
				avatar = new ImageIcon("avatar/avatar15.png");
				break;
			}

			case 16: {
				avatar = new ImageIcon("avatar/avatar16.png");
				break;
			}

			case 17: {
				avatar = new ImageIcon("avatar/mago.png");
				break;
			}

			case 18: {
				avatar = new ImageIcon("avatar/ninja.png");
				break;
			}

			case 19: {
				avatar = new ImageIcon("avatar/pirata.png");
				break;
			}

			case 20: {
				avatar = new ImageIcon("avatar/preguica.png");
				break;
			}

			case 21: {
				avatar = new ImageIcon("avatar/rainha.png");
				break;
			}

			case 22: {
				avatar = new ImageIcon("avatar/robo.png");
				break;
			}

			case 23: {
				avatar = new ImageIcon("avatar/urso.png");
				break;
			}

			case 24: {
				avatar = new ImageIcon("avatar/zumbi.png");
				break;
			}

		}


		lblTitulo = new JLabel("Perfil");
		lblAvatar = new JLabel(avatar);
		lblNome = new JLabel("Nome");
		lblGenero = new JLabel("Gênero");
		lblDataNasc = new JLabel("Data de nascimento");
		lblEstado = new JLabel("Estado");
		lblCidade = new JLabel("Cidade");
		lblPerguntaSecret = new JLabel("Pergunta secreta");
		lblRespostaSecret = new JLabel("Resposta secreta");
		lblConfirmarSenha = new JLabel("Confirmar senha");
		lblNovaSenha = new JLabel("Nova senha");

		lblTitulo.setFont(titulo1);
		lblNome.setFont(word);
		lblGenero.setFont(word);
		lblDataNasc.setFont(word);
		lblEstado.setFont(word);
		lblCidade.setFont(word);
		lblPerguntaSecret.setFont(word);
		lblRespostaSecret.setFont(word);
		lblConfirmarSenha.setFont(word);
		lblNovaSenha.setFont(word);

		txNome = new JTextField(48);
		txCidade = new JTextField(48);
		txRespostaSecret = new JTextField(48);

		txNome.setFont(word);
		txCidade.setFont(word);
		txRespostaSecret.setFont(word);

		txConfirmarSenha = new JPasswordField(48);
		txNovaSenha = new JPasswordField(48);

		String[] perguntas  = {"Qual o nome do primeiro cachorro?", "Qual o nome do primeiro(a) professor(a)?", "Em qual cidade você nasceu?", "Qual sua comida favorita?", "Qual cidade você mais gostou?", "Para onde foi sua primeira viagem?"};
		String[] fotos = {"Avatar Padrão", "Avatar 1", "Avatar 2", "Avatar 3", "Avatar 4", "Avatar 5", "Avatar 6", "Avatar 7", "Avatar 8", "Avatar 9", "Avatar 10", "Avatar 11", "Avatar 12", "Avatar 13", "Avatar 14", "Avatar 15", "Avatar 16", "Mago", "Ninja", "Pirata", "Preguiça", "Rainha", "Robô", "Urso", "Zumbi"};
		String[] generos = {"Masculino", "Feminino"};
		String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB" , "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		String[] dias = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] meses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String[] anos = new String[117];

		for(int i = 1900, a = 0; i < 2017; i = i + 1, a = a + 1){
			anos[a] = String.valueOf(i);
		}

		cbFoto = new JComboBox<String>(fotos);
		cbGenero = new JComboBox<String>(generos);
		cbDiaNasc = new JComboBox<String>(dias);
		cbMesNasc = new JComboBox<String>(meses);
		cbAnoNasc = new JComboBox<String>(anos);
		cbEstado = new JComboBox<String>(estados);
		cbPerguntaSecret = new JComboBox<String>(perguntas);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setFocusPainted(false);
		btnVoltar = new JButton("", new ImageIcon("images/back.png"));
		btnVoltar.setFocusPainted(false);

		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBorder(defaultLayout);

		txCidade.setText(usuario.getCidade());
		txNome.setText(usuario.getNome());
		txRespostaSecret.setText(usuario.getRespostaSecret());

		String[] dataNasc = usuario.getDataNasc().split("/");
		cbAnoNasc.setSelectedItem(dataNasc[2]);
		cbMesNasc.setSelectedItem(dataNasc[1]);
		cbDiaNasc.setSelectedItem(dataNasc[0]);

		cbEstado.setSelectedItem(usuario.getEstado());
		cbGenero.setSelectedItem(usuario.getGenero());
		cbPerguntaSecret.setSelectedItem(usuario.getPerguntaSecret());
		cbFoto.setSelectedIndex(usuario.getAvatar());

		cbFoto.addItemListener(this);

		profile.add(lblAvatar, "wrap 16");
		profile.add(cbFoto);

		fieldset.add(lblNome);
		fieldset.add(txNome, "wrap 16, gapleft 16, grow");
		fieldset.add(lblGenero);
		fieldset.add(cbGenero, "wrap 16, gapleft 16, grow");
		fieldset.add(lblDataNasc);
		fieldset.add(cbDiaNasc, "split, gapleft 16, width 25%");
		fieldset.add(cbMesNasc, "width 26%");
		fieldset.add(cbAnoNasc, "wrap 16, width 26%");
		fieldset.add(lblEstado);
		fieldset.add(cbEstado, "wrap 16, gapleft 16, grow");
		fieldset.add(lblCidade);
		fieldset.add(txCidade, "wrap 16, gapleft 16, grow");
		fieldset.add(lblPerguntaSecret);
		fieldset.add(cbPerguntaSecret, "wrap 16, gapleft 16, grow");
		fieldset.add(lblRespostaSecret);
		fieldset.add(txRespostaSecret, "wrap 16, gapleft 16, grow");
		fieldset.add(lblNovaSenha);
		fieldset.add(txNovaSenha, "wrap 16, gapleft 16, grow");
		fieldset.add(lblConfirmarSenha);
		fieldset.add(txConfirmarSenha, "wrap 16, gapleft 16, grow");

		main.add(lblTitulo, "span, wrap 16");
		main.add(profile);
		main.add(fieldset);

		footer.add(btnSalvar);

		add(main, "Center");
		add(footer, "South");
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public boolean trocarSenha() {
		String senha1 = String.valueOf(txNovaSenha.getPassword());
		String senha2 = String.valueOf(txConfirmarSenha.getPassword());
		if(senha1.equals("") & senha2.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validarSenha() {
		if(String.valueOf(txNovaSenha.getPassword()).equals(String.valueOf(txConfirmarSenha.getPassword()))) {
			return true;
		} else {
			return false;
		}
	}

	public UsuarioModel getUsuarioModel() {
		UsuarioModel usuarioAtt = usuario;
		usuarioAtt.setAvatar(cbFoto.getSelectedIndex());
		usuarioAtt.setCidade(txCidade.getText());
		usuarioAtt.setEstado((String) cbEstado.getSelectedItem());
		usuarioAtt.setNome(txNome.getText());
		usuarioAtt.setGenero((String) cbGenero.getSelectedItem());
		usuarioAtt.setPerguntaSecret((String) cbPerguntaSecret.getSelectedItem());
		usuarioAtt.setRespostaSecret(txRespostaSecret.getText());
		usuarioAtt.setDataNasc((String) cbDiaNasc.getSelectedItem() + "/" + (String) cbMesNasc.getSelectedItem() + "/" + (String) cbAnoNasc.getSelectedItem());
		if(trocarSenha() == true) {
			usuarioAtt.setSenha(String.valueOf(txNovaSenha.getPassword()));
		}
		return usuarioAtt;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		@SuppressWarnings("unchecked")
		JComboBox<String> fotoSelecionada = (JComboBox<String>) e.getSource();
		lblAvatar.setIcon(iconAvatar(fotoSelecionada.getSelectedIndex()));
	}

	public Icon iconAvatar(int avatarInt) {
		Icon avatar = new ImageIcon();
		switch (avatarInt) {
			case 0: {
				avatar = new ImageIcon("avatar/default.png");
				break;
			}
			case 1: {
				avatar = new ImageIcon("avatar/avatar1.png");
				break;
			}
			case 2: {
				avatar = new ImageIcon("avatar/avatar2.png");
				break;
			}
			case 3: {
				avatar = new ImageIcon("avatar/avatar3.png");
				break;
			}
			case 4: {
				avatar = new ImageIcon("avatar/avatar4.png");
				break;
			}
			case 5: {
				avatar = new ImageIcon("avatar/avatar5.png");
				break;
			}
			case 6: {
				avatar = new ImageIcon("avatar/avatar6.png");
				break;
			}

			case 7: {
				avatar = new ImageIcon("avatar/avatar7.png");
				break;
			}

			case 8: {
				avatar = new ImageIcon("avatar/avatar8.png");
				break;
			}

			case 9: {
				avatar = new ImageIcon("avatar/avatar9.png");
				break;
			}

			case 10: {
				avatar = new ImageIcon("avatar/avatar10.png");
				break;
			}

			case 11: {
				avatar = new ImageIcon("avatar/avatar11.png");
				break;
			}

			case 12: {
				avatar = new ImageIcon("avatar/avatar12.png");
				break;
			}

			case 13: {
				avatar = new ImageIcon("avatar/avatar13.png");
				break;
			}

			case 14: {
				avatar = new ImageIcon("avatar/avatar14.png");
				break;
			}

			case 15: {
				avatar = new ImageIcon("avatar/avatar15.png");
				break;
			}

			case 16: {
				avatar = new ImageIcon("avatar/avatar16.png");
				break;
			}

			case 17: {
				avatar = new ImageIcon("avatar/mago.png");
				break;
			}

			case 18: {
				avatar = new ImageIcon("avatar/ninja.png");
				break;
			}

			case 19: {
				avatar = new ImageIcon("avatar/pirata.png");
				break;
			}

			case 20: {
				avatar = new ImageIcon("avatar/preguica.png");
				break;
			}

			case 21: {
				avatar = new ImageIcon("avatar/rainha.png");
				break;
			}

			case 22: {
				avatar = new ImageIcon("avatar/robo.png");
				break;
			}

			case 23: {
				avatar = new ImageIcon("avatar/urso.png");
				break;
			}

			case 24: {
				avatar = new ImageIcon("avatar/zumbi.png");
				break;
			}

		}
		return avatar;
	}
}