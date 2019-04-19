package model;

import java.util.Arrays;

public abstract class Casilla {

	private Ficha[] fichas;
	private int posicion;

	public Casilla(int posicion) {

		fichas = new Ficha[8];

		this.posicion = posicion;

	}

	public void agregarFicha(Ficha ficha) {

	}

	public Ficha[] getFichas() {
		return fichas;
	}

	public void setFichas(Ficha[] fichas) {
		this.fichas = fichas;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getTipoFicha() {

		return 0;

	}

	@Override
	public String toString() {

		return "" + posicion + Arrays.toString(fichas);

	}

}
