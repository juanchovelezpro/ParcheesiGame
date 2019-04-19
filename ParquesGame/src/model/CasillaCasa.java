package model;

public class CasillaCasa extends Casilla {

	private int tipoFicha;

	public CasillaCasa(int posicion, int tipoFicha) {
		super(posicion);

		this.tipoFicha = tipoFicha;

	}

	@Override
	public int getTipoFicha() {
		return tipoFicha;
	}

	public void setTipoFicha(int tipoFicha) {
		this.tipoFicha = tipoFicha;
	}

	@Override
	public void agregarFicha(Ficha ficha) {

		boolean agregada = false;

		for (int i = 0; i < getFichas().length && !agregada; i++) {

			if (getFichas()[i] == null) {

				getFichas()[i] = ficha;
				agregada = true;

			}

		}

	}

}
