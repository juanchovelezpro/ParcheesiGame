package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.Casilla;
import model.Jugador;
import model.Parques;

class ParquesTest extends TestCase {

	private Parques parques;

	public void escenarioUno() {

		parques = new Parques();

		Jugador uno = new Jugador("JuanchoVelezPro", 1);
		Jugador dos = new Jugador("Ghosterline", 2);
		Jugador tres = new Jugador("anrode", 3);
		Jugador cuatro = new Jugador("jevic", 4);

		parques.asignarJugadores(uno, dos, tres, cuatro);

		parques.sacarTodasDeLaCarcel(uno.getFichas());
		parques.sacarTodasDeLaCarcel(dos.getFichas());
		parques.sacarTodasDeLaCarcel(tres.getFichas());
		parques.sacarTodasDeLaCarcel(cuatro.getFichas());

	}
	
	public void escenarioDos() {
		
		parques = new Parques();

		Jugador uno = new Jugador("JuanchoVelezPro", 1);
		Jugador dos = new Jugador("Ghosterline", 2);
		Jugador tres = new Jugador("anrode", 3);
		Jugador cuatro = new Jugador("jevic", 4);

		parques.asignarJugadores(uno, dos, tres, cuatro);

		parques.sacarTodasDeLaCarcel(uno.getFichas());
		parques.sacarTodasDeLaCarcel(dos.getFichas());
		parques.sacarTodasDeLaCarcel(tres.getFichas());
		parques.sacarTodasDeLaCarcel(cuatro.getFichas());
		
		
		parques.moverFicha(uno.getFichas()[0], 12);
		
	}
	
	public void escenarioTres() {
		
		parques = new Parques();

		Jugador uno = new Jugador("JuanchoVelezPro", 1);
		Jugador dos = new Jugador("Ghosterline", 2);
		Jugador tres = new Jugador("anrode", 3);
		Jugador cuatro = new Jugador("jevic", 4);
		
		parques.asignarJugadores(uno, dos, tres, cuatro);
		
		parques.getJugadores()[0].setTurno(true);
		
		
		
	}

	/*
	 * En este se busca verificar que cuando las fichas de un jugador salga de la carcel, se posicionen en su salida correspondiente.
	 */
	
	@Test
	public void testSacarFichasDeLaCarcel() {

		escenarioUno();

		Casilla[] casillas = parques.getCasillas();

		assertTrue(casillas[0].getFichas()[0] != null);
		assertTrue(casillas[0].getFichas()[1] != null);
		assertTrue(casillas[0].getFichas()[2] != null);
		assertTrue(casillas[0].getFichas()[3] != null);
		
		assertTrue(casillas[24].getFichas()[0] != null);
		assertTrue(casillas[24].getFichas()[1] != null);
		assertTrue(casillas[24].getFichas()[2] != null);
		assertTrue(casillas[24].getFichas()[3] != null);
		
		assertTrue(casillas[48].getFichas()[0] != null);
		assertTrue(casillas[48].getFichas()[1] != null);
		assertTrue(casillas[48].getFichas()[2] != null);
		assertTrue(casillas[48].getFichas()[3] != null);
		
		assertTrue(casillas[72].getFichas()[0] != null);
		assertTrue(casillas[72].getFichas()[1] != null);
		assertTrue(casillas[72].getFichas()[2] != null);
		assertTrue(casillas[72].getFichas()[3] != null);

	}

	
	@Test
	public void testAsignarSiguienteTurno() {
		
	escenarioTres();
	
	parques.asignarSiguienteTurno();
	
	assertTrue(!parques.getJugadores()[0].isTurno());
	assertTrue(parques.getJugadores()[1].isTurno());
		
		
		
	}
	
}
