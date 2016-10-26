package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;


@SuppressWarnings("serial")
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
		super("JSolve - Fórum");
		Color background = new Color(0xE0E0E0);
		Font word = new Font("Open Sans", Font.BOLD , 14);
		ImageIcon logo = new ImageIcon("logo.png");

		panelPrincipal = new JPanel(new MigLayout("fillx, insets 25% 0% 0% 0%", "[center]rel[grow,fill]", ""));
		JPanel fieldset = new JPanel(new MigLayout());
		JPanel actions = new JPanel(new MigLayout());
		JPanel others = new JPanel(new MigLayout());

		tituloPrincipal = new JLabel(logo);
		lblUsuario = new JLabel("Usuário:");
		lblSenha = new JLabel("Senha:");
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

	public void lblAcaoMouseEntered(JLabel lblTemp){
		if(lblTemp.equals(lblCadastrar)){
			@SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblCadastrar.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			lblCadastrar.setFont(new Font(atributos));
			lblCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} else {
			@SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblEsqueciSenha.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			lblEsqueciSenha.setFont(new Font(atributos));
			lblEsqueciSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	}

	public void lblAcaoMouseExited(JLabel lblTemp){
		if(lblTemp.equals(lblCadastrar)){
			@SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblCadastrar.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, -1);
			lblCadastrar.setFont(new Font(atributos));
			lblCadastrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		} else {
			@SuppressWarnings("unchecked")
			Map<TextAttribute, Integer> atributos = (Map<TextAttribute, Integer>) lblEsqueciSenha.getFont().getAttributes();
			atributos.put(TextAttribute.UNDERLINE, -1);
			lblEsqueciSenha.setFont(new Font(atributos));
			lblEsqueciSenha.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
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
		JOptionPane.showMessageDialog(this, msg);
	}
}