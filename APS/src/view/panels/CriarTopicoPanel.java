package view.panels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.tables.PostagemModel;
import model.tables.TopicoModel;

public class CriarTopicoPanel extends JPanel{

	private JLabel lblTitulo;
	private JLabel lblTag;
	private JLabel lblTextoPostagem;
	private JTextField txTitulo;
	private JComboBox<String> cbTag;
	private JTextArea taTextoPostagem;
	private JButton btnPostarTopico;
	private JButton btnVoltar;
	private String tags[];

	CriarTopicoPanel(String[] tags) {

	}

	public JButton getBtnPostarTopico() {
		return btnPostarTopico;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public PostagemModel getPostagemModel() {
		PostagemModel postagem = new PostagemModel();
		postagem.setTopico(getTopicoModel());
		postagem.setTextoPost(taTextoPostagem.getText());
		postagem.setDataPost(DataUtil.format(LocalDate.now()));
		return postagem;
	}

	private TopicoModel getTopicoModel() {
		TopicoModel topico = new TopicoModel();
		topico.setTitulo(txTitulo.getText());
		topico.setTag((String) cbTag.getSelectedItem());
		topico.setDtCriacao(DataUtil.format(LocalDate.now()));
		return topico;
	}
}
