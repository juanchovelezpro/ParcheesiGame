package model;

public class CasillaSeguro extends Casilla {

	public CasillaSeguro(int posicion) {
		super(posicion);

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
