package model;

import java.util.ArrayList;

public class CasillaSalida extends Casilla {

	private int salidaFicha;

	public CasillaSalida(int posicion, int salidaFicha) {
		super(posicion);

		this.salidaFicha = salidaFicha;

	}

	@Override
	public void agregarFicha(Ficha ficha) {

		boolean agregada = false;

		if (hayFichas()) {
			if (ficha.getTipo() == salidaFicha) {

				ArrayList<Integer> posIntrusos = new ArrayList<>();

				for (int i = 0; i < getFichas().length; i++) {

					if (getFichas()[i] != null) {

						if (getFichas()[i].getTipo() != salidaFicha) {

							posIntrusos.add(i);

						}

					}

				}

				if (posIntrusos.isEmpty()) {

					for (int i = 0; i < getFichas().length && !agregada; i++) {

						if (getFichas()[i] == null) {

							getFichas()[i] = ficha;
							agregada = true;

						}

					}

				} else {

					for (int i = 0; i < posIntrusos.size(); i++) {

						getFichas()[posIntrusos.get(i)].setLibre(false);
						getFichas()[posIntrusos.get(i)] = null;

					}

					for (int i = 0; i < getFichas().length && !agregada; i++) {

						if (getFichas()[i] == null) {

							getFichas()[i] = ficha;
							agregada = true;

						}

					}

				}

			} else {

				for (int i = 0; i < getFichas().length && !agregada; i++) {

					if (getFichas()[i] == null) {

						getFichas()[i] = ficha;
						agregada = true;

					}

				}

			}
		} else {

		getFichas()[0] = ficha;

		}

	}

	public int getSalidaFicha() {
		return salidaFicha;
	}

	public void setSalidaFicha(int salidaFicha) {
		this.salidaFicha = salidaFicha;
	}

}
