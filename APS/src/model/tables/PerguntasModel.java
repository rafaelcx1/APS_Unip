package model.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perguntas")
public class PerguntasModel {

	@Id @GeneratedValue
	@Column(name = "idPergunta", nullable = false)
	private int idPergunta;

	@Column(name = "pergunta", nullable = false)
	private String pergunta;


	public int getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(int idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public PerguntasModel(int idPergunta){
		this.idPergunta = idPergunta;
	}
}
