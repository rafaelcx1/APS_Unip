package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class LoginView extends JFrame implements IView{
	private JPanel panelPrincipal;
	private JLabel tituloPrincipal;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JLabel lblEsqueciSenha;
	private JLabel lblCadastrar;
	private JTextField txUsuario;
	private JPasswordField txSenha;
	private JButton btnLogar;
	private JButton btnSair;

	public LoginView(){
		Color background = new Color(0xE0E0E0); 
		Font word = new Font("Open Sans", Font.BOLD , 14);
		ImageIcon logo = new ImageIcon("logo.png");
		
		panelPrincipal = new JPanel(new MigLayout("fillx, insets 25% 0% 0% 0%", "[center]rel[grow,fill]", ""));
		JPanel fieldset = new JPanel(new MigLayout());
		JPanel actions = new JPanel(new MigLayout());
		JPanel others = new JPanel(new MigLayout());
		
		tituloPrincipal = new JLabel(logo);
		lblUsuario = new JLabel("Usu�rio");
		lblSenha = new JLabel("Senha");
		lblEsqueciSenha = new JLabel("Esqueci minha senha");
		lblCadastrar = new JLabel("Criar uma conta");
		JLabel lblDivider = new JLabel(" | ");
		
		lblUsuario.setFont(word);
		lblSenha.setFont(word);
		
		txUsuario = new JTextField(28);
		txSenha = new JPasswordField(28);
		
		txUsuario.setFont(word);
		txSenha.setFont(word);
		
		btnLogar = new JButton("Entrar");
		btnSair = new JButton("Sair");
		
		btnLogar.setForeground(Color.white);
		btnSair.setForeground(Color.white);
		btnLogar.setBackground(Color.BLACK);
		btnSair.setBackground(Color.BLACK);
		
		actions.add(btnSair, "gapleft 128");
		actions.add(btnLogar);
		
		actions.setBackground(background);
		
		others.add(lblEsqueciSenha, "gap 80");
		others.add(lblDivider);
		others.add(lblCadastrar);
		
		others.setBackground(background);
		
		fieldset.add(tituloPrincipal, "span, wrap 32, gap 104");
		fieldset.add(lblUsuario);
		fieldset.add(txUsuario, "wrap 8");
		fieldset.add(lblSenha);
		fieldset.add(txSenha, " wrap 16");
		fieldset.add(actions, "span, wrap 64");
		fieldset.add(others, "span");
		
		fieldset.setBackground(background);
		
		panelPrincipal.add(fieldset, "span");
		
		panelPrincipal.setBackground(background);
		
		getContentPane().add(panelPrincipal);
		pack();
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	public String getUsuario(){
		return txUsuario.getText();
	}

	public String getSenha(){
		return String.valueOf(txSenha.getPassword());
	}

	public void botaoClick(){
		btnLogar.doClick();
	}

	public void fechar(){
		this.dispose();
	}

	public void lblAcaoMouseEntered(){
		// Inserir C�digo
	}

	public void lblAcaoMouseExited(){
		// Inserir C�digo
	}

	public void setLblEsqueciSenhaEvent(MouseListener event){
		lblEsqueciSenha.addMouseListener(event);
	}

	public void setLblCadastrarEvent(MouseListener event){
		lblCadastrar.addMouseListener(event);
	}

	public void setTextFieldEvent(KeyListener event){
		txUsuario.addKeyListener(event);
		txSenha.addKeyListener(event);
	}

	public void setBtnLogarEvent(ActionListener event){
		btnLogar.addActionListener(event);
	}

	public void setBtnSairEvent(ActionListener event){
		btnSair.addActionListener(event);
	}

	@Override
	public void displayMsg(String msg) {
		// Inserir C�digo

	}
	
	public static void main(String[] args){
		LoginView l = new LoginView();
	}
}