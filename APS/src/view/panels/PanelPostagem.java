package view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import model.tables.PostagemModel;
import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class PanelPostagem extends JPanel{
	private JLabel lblAvatar;
	private JLabel lblNome;
	private JLabel lblEstadoCidade;
	private JLabel lblQtdPostagens;
	private JLabel lblDataCadastro;
	private JLabel lblDataResposta;
	private JLabel lblTextoPostagem;
	private PostagemModel postagem;

	public PanelPostagem(PostagemModel postagem) {
		this.postagem = postagem;

		setLayout(new MigLayout());

		Color background = new Color(0xE0E0E0);
		MatteBorder division = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xBDBDBD));

		setBackground(background);
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1, true));

		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);

		JPanel div = new JPanel();
		JPanel info = new JPanel(new MigLayout());

		div.setBorder(division);
		div.setBackground(background);
		info.setBackground(background);

		UsuarioModel usuario = postagem.getUsuario();
		lblAvatar = new JLabel(iconAvatar(usuario.getAvatar()));
		lblNome = new JLabel("Usuario: " + usuario.getUsuario());
		lblEstadoCidade = new JLabel("Cidade/Estado: " + usuario.getCidade() + " - " + usuario.getEstado());
		lblQtdPostagens = new JLabel("Quantidade de Postagens: " + usuario.getQtdPostagens(), new ImageIcon("images/comment.png"), 0);
		lblDataCadastro = new JLabel("Data de Cadastro: " + usuario.getDataCadastro());
		lblDataResposta = new JLabel("Data desta postagem: " + postagem.getDataPost().replace("|", "às").replace(".", "/"));
		lblTextoPostagem = new JLabel(postagem.getTextoPost());

		lblNome.setFont(titulo1);

		info.add(lblNome, "wrap 16");
		info.add(lblTextoPostagem, "wrap 16");
		info.add(div, "wrap 16, grow, span");
		info.add(lblQtdPostagens, "gapright 30px");
		info.add(lblDataCadastro, "gapright 30px");
		info.add(lblDataResposta, "wrap 16");
		info.add(lblEstadoCidade);

		add(lblAvatar);
		add(info, "gapleft 16");
	}

	public PostagemModel getPostagem() {
		return postagem;
	}

	private Icon iconAvatar(int avatarInt) {
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
