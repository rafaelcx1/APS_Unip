package view;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastroView extends JFrame implements IView {

	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblDataNasc;
	private JLabel lblGenero;
	private JLabel lblPerguntaSecret;
	private JLabel lblRespostaSecret;
	private JTextField txNome;
	private JPasswordField ptxSenha;
	private JTextField txDataNasc;
	private JTextField txGenero;
	private JTextField txEstado;
	private JTextField txCidade;
	private JComboBox<String> cbPerguntaSecret; // As perguntas ter�o que come�ar com um n�mero, por exemplo: 1- Cidade em que nasceu
	private JTextField txRespostaSecret;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JPanel panelPrincipal;
	private JPanel panelBotoes;

	public CadastroView(){
		lblTitulo = new JLabel();
		lblNome = new JLabel("Nome");
		lblUsuario = new JLabel("Usu�rio");
		lblSenha = new JLabel("Senha");
		lblDataNasc = new JLabel("Data de nascimento");
		lblGenero = new JLabel("G�nero");
		lblPerguntaSecret = new JLabel("Pergunta secreta");
		lblRespostaSecret = new JLabel("Resposta secreta");
		
		txNome = new JTextField();
		ptxSenha = new JPasswordField();
		txCidade = new JTextField();
		txRespostaSecret = new JTextField();
		
		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		btnVoltar = new JButton("", new ImageIcon());
		setVisible(true);
	}

	public String getNome(){
		return txNome.getText();
	}

	public String getUsuario(){
		return txDataNasc.getText();
	}

	public String getSenha(){
		return String.valueOf(ptxSenha.getPassword());
	}

	public String getDataNasc(){
		return txDataNasc.getText();
	}

	public String getGenero(){
		return txGenero.getText();
	}

	public String getEstado(){
		return txEstado.getText();
	}

	public String getCidade(){
		return txCidade.getText();
	}

	public int getPerguntaSecret(){
		return cbPerguntaSecret.getSelectedIndex();
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
		// Inserir C�digo
	}

	@Override
	public void displayMsg(String msg) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args){
		new CadastroView();
	}
}
