package view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tables.TopicoModel;
import net.miginfocom.swing.MigLayout;
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
	private BotaoTopicoPanel btnVisualizar;
	private int idTopico;
	private boolean curtido;
	
	public PanelTopicosPrincipal(){
		Color background = new Color(0xE0E0E0);
		
		setLayout(new MigLayout());
		setBackground(background);
		
		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		
		JPanel info = new JPanel(new MigLayout());
		JPanel buttons = new JPanel(new MigLayout("", "center"));
		
		info.setBackground(background);
		buttons.setBackground(background);
		
		btnCurtir = new BotaoTopicoPanel();
		btnVisualizar = new BotaoTopicoPanel();
		
		lblAvatar = new JLabel(new ImageIcon("default.png"));
		lblDataCriacao = new JLabel("11/11/2016");
		lblTituloTopico = new JLabel("Titulo");
		lblTag = new JLabel("Tecnologia");
		lblQtdCurtidas = new JLabel("10", new ImageIcon("like.png"), 0);
		lblQtdRespostas = new JLabel("10", new ImageIcon("comment.png"), 0);
		
		lblTituloTopico.setFont(titulo1);
	
		info.add(lblTituloTopico, "wrap 8");
		info.add(lblTag);
		info.add(lblDataCriacao, "wrap 16");
		info.add(lblQtdCurtidas);
		info.add(lblQtdRespostas);
		
		buttons.add(btnCurtir);
		buttons.add(btnVisualizar);
		
		add(lblAvatar);		
		add(info, "width 30%");
		add(buttons, "width 10%, gapleft 60%");
		
	}

	public PanelTopicosPrincipal(String[] tags) {
	}

	public BotaoTopicoPanel getBtnCurtir() {
		return btnCurtir;
	}

	public void setBtnCurtir(BotaoTopicoPanel btnCurtir) {
		this.btnCurtir = btnCurtir;
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
