package view.panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import model.tables.PostagemModel;
import net.miginfocom.swing.MigLayout;
import view.BotaoTopicoPanel;

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
		
		Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
		
		JPanel div = new JPanel();
		JPanel info = new JPanel(new MigLayout());
		
		div.setBorder(division);
		div.setBackground(background);
		info.setBackground(background);
		
		lblAvatar = new JLabel(new ImageIcon("default.png"));
		lblNome = new JLabel("Hey");
		lblEstadoCidade = new JLabel("Pindamonhangaba - SP");
		lblQtdPostagens = new JLabel("10", new ImageIcon("comment.png"), 0);
		lblDataCadastro = new JLabel("11/11/2016");
		lblDataResposta = new JLabel("11/11/2016");
		lblTextoPostagem = new JLabel("jhgdjshgdjsahdgjhasgdsdjgasjhfghs");
		
		lblNome.setFont(titulo1);
		
		info.add(lblNome, "wrap 16");
		info.add(lblTextoPostagem, "wrap 16");
		info.add(div, "wrap 16, grow, span");
		info.add(lblQtdPostagens);
		info.add(lblDataCadastro);
		info.add(lblDataResposta, "wrap 16");
		info.add(lblEstadoCidade);
		
		add(lblAvatar);		
		add(info, "gapleft 16");
	}

	public PostagemModel getPostagem() {
		return postagem;
	}
}
