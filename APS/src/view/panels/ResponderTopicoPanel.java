package view.panels;

import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.tables.PostagemModel;
import model.tables.TopicoModel;
import util.DataUtil;

public class ResponderTopicoPanel extends JPanel {
      private JLabel lblTitulo;
      private JLabel lblTextoResposta;
      private JButton btnPostarResposta;
      private JTextArea taTextoPost;
      private int idTopico;

      public ResponderTopicoPanel(int idTopico) {
            this.idTopico = idTopico;
            //Completar
      }

      public JButton getBtnPostarResposta() {
            return btnPostarResposta;
      }
      
      public int getIdTopico() {
            return idTopico;
      }

      public PostagemModel getPostagemModel() {
        PostagemModel postagem = new PostagemModel();
        postagem.setTextoPost(taTextoPost.getText());
        postagem.setDataPost(DataUtil.format(LocalDate.now()));
    	  return postagem;
      }
}
