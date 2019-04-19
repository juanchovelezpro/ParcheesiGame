package threads;

import java.awt.event.ActionEvent;

import javax.management.monitor.Monitor;

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



	@Override
	public void run() {

		Jugador[] jugadores = parques.getJugadores();
		jugadores[0].setTurno(true);
		

		while (!finish) {

		try {
			Thread.sleep(1000);
			parques.asignarSiguienteTurno();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	}

	public Parques getParques() {
		return parques;
	}

	public void setParques(Parques parques) {
		this.parques = parques;
	}

	public PanelParques getPanelParques() {
		return panelParques;
	}

	public void setPanelParques(PanelParques panelParques) {
		this.panelParques = panelParques;
	}

}
