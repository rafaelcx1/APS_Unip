package view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class BarraHorizontalPanel extends JPanel {

	private JButton btnInicio;
	private JButton btnPerfil;
	private JButton btnPostagens;
	private JButton btnSair;
	private JLabel lblUsuario;
	private JLabel lblData;

	public BarraHorizontalPanel(UsuarioModel usuario) {
		Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
		Font word = new Font("Open Sans", Font.BOLD , 14);

		setLayout(new MigLayout("", "[100%]"));

		JPanel img = new JPanel(new MigLayout("insets 12px"));
		JPanel buttons = new JPanel();
		JPanel user = new JPanel(new BorderLayout());
		JPanel userIn = new JPanel(new MigLayout());

		img.setBackground(new Color(0x212121));
		buttons.setBackground(new Color(0x212121));
		user.setBackground(new Color(0x212121));
		userIn.setBackground(new Color(0x212121));

		btnInicio = new JButton("Início");
		btnPerfil = new JButton("Perfil");
		btnPostagens = new JButton("Postagens");
		btnSair = new JButton("Sair");

		btnInicio.setBackground(null);
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setFont(new Font("Open Sans", Font.BOLD , 18));
		btnInicio.setBorder(defaultLayout);
		btnPerfil.setBackground(null);
		btnPerfil.setForeground(Color.WHITE);
		btnPerfil.setFont(new Font("Open Sans", Font.BOLD , 18));
		btnPerfil.setBorder(defaultLayout);
		btnPostagens.setBackground(null);
		btnPostagens.setForeground(Color.WHITE);
		btnPostagens.setFont(new Font("Open Sans", Font.BOLD , 18));
		btnPostagens.setBorder(defaultLayout);
		btnSair.setBackground(null);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Open Sans", Font.BOLD , 18));
		btnSair.setBorder(defaultLayout);

		lblUsuario = new JLabel("Olá " + usuario.getUsuario(), iconAvatar(usuario.getAvatar()), 0);
		String data = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
		lblData = new JLabel(data);
		JLabel logo = new JLabel(new ImageIcon("logo1.png"));

		lblUsuario.setForeground(Color.WHITE);
		lblData.setForeground(Color.WHITE);

		lblUsuario.setFont(word);
		lblData.setFont(word);

		img.add(logo);

		buttons.add(btnInicio);
		buttons.add(btnPerfil);
		buttons.add(btnPostagens);
		buttons.add(btnSair);

		userIn.add(lblData);
		userIn.add(lblUsuario, "gapleft 32px");

		user.add(userIn, "East");

		add(img, "split 2");
		add(buttons, "gapleft 32px");
		add(user, "grow, pad 26px 0 0 0");
	}

	public JButton getBtnInicio() {
		return btnInicio;
	}

	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	public JButton getBtnPostagens() {
		return btnPostagens;
	}

	public JButton getBtnSair() {
		return btnSair;
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
