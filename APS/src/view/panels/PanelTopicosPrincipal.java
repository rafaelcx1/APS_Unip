package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
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
	private JLabel lblUsuario;
	private JLabel lblDataCriacao;
	private JLabel lblTituloTopico;
	private JLabel lblTag;
	private JLabel lblQtdCurtidas;
	private JLabel lblQtdRespostas;
	private BotaoTopicoPanel btnCurtir;
	private BotaoTopicoPanel btnVisualizar;
	private int idTopico;
	private int qtdCurtidas;
	private boolean curtido;

	public PanelTopicosPrincipal(TopicoModel topico){
		//setLayout(new MigLayout("", "[grow]", "[grow]"));
		curtido = false;
		qtdCurtidas = topico.getQtdCurtidas();
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1));

		idTopico = topico.getIdTopico();

		Color background = new Color(0xE0E0E0);

		setLayout(new MigLayout());
		setBackground(background);

		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);

		//JPanel info = new JPanel(new MigLayout());
		//JPanel buttons = new JPanel(new MigLayout("", "center"));

		//info.setBackground(background);
		//buttons.setBackground(background);

		btnCurtir = new BotaoTopicoPanel();
		btnCurtir.setText("Curtir!");
		btnCurtir.setIdTopico(topico.getIdTopico());
		btnCurtir.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
		btnCurtir.setBackground(Color.BLACK);
		btnCurtir.setForeground(Color.WHITE);
		btnVisualizar = new BotaoTopicoPanel();
		btnVisualizar.setText("Visualizar");
		btnVisualizar.setIdTopico(topico.getIdTopico());
		btnVisualizar.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));
		btnVisualizar.setBackground(Color.BLACK);
		btnVisualizar.setForeground(Color.WHITE);

		lblAvatar = new JLabel(iconAvatar(topico.getUsuario().getAvatar()));
		lblUsuario = new JLabel("Usuário: " + topico.getUsuario().getUsuario());
		LocalDateTime data = DataUtil.parse(topico.getDtCriacao());
		String dataCriacao = data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear() + " às " + data.getHour() + ":" + data.getMinute();
		lblDataCriacao = new JLabel("Data de Criação:" + dataCriacao);
		lblTituloTopico = new JLabel(topico.getTitulo());
		lblTag = new JLabel("Tag: " + topico.getTag());
		lblQtdCurtidas = new JLabel(String.valueOf(topico.getQtdCurtidas()), new ImageIcon("images/like.png"), 0);
		lblQtdRespostas = new JLabel(String.valueOf(topico.getQtdRespostas()), new ImageIcon("images/comment.png"), 0);

		lblTituloTopico.setFont(titulo1);

		//info.add(lblTituloTopico, "wrap 8");
		//info.add(lblTag);
		//info.add(lblDataCriacao, "wrap 16, gapleft 16px");
		//info.add(lblQtdCurtidas);
		//info.add(lblQtdRespostas);

		//buttons.add(btnCurtir);
		//buttons.add(btnVisualizar);

		//add(info, "width 30%");
		//add(buttons, "width 10%, gapleft 50%");

	}

	public void atualizarLayout() {
		setLayout(new MigLayout("", "[150:n][100:n][grow][grow]", "[::50,grow][::35,grow][::35,grow][::35,grow][20::n, grow][::25,grow]"));
		add(lblAvatar, "cell 0 0 1 6,alignx center,aligny center");
		add(lblTituloTopico, "cell 1 0 2 1,alignx left,aligny center");
		add(lblUsuario, "cell 1 1,alignx left,aligny bottom");
		add(lblTag, "cell 1 2,alignx left,aligny center");
		add(lblDataCriacao, "cell 1 3,alignx left,aligny center");
		add(btnCurtir, "cell 4 1,alignx right,aligny center");
		add(btnVisualizar, "cell 4 2,alignx right,aligny center");
		add(lblQtdCurtidas, "cell 1 5,alignx left,aligny bottom");
		add(lblQtdRespostas, "cell 2 5,alignx left,aligny bottom");
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
		if(curtido)
			qtdCurtidas = qtdCurtidas - 1;
		else
			qtdCurtidas = qtdCurtidas + 1;
		curtido = !curtido;
		lblQtdCurtidas.setText(String.valueOf(qtdCurtidas));

	}

	public Icon iconAvatar(int avatarInt) {
		Icon avatar = new ImageIcon();
		switch (avatarInt) {
			case 0: {
				avatar = new ImageIcon("avatar/default.png");
				break;
			}
			case 1: {
				avatar = new ImageIcon("avatar/avatar1.png");
				break;
			}
			case 2: {
				avatar = new ImageIcon("avatar/avatar2.png");
				break;
			}
			case 3: {
				avatar = new ImageIcon("avatar/avatar3.png");
				break;
			}
			case 4: {
				avatar = new ImageIcon("avatar/avatar4.png");
				break;
			}
			case 5: {
				avatar = new ImageIcon("avatar/avatar5.png");
				break;
			}
			case 6: {
				avatar = new ImageIcon("avatar/avatar6.png");
				break;
			}

			case 7: {
				avatar = new ImageIcon("avatar/avatar7.png");
				break;
			}

			case 8: {
				avatar = new ImageIcon("avatar/avatar8.png");
				break;
			}

			case 9: {
				avatar = new ImageIcon("avatar/avatar9.png");
				break;
			}

			case 10: {
				avatar = new ImageIcon("avatar/avatar10.png");
				break;
			}

			case 11: {
				avatar = new ImageIcon("avatar/avatar11.png");
				break;
			}

			case 12: {
				avatar = new ImageIcon("avatar/avatar12.png");
				break;
			}

			case 13: {
				avatar = new ImageIcon("avatar/avatar13.png");
				break;
			}

			case 14: {
				avatar = new ImageIcon("avatar/avatar14.png");
				break;
			}

			case 15: {
				avatar = new ImageIcon("avatar/avatar15.png");
				break;
			}

			case 16: {
				avatar = new ImageIcon("avatar/avatar16.png");
				break;
			}

			case 17: {
				avatar = new ImageIcon("avatar/mago.png");
				break;
			}

			case 18: {
				avatar = new ImageIcon("avatar/ninja.png");
				break;
			}

			case 19: {
				avatar = new ImageIcon("avatar/pirata.png");
				break;
			}

			case 20: {
				avatar = new ImageIcon("avatar/preguiça.png");
				break;
			}

			case 21: {
				avatar = new ImageIcon("avatar/rainha.png");
				break;
			}

			case 22: {
				avatar = new ImageIcon("avatar/robo.png");
				break;
			}

			case 23: {
				avatar = new ImageIcon("avatar/urso.png");
				break;
			}

			case 24: {
				avatar = new ImageIcon("avatar/zumbi.png");
				break;
			}

		}
		return avatar;
	}
}
