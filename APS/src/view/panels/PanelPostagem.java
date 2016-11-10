package view.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
<<<<<<< HEAD
import model.tables.PostagemModel;

public class PanelPostagem extends JPanel {

	private JLabel lblAvatar;
	private JLabel lblNome;
	private JLabel lblEstadoCidade;
	private JLabel lblQtdPostagens;
=======

import model.tables.PostagemModel;

public class PanelPostagem extends JPanel{
	private JLabel lblAvatar;
	private JLabel lblNome;
	private JLabel lblEstadoCidade;
>>>>>>> b6b6b1c3ec601421db5e4140bac8391999995a28
	private JLabel lblDataCadastro;
	private JLabel lblDataResposta;
	private JLabel lblTextoPostagem;
	private PostagemModel postagem;
<<<<<<< HEAD
	
	public PanelPostagem(PostagemModel postagem){
		
	}
	
=======

	public PanelPostagem(PostagemModel postagem) {
		this.postagem = postagem;
		//Continuar
	}
>>>>>>> b6b6b1c3ec601421db5e4140bac8391999995a28
}
