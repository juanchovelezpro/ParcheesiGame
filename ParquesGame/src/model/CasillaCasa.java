package model;

public class CasillaCasa extends Casilla {

	private int casaFicha;
	
	public CasillaCasa(int posicion, int casaFicha) {
		super(posicion);
		
		this.casaFicha = casaFicha;
		
	}

	public int getCasaFicha() {
		return casaFicha;
	}

	public void setCasaFicha(int casaFicha) {
		this.casaFicha = casaFicha;
	}

	@Override
	public void agregarFicha(Ficha ficha) {
	
		
	}

}
