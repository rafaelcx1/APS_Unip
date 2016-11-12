package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.tables.PostagemModel;
import net.miginfocom.swing.MigLayout;
import util.DataUtil;

public class ResponderTopicoPanel extends JPanel {
      private JLabel lblTitulo;
      private JLabel lblTextoResposta;
      private JButton btnPostarResposta;
      private JTextArea taTextoPost;
      private int idTopico;

      public ResponderTopicoPanel(int idTopico) {
    	  
    	  setLayout(new MigLayout("fillx"));
    	  	
    	  	Font titulo1 = new Font("Open Sans", Font.BOLD , 18);
    	  	Border defaultLayout = BorderFactory.createEmptyBorder(6, 12, 6, 12);
    	  	
            this.idTopico = idTopico;
            
            lblTitulo = new JLabel("Resposta");
            lblTextoResposta = new JLabel("Texto");
            
            lblTitulo.setFont(titulo1);
            
            taTextoPost = new JTextArea(8, 0);
            
            taTextoPost.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            btnPostarResposta = new JButton("Responder");
            
            btnPostarResposta.setBackground(Color.BLACK);
            btnPostarResposta.setForeground(Color.WHITE);
            btnPostarResposta.setBorder(defaultLayout);
            
            add(lblTitulo, "wrap 16");
            add(lblTextoResposta, "wrap 16");
            add(taTextoPost, "wrap 16, grow");
            add(btnPostarResposta);
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
