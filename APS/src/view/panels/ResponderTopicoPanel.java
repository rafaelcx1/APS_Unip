package view.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.tables.PostagemModel;
import model.tables.TopicoModel;

public class ResponderTopicoPanel extends JPanel {
      private JButton btnPostarResposta;
      private TopicoModel topico;
      private PostagemModel postagem;

      public ResponderTopicoPanel(TopicoModel topico, PostagemModel postagem) {
    	  this.topico = topico;
    	  this.postagem = postagem;
      }

      public JButton getBtnPostarResposta() {
            return btnPostarResposta;
      }

      public PostagemModel getPostagemModel() {
    	  return postagem;
      }

      public TopicoModel getTopicoModel() {
    	  return topico;
      }
}
