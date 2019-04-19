package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.Ficha;
import model.Parques;

class FichaTest extends TestCase{

	private Parques parques;
	private Ficha ficha;
	private Ficha fichaDos;
	private Ficha fichaTres;
	private Ficha fichaCuatro;

	public void escenarioUno() {

		ficha = new Ficha(null, 1);
		ficha.setLibre(true);

		fichaDos = new Ficha(null, 2);
		fichaDos.setLibre(true);

		fichaTres = new Ficha(null, 3);
		fichaTres.setLibre(true);

		fichaCuatro = new Ficha(null, 4);
		fichaCuatro.setLibre(true);

	}

	public void escenarioDos() {

		escenarioUno();

		parques = new Parques();

	}

	public void escenarioTres() {

		escenarioDos();

		ficha.mover(parques.getCasillas(), 12);
		ficha.mover(parques.getCasillas(), 1);

	}
	
	public void escenarioCuatro() {
		
		escenarioDos();
		
		ficha.setPosicion(83);
		fichaDos.setPosicion(11);
		fichaTres.setPosicion(35);
		fichaCuatro.setPosicion(59);
		
		ficha.mover(parques.getCasillas(), 2);
		fichaDos.mover(parques.getCasillas(), 2);
		fichaTres.mover(parques.getCasillas(), 2);
		fichaCuatro.mover(parques.getCasillas(), 2);
	}
	


	@Test
	public void testVerificarPosicionDeSalida() {

		escenarioUno();

		assertTrue(ficha.getPosicion() == 0);
		assertTrue(fichaDos.getPosicion() == 24);
		assertTrue(fichaTres.getPosicion() == 48);
		assertTrue(fichaCuatro.getPosicion() == 72);

	}

	@Test
	public void testPasoPorCasaAjena() {

		escenarioDos();

		assertTrue(ficha.pasoPorCasaAjena(parques.getCasillas(), 13));

	}

	@Test
	public void testVerificarMovimientoPasandoPorCasaAjena() {

		escenarioTres();
		
		assertTrue(ficha.getPosicion() == 20);
		
	}
	
	@Test
	public void testVerificarEntradaACasa() {
		
		escenarioCuatro();
		
		assertTrue(ficha.getPosicion() == 85);
		assertTrue(fichaDos.getPosicion() == 13);
		assertTrue(fichaTres.getPosicion() == 37);
		assertTrue(fichaCuatro.getPosicion() == 61);
		
	}
	
	

}
