package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.CasillaSalida;
import model.Ficha;

class CasillaSalidaTest extends TestCase{

	private CasillaSalida casilla;
	private Ficha fichaUno;
	private Ficha fichaDos;
	private Ficha fichaTres;
	private Ficha fichaCuatro;
	
	
	
	public void escenarioUno() {
	
	casilla = new CasillaSalida(0, 1);
	
	fichaUno = new Ficha(null, 1);
	fichaDos = new Ficha(null, 2);
	fichaDos.setLibre(true);
	fichaTres = new Ficha(null, 3);
	fichaTres.setLibre(true);
	fichaCuatro = new Ficha(null, 4);
	fichaCuatro.setLibre(true);
	
	fichaDos.setPosicion(0);
	fichaTres.setPosicion(0);
	fichaCuatro.setPosicion(0);
	
	casilla.agregarFicha(fichaDos);
	casilla.agregarFicha(fichaTres);
	casilla.agregarFicha(fichaCuatro);
		
	}
	
	@Test
	public void testAgregarFicha() {
		
	escenarioUno();
	
	fichaUno.setLibre(true);
	
	assertTrue(casilla.getFichas()[0] == fichaDos);
	assertTrue(casilla.getFichas()[1] == fichaTres);
	assertTrue(casilla.getFichas()[2] == fichaCuatro);
	
	casilla.agregarFicha(fichaUno);
	
	assertTrue(casilla.getFichas()[0] == fichaUno);
	assertTrue(!fichaDos.isLibre());
	assertTrue(!fichaTres.isLibre());
	assertTrue(!fichaCuatro.isLibre());
	assertTrue(fichaDos.getPosicion() == null);
	assertTrue(fichaTres.getPosicion() == null);
	assertTrue(fichaCuatro.getPosicion() == null);
		
		
	}

}
