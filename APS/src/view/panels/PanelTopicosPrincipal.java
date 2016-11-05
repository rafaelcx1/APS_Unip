package view.panels;

import javax.swing.JPanel;

import view.BotaoTopicoPanel;

public class PanelTopicosPrincipal extends JPanel {

	private BotaoTopicoPanel btnCurtir;
	private BotaoTopicoPanel btnResponder;
	private BotaoTopicoPanel btnVisualizar;

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

}
