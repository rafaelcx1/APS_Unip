package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SenhaView implements IView {

	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblStatusUsuario;
	private JLabel lblTituloPergunta;
	private JLabel lblReposta;
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
		// Inserir C�digo
	}
	
	public void setLblPergunta(String pergunta){
		
	}

	public void setRegiaoPerguntaEnable(boolean b) {
		// Inserir C�digo
	}

	public void setRegiaoNovaSenhaEnable(boolean b) {
		// Inserir C�digo
	}

	@Override
	public void displayMsg(String msg) {
		// Inserir C�digo

	}
	
	public void setBtnVoltarListener(ActionListener event){
		btnVoltar.addActionListener(event);
	}

}
