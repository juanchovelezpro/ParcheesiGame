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

	public void mover(Casilla[] casillas, int valorDado) {

		if (pasoPorCasaAjena(casillas, valorDado)) {

			if (posicion + valorDado > 95) {

				posicion += -96 + valorDado + 7;

			} else {

				posicion += valorDado + 7;

			}

		} else {
			if (posicion + valorDado > 95) {

				posicion += -96 + valorDado;

			} else {

				posicion += valorDado;

			}
		}

	}

	public boolean pasoPorCasaAjena(Casilla[] casillas, int valorDado) {

		boolean paso = false;
		int posActual = this.posicion;

		for (int i = posActual + 1; i <= posActual + valorDado && !paso; i++) {

			int aux = 0;

			if (i > 95) {

				aux = i - 96;

			} else {

				aux = i;

			}

			if (casillas[aux] instanceof CasillaCasa) {

				if (this.tipo != casillas[aux].getTipoFicha()) {

					paso = true;

				}

			}

		}

		return paso;

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

		if (isLibre) {

			switch (tipo) {

			case 1:
				posicion = 0;
				break;

			case 2:
				posicion = 24;
				break;

			case 3:
				posicion = 48;
				break;

			case 4:
				posicion = 72;
				break;

			}

		} else {

			posicion = null;

		}

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

		return "" + tipo;

	}

}
