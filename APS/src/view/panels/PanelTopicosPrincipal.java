package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tables.TopicoModel;
import net.miginfocom.swing.MigLayout;
import util.DataUtil;
import view.BotaoTopicoPanel;

@SuppressWarnings("serial")
public class PanelTopicosPrincipal extends JPanel {

	private JLabel lblAvatar;
	private JLabel lblDataCriacao;
	private JLabel lblTituloTopico;
	private JLabel lblTag;
	private JLabel lblQtdCurtidas;
	private JLabel lblQtdRespostas;
	private BotaoTopicoPanel btnCurtir;
	private BotaoTopicoPanel btnVisualizar;
	private int idTopico;
	private boolean curtido;

	public PanelTopicosPrincipal(TopicoModel topico){
		idTopico = topico.getIdTopico();

		Color background = new Color(0xE0E0E0);

		setLayout(new MigLayout());
		setBackground(background);

		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);

		JPanel info = new JPanel(new MigLayout());
		JPanel buttons = new JPanel(new MigLayout("", "center"));

		info.setBackground(background);
		buttons.setBackground(background);

		btnCurtir = new BotaoTopicoPanel();
		btnCurtir.setText("Curtir!");
		btnCurtir.setIdTopico(topico.getIdTopico());
		btnVisualizar = new BotaoTopicoPanel();
		btnVisualizar.setText("Visualizar");
		btnVisualizar.setIdTopico(topico.getIdTopico());

		lblAvatar = new JLabel(iconAvatar(topico.getUsuario().getAvatar()));
		LocalDateTime data = DataUtil.parse(topico.getDtCriacao());
		String dataCriacao = data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear() + " às " + data.getHour() + ":" + data.getMinute();
		lblDataCriacao = new JLabel("Data de Criação:" + dataCriacao);
		lblTituloTopico = new JLabel(topico.getTitulo());
		lblTag = new JLabel("Tag: " + topico.getTag());
		lblQtdCurtidas = new JLabel(String.valueOf(topico.getQtdCurtidas()), new ImageIcon("images/like.png"), 0);
		lblQtdRespostas = new JLabel(String.valueOf(topico.getQtdRespostas()), new ImageIcon("images/comment.png"), 0);

		lblTituloTopico.setFont(titulo1);

		info.add(lblTituloTopico, "wrap 8");
		info.add(lblTag);
		info.add(lblDataCriacao, "wrap 16, gapleft 16px");
		info.add(lblQtdCurtidas);
		info.add(lblQtdRespostas);

		buttons.add(btnCurtir);
		buttons.add(btnVisualizar);

		add(lblAvatar);
		add(info, "width 30%");
		add(buttons, "width 10%, gapleft 50%");

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

	public void curtir() {
		curtido = !curtido;
	}

	public Icon iconAvatar(int avatarInt) {
		Icon avatar = new ImageIcon();
		switch (avatarInt) {
			case 0: {
				avatar = new ImageIcon("avatar/default.png");
				break;
			}
			case 1: {
				avatar = new ImageIcon("avatar/masculino1.png");
				break;
			}
			case 2: {
				avatar = new ImageIcon("avatar/masculino2.png");
				break;
			}
			case 3: {
				avatar = new ImageIcon("avatar/masculino3.png");
				break;
			}
			case 4: {
				avatar = new ImageIcon("avatar/feminino1.png");
				break;
			}
			case 5: {
				avatar = new ImageIcon("avatar/feminino2.png");
				break;
			}
			case 6: {
				avatar = new ImageIcon("avatar/feminino3.png");
				break;
			}
		}
		return avatar;
	}
}
