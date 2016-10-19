package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JTextField txNovaSenha;
	private JTextField txConferirSenha;
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

	public String getNovaSenha() {
		return txNovaSenha.getText();
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

	public void setRegiaoUsuarioEnable(boolean b, String pergunta) {
		// Inserir Código
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

}
