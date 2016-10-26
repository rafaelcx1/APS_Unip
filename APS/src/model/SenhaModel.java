package model;

import dao.DAOForum;
import model.tables.UsuarioModel;

public class SenhaModel {

	private UsuarioModel usuario;
	private String msgErro;

	public String getUsuario() {
		return usuario.getNome();
	}

	public void setUsuario(String usuario) {
		this.usuario.setUsuario(usuario);;
	}

	public String getPergunta() {
		return usuario.getPerguntaSecret();
	}

	public String getMsgErro() {
		return msgErro;
	}

	public boolean conferirUsuario(String usuario) {
		try {
			this.usuario = DAOForum.conferirUsuario(usuario);
			if(this.usuario != null){
				return true;
			} else {
				msgErro = "Usuário não encontrado!";
				return false;
			}
		} catch(Exception e){
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return false;
		}
	}

	public boolean conferirResposta(String resposta) {
		try {
			if(usuario.getRespostaSecret().equals(resposta)){
				return true;
			} else {
				msgErro = "Resposta inválida!";
				return false;
			}
		} catch(Exception e){
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return false;
		}
	}

	public boolean trocarSenha(String novaSenha) {
		try {
			usuario.setSenha(novaSenha);
			return DAOForum.trocarSenha(usuario);
		} catch (Exception e){
			msgErro = DAOForum.getMsgErro();
			e.printStackTrace();
			return false;
		}
	}
}
