package view.panels;

import model.tables.UsuarioModel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

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
		
		btnInicio = new JButton("Teste");
		btnPerfil = new JButton("Teste");
		btnPostagens = new JButton("Teste");
		btnSair = new JButton("Teste");
		
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
		
		lblUsuario = new JLabel("Hey");
		lblData = new JLabel("10/10/2010");
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

}
