package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CasillaNormal;
import model.Ficha;

class CasillaNormalTest {

	private CasillaNormal casilla;
	private Ficha fichaUno;
	private Ficha fichaUnoAux;
	private Ficha fichaDos;
	
	
	public void escenarioUno() {
	
	casilla = new CasillaNormal(6);
	
	fichaUno = new Ficha(null, 1);
	fichaUnoAux = new Ficha(null, 1);
	fichaDos = new Ficha(null, 2);
	
	fichaUno.setLibre(true);
	fichaUnoAux.setLibre(true);
	fichaDos.setLibre(true);
	casilla.agregarFicha(fichaUno);
	casilla.agregarFicha(fichaUnoAux);
		
		
	}
	
	@Test
	public void testAgregarFicha() {
		
	escenarioUno();
	


	
	assertTrue(casilla.getFichas()[0] == fichaUno);
	assertTrue(casilla.getFichas()[1] == fichaUnoAux);
	
	
	casilla.agregarFicha(fichaDos);
	
	assertTrue(!fichaUno.isLibre());
	assertTrue(!fichaUnoAux.isLibre());
	
	assertTrue(casilla.getFichas()[0] == fichaDos);
		
	}

}
