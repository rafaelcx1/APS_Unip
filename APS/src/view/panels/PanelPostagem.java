package view.panels;

public class PanelPostagem extends JPanel{
	private JLabel lblAvatar;
	private JLabel lblNome;
	private JLabel lblEstadoCidade;
	private JLabel lblDataCadastro;
	private JLabel lblDataResposta;
	private JLabel lblTextoPostagem;
	private PostagemModel postagem;
	
	public PanelPostagem(PostagemModel postagem) {
		this.postagem = postagem;
		//Continuar
	}
}
