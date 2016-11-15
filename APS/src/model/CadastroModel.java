package model;

import dao.DAOForum;
import model.tables.UsuarioModel;

public class CadastroModel {

	private String msgErro;

	public String getMsgErro(){
		return msgErro;
	}

	public boolean cadastrarUsuario(UsuarioModel usuario){
		if(DAOForum.cadastrarUsuario(usuario)){
			return true;
		} else {
			msgErro = DAOForum.getMsgErro();
			return false;
		}
	}
}