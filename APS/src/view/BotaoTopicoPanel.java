package view;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotaoTopicoPanel extends JButton {

	private int idTopico;

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

}