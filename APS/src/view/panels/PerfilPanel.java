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
	private JTextField txnome;
	private JComboBox<String> cbFoto;
	private JComboBox<String> cbGenero;
	private JComboBox<String> cbDiaNasc;
	private JComboBox<String> cbMesNasc;
	private JComboBox<Integer> cbAnoNasc;
	private JComboBox<String> cbEstado;
	private JTextField txCidade;
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
		Font word = new Font("Open Sans", Font.BOLD , 14);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);

		JPanel main = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel footer = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel fieldset = new JPanel(new MigLayout());
		JPanel profile = new JPanel(new MigLayout("", "[center]"));

		lblTitulo = new JLabel("Perfil");
		lblAvatar = new JLabel(new ImageIcon("default.png"));
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
		
		txnome = new JTextField(48);
		txCidade = new JTextField(48);
		txRespostaSecret = new JTextField(48);
		
		txnome.setFont(word);
		txCidade.setFont(word);
		txRespostaSecret.setFont(word);
		
		txConfirmarSenha = new JPasswordField(48);
		txNovaSenha = new JPasswordField(48);
		
		String[] generos = {"Masculino", "Feminino"};
		String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB" , "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		String[] dias = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] meses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		Integer[] anos = new Integer[117];
		
		for(int i = 1900, a = 0; i < 2017; i = i + 1, a = a + 1){
			anos[a] = i;
		}
		
		cbFoto = new JComboBox<String>(new String[]{"Padrão", "Abelha", "Alien", "Âncora", "Arqueiro", "Avatar 1", "Avatar 2", "Avatar 3", "Avatar 4", "Avatar 5", "Avatar 6", "Avatar 7", "Avatar 8", "Avatar 9", "Avatar 10", "Avatar 11", "Avatar 12", "Avatar 13", "Avatar 14", "Avatar 15", "Avatar 16", "Avião", "Balão", "Baleia", "Bola", "Bomba", "Cão", "Caveira", "Cupcake", "Dinossauro", "Dragão", "Espada", "Fênix", "Fusca", "Galo", "Gato", "Girassol", "Hamburguer", "Japonesa", "Leite", "Lhama", "Mago", "Mapa", "Nave", "Ninja", "Pirata", "Preguiça", "Rainha", "Raposa", "Robô", "Robô 1", "Soldado", "Taco", "Tesouro", "Tubarão", "Urso", "Urso 1", "Veneno", "Zumbi"});
		cbGenero = new JComboBox<String>(generos);
		cbDiaNasc = new JComboBox<String>(dias);
		cbMesNasc = new JComboBox<String>(meses);
		cbAnoNasc = new JComboBox<Integer>(anos);
		cbEstado = new JComboBox<String>(estados);
		cbPerguntaSecret = new JComboBox<String>(generos);
		
		btnSalvar = new JButton("Salvar");
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnSalvar.setBackground(Color.BLACK);
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setBorder(defaultLayout);
		
		profile.add(lblAvatar, "wrap 16");
		profile.add(cbFoto);
		
		fieldset.add(lblNome);
		fieldset.add(txnome, "wrap 16, gapleft 16, grow");
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

	public UsuarioModel getUsuarioModel() {
		return null;
	}

}
