package model;

public class Ficha {

	public static final int UNO = 1;
	public static final int DOS = 2;
	public static final int TRES = 3;
	public static final int CUATRO = 4;
	
	
	private Integer posicion;
	private int tipo;
	private boolean isLibre;
	private boolean isOut;

	
	public Ficha(Integer posicion, int tipo) {
		super();
		this.posicion = posicion;
		this.tipo = tipo;
		isLibre = false;
		isOut = false;
		
	}


	public boolean isOut() {
		return isOut;
	}


	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}


	public boolean isLibre() {
		return isLibre;
	}


	public void setLibre(boolean isLibre) {
		this.isLibre = isLibre;
	}


	public Integer getPosicion() {
		return posicion;
	}


	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		
	return ""+tipo;	
		
	}
	
	
	
}
