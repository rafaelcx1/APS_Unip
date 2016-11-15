package model.models;

public class FiltroModel {

	public static final boolean ASCENDENTE = false;
	public static final boolean DESCENDENTE = true;

	private String tag;
	private String usuario;
	private String titulo;
	private boolean orderDate;

	public FiltroModel(){
		this.tag = "";
		this.usuario = "";
		this.titulo = "";
		this.orderDate = true;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean getOrderDate(){
		return orderDate;
	}

	public void setOrderDate(boolean orderDate) {
		this.orderDate = orderDate;
	}

}