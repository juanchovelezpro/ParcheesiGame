package model;

public class Parques {

	private Jugador[] jugadores;
	private Casilla[] casillas;
	private Casilla[][] zonaUno;
	private Casilla[][] zonaDos;
	private Casilla[][] zonaTres;
	private Casilla[][] zonaCuatro;

	public Parques() {

		casillas = new Casilla[96];
		jugadores = new Jugador[4];

		situarCasillas();

		zonaUno = new Casilla[3][8];
		zonaDos = new Casilla[8][3];
		zonaTres = new Casilla[3][8];
		zonaCuatro = new Casilla[8][3];

		rellenarZonas();

	}

	public Jugador[] getJugadores() {
		return jugadores;
	}

	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}

	public Casilla[] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[] casillas) {
		this.casillas = casillas;
	}

	public Casilla[][] getZonaUno() {
		return zonaUno;
	}

	public void setZonaUno(Casilla[][] zonaUno) {
		this.zonaUno = zonaUno;
	}

	public Casilla[][] getZonaDos() {
		return zonaDos;
	}

	public void setZonaDos(Casilla[][] zonaDos) {
		this.zonaDos = zonaDos;
	}

	public Casilla[][] getZonaTres() {
		return zonaTres;
	}

	public void setZonaTres(Casilla[][] zonaTres) {
		this.zonaTres = zonaTres;
	}

	public Casilla[][] getZonaCuatro() {
		return zonaCuatro;
	}

	public void setZonaCuatro(Casilla[][] zonaCuatro) {
		this.zonaCuatro = zonaCuatro;
	}

	public void situarCasillas() {

		for (int i = 0; i < casillas.length; i++) {

			switch (i) {

			// Se posicionan las SALIDAS

			case 0:
				casillas[i] = new CasillaSalida(i, Ficha.UNO);
				break;

			case 24:
				casillas[i] = new CasillaSalida(i, Ficha.DOS);
				break;

			case 48:
				casillas[i] = new CasillaSalida(i, Ficha.TRES);
				break;

			case 72:
				casillas[i] = new CasillaSalida(i, Ficha.CUATRO);
				break;

			// Fin posicionamiento de las SALIDAS

			// Se posicionan los SEGUROS

			case 7:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 12:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 31:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 36:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 55:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 60:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 79:
				casillas[i] = new CasillaSeguro(i);
				break;

			case 84:
				casillas[i] = new CasillaSeguro(i);
				break;

			// Fin posicionamiento de SEGUROS

			// Se posicionan las casillas NORMALES

			default:
				casillas[i] = new CasillaNormal(i);

			}

			if (i >= 85 && i <= 91) {

				casillas[i] = new CasillaCasa(i, Ficha.UNO);

			}

			if (i >= 13 && i <= 19) {

				casillas[i] = new CasillaCasa(i, Ficha.DOS);

			}

			if (i >= 37 && i <= 43) {

				casillas[i] = new CasillaCasa(i, Ficha.TRES);

			}

			if (i >= 61 && i <= 67) {

				casillas[i] = new CasillaCasa(i, Ficha.CUATRO);

			}

		}

	}

	public void rellenarZonaUno() {

		for (int i = 0, j = 83; i < zonaUno[0].length; i++, j--) {

			zonaUno[0][i] = casillas[j];

		}

		for (int i = 0, j = 84; i < zonaUno[0].length; i++, j++) {

			zonaUno[1][i] = casillas[j];

		}

		for (int i = 0, j = 92; i < zonaUno[0].length; i++, j++) {

			if (j <= 95)

				zonaUno[2][i] = casillas[j];

		}

		zonaUno[2][4] = casillas[0];

		zonaUno[2][5] = casillas[1];

		zonaUno[2][6] = casillas[2];

		zonaUno[2][7] = casillas[3];

	}

	public void rellenarZonaDos() {

		for (int i = 0, j = 4; i < zonaDos.length; i++, j++) {

			zonaDos[i][0] = casillas[j];

		}

		for (int i = 0, j = 19; i < zonaDos.length; i++, j--) {

			zonaDos[i][1] = casillas[j];

		}

		for (int i = 0, j = 27; i < zonaDos.length; i++, j--) {

			zonaDos[i][2] = casillas[j];

		}

	}

	public void rellenarZonaTres() {

		for (int i = 0, j = 51; i < zonaTres[0].length; i++, j--) {

			zonaTres[0][i] = casillas[j];

		}

		for (int i = 0, j = 43; i < zonaTres[0].length; i++, j--) {

			zonaTres[1][i] = casillas[j];

		}

		for (int i = 0, j = 28; i < zonaTres[0].length; i++, j++) {

			zonaTres[2][i] = casillas[j];

		}

	}

	public void rellenarZonaCuatro() {

		for (int i = 0, j = 68; i < zonaCuatro.length; i++, j++) {

			zonaCuatro[i][0] = casillas[j];

		}

		for (int i = 0, j = 60; i < zonaCuatro.length; i++, j++) {

			zonaCuatro[i][1] = casillas[j];

		}

		for (int i = 0, j = 59; i < zonaCuatro.length; i++, j--) {

			zonaCuatro[i][2] = casillas[j];

		}

	}

	public void rellenarZonas() {

		rellenarZonaUno();
		rellenarZonaDos();
		rellenarZonaTres();
		rellenarZonaCuatro();

	}

	public void asignarJugadores(Jugador uno, Jugador dos, Jugador tres, Jugador cuatro) {

		jugadores[0] = uno;
		jugadores[1] = dos;
		jugadores[2] = tres;
		jugadores[3] = cuatro;

	}

	public void sacarFichaDeLaCarcel(Ficha ficha) {

		ficha.setLibre(true);

		casillas[ficha.getPosicion()].agregarFicha(ficha);

		rellenarZonas();

	}

	public void sacarTodasDeLaCarcel(Ficha[] fichas) {

		for (int i = 0; i < fichas.length; i++) {

			sacarFichaDeLaCarcel(fichas[i]);

		}
	}

	public Jugador getTurnoActual() {

		Jugador j = null;

		for (int i = 0; i < jugadores.length; i++) {

			if (jugadores[i].isTurno()) {

				j = jugadores[i];

			}

		}

		return j;

	}

	public void asignarSiguienteTurno() {

		Jugador j = getTurnoActual();

		if (j.getNumero() < 3) {

			jugadores[j.getNumero()].setTurno(false);
			jugadores[j.getNumero() + 1].setTurno(true);

		} else if (j.getNumero() == 3) {

			jugadores[j.getNumero()].setTurno(false);
			jugadores[0].setTurno(true);

		}

	}

	public void definirPrimerTurno(int uno, int dos, int tres, int cuatro) {

		int[] valores = { uno, dos, tres, cuatro };

		int mayor = valores[0];
		int index = 0;

		for (int i = 1; i < valores.length; i++) {

			if (valores[i] > mayor) {

				index = i;

			}

		}

		jugadores[index].setTurno(true);

	}

	public void moverFicha(Ficha ficha, int valorDado) {

		Casilla actual = null;
		Casilla destino = null;
		int posActual = ficha.getPosicion();

		actual = casillas[posActual];

		actual.quitarFicha(ficha);

		ficha.mover(casillas, valorDado);
		int posDestino = ficha.getPosicion();

		destino = casillas[posDestino];

		destino.agregarFicha(ficha);

		rellenarZonas();

	}

}
