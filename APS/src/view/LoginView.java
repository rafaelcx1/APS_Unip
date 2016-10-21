package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


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
		panelPrincipal = new JPanel();
		
		getContentPane().add(panelPrincipal);
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
		// Inserir Código
	}

	public void lblAcaoMouseExited(){
		// Inserir Código
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
		// Inserir Código

	}
	
	public static void main(String[] args){
		LoginView l = new LoginView();
	}
}