package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.tables.PostagemModel;
import model.tables.TopicoModel;

public class ResponderTopicoPanel extends JPanel {
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
