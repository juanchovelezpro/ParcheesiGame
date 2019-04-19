package threads;

import java.awt.event.ActionEvent;

import model.Jugador;
import model.Parques;
import view.PanelDados;
import view.PanelJugador;
import view.PanelParques;

public class HiloGame extends Thread {

	private Parques parques;
	private PanelParques panelParques;
	private boolean finish = false;

	public HiloGame(Parques parques, PanelParques panelParques) {

		this.parques = parques;
		this.panelParques = panelParques;

	}

	public void definirPrimerLanzamiento(int uno, int dos, int tres, int cuatro) {

		parques.definirPrimerTurno(uno, dos, tres, cuatro);

	}

	@Override
	public void run() {

		Jugador[] jugadores = parques.getJugadores();
		jugadores[0].setTurno(true);

		while (!finish) {

			

		}

	}

}
