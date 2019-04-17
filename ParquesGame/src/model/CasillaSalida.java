package model;

public class CasillaSalida extends Casilla {

	private int salidaFicha;
	
	public CasillaSalida(int posicion, int salidaFicha) {
		super(posicion);
		
		this.salidaFicha = salidaFicha;
		
	}
	
	@Override
	public void agregarFicha(Ficha ficha) {
		
		
		
	}
	
	public int getSalidaFicha() {
		return salidaFicha;
	}

	public void setSalidaFicha(int salidaFicha) {
		this.salidaFicha = salidaFicha;
	}

	

}
