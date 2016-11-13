package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CadastroView extends JFrame implements IView, ActionListener, KeyListener{

	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblDataNasc;
	private JLabel lblGenero;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblPerguntaSecret;
	private JLabel lblRespostaSecret;
	private JTextField txNome;
	private JTextField txUsuario;
	private JPasswordField ptxSenha;
	private JComboBox<String> cbDiaNasc;
	private JComboBox<String> cbMesNasc;
	private JComboBox<String> cbAnoNasc;
	private JComboBox<String> cbGenero;
	private JComboBox<String> cbEstado;
	private JTextField txCidade;
	private JComboBox<String> cbPerguntaSecret;
	private JTextField txRespostaSecret;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JPanel panelPrincipal;
	private JPanel panelBotoes;

	public CadastroView(){
		super("JSolve - Fórum: Cadastro");
		Border btnLayout = BorderFactory.createEmptyBorder(10, 16, 10, 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Font word = new Font("Open Sans", Font.BOLD , 14);

		JPanel panelHeader = new JPanel(new MigLayout());
		JPanel fieldset = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel subFieldset = new JPanel(new MigLayout());
		JPanel subBotoes = new JPanel();
		panelPrincipal = new JPanel(new BorderLayout());
		panelBotoes = new JPanel(new MigLayout("fillx", "[center]"));

		panelHeader.setBackground(new Color(0x212121));

		JLabel logo = new JLabel(new ImageIcon("images/logo.png"));
		lblTitulo = new JLabel("Criar uma conta");
		lblNome = new JLabel("Nome");
		lblUsuario = new JLabel("Usuário");
		lblSenha = new JLabel("Senha");
		lblDataNasc = new JLabel("Data de nascimento");
		lblGenero = new JLabel("Gênero");
		lblEstado = new JLabel("Estado");
		lblCidade = new JLabel("Cidade");
		lblPerguntaSecret = new JLabel("Pergunta secreta");
		lblRespostaSecret = new JLabel("Resposta secreta");

		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblTitulo.setForeground(Color.WHITE);
		lblNome.setFont(word);
		lblUsuario.setFont(word);
		lblSenha.setFont(word);
		lblDataNasc.setFont(word);
		lblGenero.setFont(word);
		lblEstado.setFont(word);
		lblCidade.setFont(word);
		lblPerguntaSecret.setFont(word);
		lblRespostaSecret.setFont(word);

		txNome = new JTextField(48);
		txUsuario = new JTextField(48);
		ptxSenha = new JPasswordField(48);
		txCidade = new JTextField(48);
		txRespostaSecret = new JTextField(48);

		txNome.setFont(word);
		txUsuario.setFont(word);
		ptxSenha.setFont(word);
		txCidade.setFont(word);
		txRespostaSecret.setFont(word);

		btnCadastrar = new JButton("Cadastrar", new ImageIcon("images/create.png"));
		btnLimpar = new JButton("Limpar", new ImageIcon("images/clear.png"));
		btnVoltar = new JButton("", new ImageIcon("images/back.png"));

		btnCadastrar.setBackground(Color.BLACK);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBorder(defaultLayout);
		btnLimpar.setBackground(Color.BLACK);
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBorder(defaultLayout);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(btnLayout);



		btnCadastrar.setFocusPainted(false);
		btnLimpar.setFocusPainted(false);
		btnVoltar.setFocusPainted(false);

		setBtnLimparListener(this);

		String[] dias = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String[] meses = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		String[] anos = new String[117];

		for(int i = 1900, a = 0; i < 2017; i = i + 1, a = a + 1){
			anos[a] = String.valueOf(i);
		}

		String[] generos = {"Masculino", "Feminino"};
		String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB" , "PE", "PI", "PR", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
		String[] perguntas  = {"Qual o nome do primeiro cachorro?", "Qual o nome do primeiro(a) professor(a)?", "Em qual cidade você nasceu?", "Qual sua comida favorita?", "Qual cidade você mais gostou?", "Para onde foi sua primeira viagem?"};
		cbDiaNasc = new JComboBox<String>(dias);
		cbMesNasc = new JComboBox<String>(meses);
		cbAnoNasc = new JComboBox<String>(anos);
		cbEstado = new JComboBox<String>(estados);
		cbGenero = new JComboBox<String>(generos);
		cbPerguntaSecret = new JComboBox<String>(perguntas);
		cbGenero.addKeyListener(this);
		txCidade.addKeyListener(this);
		txNome.addKeyListener(this);
		txRespostaSecret.addKeyListener(this);
		txUsuario.addKeyListener(this);
		ptxSenha.addKeyListener(this);
		cbAnoNasc.addKeyListener(this);
		cbDiaNasc.addKeyListener(this);
		cbEstado.addKeyListener(this);
		cbMesNasc.addKeyListener(this);
		cbPerguntaSecret.addKeyListener(this);

		cbEstado.setSelectedIndex(24);

		subBotoes.add(btnLimpar);
		subBotoes.add(btnCadastrar);

		panelHeader.add(btnVoltar);
		panelHeader.add(lblTitulo);

		subFieldset.add(logo, "wrap 64, span, center");
		subFieldset.add(lblNome);
		subFieldset.add(txNome, "wrap 16, gapleft 16");
		subFieldset.add(lblUsuario);
		subFieldset.add(txUsuario, "wrap 16, gapleft 16");
		subFieldset.add(lblSenha);
		subFieldset.add(ptxSenha, "wrap 16, gapleft 16");
		subFieldset.add(lblDataNasc);
		subFieldset.add(cbDiaNasc, "split 3, width 25%, gapleft 16");
		subFieldset.add(cbMesNasc, "split 3, width 26%");
		subFieldset.add(cbAnoNasc, "split 3, wrap 16, width 25%");
		subFieldset.add(lblGenero);
		subFieldset.add(cbGenero, "wrap 16, grow, gapleft 16");
		subFieldset.add(lblEstado);
		subFieldset.add(cbEstado, "wrap 16, grow, gapleft 16");
		subFieldset.add(lblCidade);
		subFieldset.add(txCidade, "wrap 16, gapleft 16");
		subFieldset.add(lblPerguntaSecret);
		subFieldset.add(cbPerguntaSecret, "wrap 16, grow, gapleft 16");
		subFieldset.add(lblRespostaSecret);
		subFieldset.add(txRespostaSecret, "gapleft 16");

		fieldset.add(subFieldset);

		panelBotoes.add(subBotoes);

		panelPrincipal.add(panelHeader, "North");
		panelPrincipal.add(fieldset, "Center");
		panelPrincipal.add(panelBotoes, "South");

		getContentPane().add(panelPrincipal);
		setMinimumSize(new Dimension(800,600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
	}

	public void focus() {
		txNome.grabFocus();
	}

	public String getNome(){
		return txNome.getText();
	}

	public String getUsuario(){
		return txUsuario.getText();
	}

	public String getSenha(){
		return String.valueOf(ptxSenha.getPassword());
	}

	public String getDataNasc(){
		return (String) cbDiaNasc.getSelectedItem() + "/" + (String) cbMesNasc.getSelectedItem() + "/" + (String) cbAnoNasc.getSelectedItem();
	}

	public String getGenero(){
		return (String) cbGenero.getSelectedItem();
	}

	public String getEstado(){
		return (String) cbEstado.getSelectedItem();
	}

	public String getCidade(){
		return txCidade.getText();
	}

	public String getPerguntaSecret(){
		return (String) cbPerguntaSecret.getSelectedItem();
	}

	public String getRespostaSecret(){
		return txRespostaSecret.getText();
	}

	public void setBtnCadastroListener(ActionListener event){
		btnCadastrar.addActionListener(event);
	}

	public void setBtnLimparListener(ActionListener event){
		btnLimpar.addActionListener(event);
	}

	public void setBtnVoltarListener(ActionListener event){
		btnVoltar.addActionListener(event);
	}

	public void resetarCampos(){
		txNome.setText("");
		txUsuario.setText("");
		ptxSenha.setText("");
		txCidade.setText("");
		txRespostaSecret.setText("");
	}

	@Override
	public void displayMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLimpar){
			resetarCampos();
		}
	}

	@Override
	public void fechar() {
		this.dispose();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			btnVoltar.doClick();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
