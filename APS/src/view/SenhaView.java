package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

public class SenhaView extends JFrame implements IView {

	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblStatusUsuario;
	private JLabel lblTituloPergunta;
	private JLabel lblResposta;
	private JLabel lblStatusResposta;
	private JLabel lblNovaSenha;
	private JLabel lblConfirmaSenha;
	private JTextField txUsuario;
	private JTextField txResposta;
	private JPasswordField txNovaSenha;
	private JPasswordField txConferirSenha;
	private JButton btnConferirUsuario;
	private JButton btnConferirResposta;
	private JButton btnConcluir;
	private JButton btnVoltar;
	private JPanel panelPrincipal;
	private JPanel panelUsuario;
	private JPanel panelPergunta;
	private JPanel panelNovaSenha;
	private JPanel panelBotoes;

	public SenhaView(){
		Border btnLayout = BorderFactory.createEmptyBorder(10, 16, 10, 16);
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		MatteBorder division = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xBDBDBD));
		Font word = new Font("Open Sans", Font.BOLD , 14);
		
		JPanel panelHeader = new JPanel(new MigLayout());
		JPanel fieldset = new JPanel(new MigLayout("fillx", "[center]"));
		JPanel subFieldset = new JPanel(new MigLayout());
		panelBotoes = new JPanel(new MigLayout("fillx", "[center]"));
		panelPrincipal = new JPanel(new BorderLayout());
		JPanel div = new JPanel();
		JPanel div1 = new JPanel();
		
		panelHeader.setBackground(new Color(0x212121));
		div.setBorder(division);
		div1.setBorder(division);
		
		JLabel logo = new JLabel(new ImageIcon("logo.png"));
		lblTitulo = new JLabel("Esqueci a senha");
		lblUsuario = new JLabel("Usuário");
		lblStatusUsuario = new JLabel("Status: Não conferido");
		lblTituloPergunta = new JLabel("Pergunta secreta");
		lblResposta = new JLabel("Reposta");
		lblStatusResposta = new JLabel("Status: Não conferido");
		lblNovaSenha = new JLabel("Nova senha");
		lblConfirmaSenha = new JLabel("Confirmar senha");
		
		lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 18));
		lblTitulo.setForeground(Color.WHITE);
		
		txUsuario = new JTextField(48);
		txResposta = new JTextField(48);
		txNovaSenha = new JPasswordField(48);
		txConferirSenha = new JPasswordField(48);
		
		txResposta.setEnabled(false);
		txNovaSenha.setEnabled(false);
		txConferirSenha.setEnabled(false);
		
		btnConferirUsuario = new JButton("Conferir", new ImageIcon("create.png"));
		btnConferirResposta = new JButton("Conferir", new ImageIcon("create.png"));
		btnConcluir = new JButton("Alterar senha", new ImageIcon("create.png"));
		btnVoltar = new JButton("", new ImageIcon("back.png"));
		
		btnConferirResposta.setEnabled(false);
		btnConcluir.setEnabled(false);
		
		btnConferirUsuario.setBackground(Color.BLACK);
		btnConferirUsuario.setForeground(Color.WHITE);
		btnConferirUsuario.setBorder(defaultLayout);
		btnConferirResposta.setBackground(Color.BLACK);
		btnConferirResposta.setForeground(Color.WHITE);
		btnConferirResposta.setBorder(defaultLayout);
		btnConcluir.setBackground(Color.BLACK);
		btnConcluir.setForeground(Color.WHITE);
		btnConcluir.setBorder(defaultLayout);
		btnVoltar.setBackground(Color.BLACK);
		btnVoltar.setBorder(defaultLayout);
		
		panelHeader.add(btnVoltar);
		panelHeader.add(lblTitulo);
		
		subFieldset.add(logo, "wrap 64, span, center");
		subFieldset.add(lblUsuario);
		subFieldset.add(txUsuario, "gapleft 16, height 38px");
		subFieldset.add(btnConferirUsuario, "gapleft 16, wrap 16");
		subFieldset.add(lblStatusUsuario, "wrap 32, span, center");
		subFieldset.add(div, "wrap 64, span, grow");
		subFieldset.add(lblResposta);
		subFieldset.add(txResposta, "gapleft 16, height 38px");
		subFieldset.add(btnConferirResposta, "gapleft 16, wrap 16");
		subFieldset.add(lblStatusResposta, "wrap 32, span, center");
		subFieldset.add(div1, "wrap 64, span, grow");
		subFieldset.add(lblNovaSenha);
		subFieldset.add(txNovaSenha, "gapleft 16, wrap 16, height 38px");
		subFieldset.add(lblConfirmaSenha);
		subFieldset.add(txConferirSenha, "gapleft 16, height 38px");
		
		fieldset.add(subFieldset);
		
		panelBotoes.add(btnConcluir);
		
		panelPrincipal.add(panelHeader, "North");
		panelPrincipal.add(fieldset, "Center");
		panelPrincipal.add(panelBotoes, "South");
		
		getContentPane().add(panelPrincipal);
		pack();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}
	
	

	public String getUsuario() {
		return txUsuario.getText();
	}

	public String getResposta() {
		return txResposta.getText();
	}
	public String getSenha(){
		return String.valueOf(txConferirSenha.getPassword());
	}
	public String getNovaSenha() {
		return String.valueOf(txNovaSenha.getPassword());
	}

	public void setConferirUsuarioListener(ActionListener event) {
		btnConferirUsuario.addActionListener(event);
	}

	public void setConferirRespostaListener(ActionListener event) {
		btnConferirResposta.addActionListener(event);
	}

	public void setConcluirListener(ActionListener event) {
		btnConcluir.addActionListener(event);
	}

	public void setVoltarListener(ActionListener event) {
		btnVoltar.addActionListener(event);
	}

	public void setLblStatusUsuario(String status) {
		lblStatusUsuario.setText(status);
	}

	public void setLblStatusResposta(String status) {
		lblStatusResposta.setText(status);
	}

	public void setRegiaoUsuarioEnable(boolean b) {
		// Inserir Código
	}
	
	public void setLblPergunta(String pergunta){
		
	}

	public void setRegiaoPerguntaEnable(boolean b) {
		// Inserir Código
	}

	public void setRegiaoNovaSenhaEnable(boolean b) {
		// Inserir Código
	}

	@Override
	public void displayMsg(String msg) {
		// Inserir Código

	}
	
	public void setBtnVoltarListener(ActionListener event){
		btnVoltar.addActionListener(event);
	}

}
