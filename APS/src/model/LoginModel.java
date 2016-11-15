package model;

import dao.DAOForum;
import model.models.UsuarioLoginModel;
import model.tables.UsuarioModel;

public class LoginModel {
	private String msgErro;
	private UsuarioModel usuarioLogado;

	public String getMsgErro() {
		return msgErro;
	}

	public UsuarioModel getUsuarioLogado(){
		return usuarioLogado;
	}

	public boolean conferirLogin(UsuarioLoginModel usuario){
		try {
			usuarioLogado = DAOForum.conferirUsuario(usuario);
			if(usuarioLogado == null) {
				msgErro = "Usu�rio inv�lido";
				return false;
			} else {
				if(usuarioLogado.getSenha().equals(usuario.getSenha())){
					return true;
				} else {
					msgErro = "Senha inv�lida";
					return false;
				}

			}
		} catch(Exception e) {
			msgErro = "Ocorreu um erro inesperado. \nErro: " + e.getMessage();
			e.printStackTrace();
			return false;
		}

	}

}