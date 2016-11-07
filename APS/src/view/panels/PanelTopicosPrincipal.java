package view.panels;

import javax.swing.JPanel;

import view.BotaoTopicoPanel;

public class PanelTopicosPrincipal extends JPanel {

	private JLabel lblAvatar;
	private JLabel lblDataCriacao;
	private JLabel lblTituloTopico;
	private JLabel lblTag;
	private JLabel lblQtdCurtidas;
	private JLabel lblQtdRespostas;
	private TopicoModel topico;
	private BotaoTopicoPanel btnCurtir;
	private BotaoTopicoPanel btnResponder;
	private BotaoTopicoPanel btnVisualizar;
	private int idTopico;
	private boolean curtido;

	public PanelTopicosPrincipal(String[] tags) {
		this.tags = tags;
	}
	
	public BotaoTopicoPanel getBtnCurtir() {
		return btnCurtir;
	}

	public void setBtnCurtir(BotaoTopicoPanel btnCurtir) {
		this.btnCurtir = btnCurtir;
	}

	public BotaoTopicoPanel getBtnResponder() {
		return btnResponder;
	}

	public void setBtnResponder(BotaoTopicoPanel btnResponder) {
		this.btnResponder = btnResponder;
	}

	public BotaoTopicoPanel getBtnVisualizar() {
		return btnVisualizar;
	}

	public void setBtnVisualizar(BotaoTopicoPanel btnVisualizar) {
		this.btnVisualizar = btnVisualizar;
	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

	public boolean isCurtido() {
		return curtido;
	}

	public void setCurtido(boolean curtido) {
		this.curtido = curtido;
	}

}
