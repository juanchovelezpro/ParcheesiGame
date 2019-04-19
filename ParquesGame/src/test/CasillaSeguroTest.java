package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.CasillaSeguro;
import model.Ficha;

class CasillaSeguroTest extends TestCase {

	private CasillaSeguro casilla;
	private Ficha fichaUno;
	private Ficha fichaDos;
	private Ficha fichaTres;
	private Ficha fichaCuatro;

	public void escenarioUno() {

		casilla = new CasillaSeguro(12);

		fichaUno = new Ficha(null, 1);
		fichaDos = new Ficha(null, 2);
		fichaTres = new Ficha(null, 3);
		fichaCuatro = new Ficha(null, 4);

	}

	@Test
	public void testAgregarFicha() {

		escenarioUno();

		casilla.agregarFicha(fichaUno);
		casilla.agregarFicha(fichaDos);
		casilla.agregarFicha(fichaTres);
		casilla.agregarFicha(fichaCuatro);

		assertTrue(casilla.getFichas()[0] == fichaUno);
		assertTrue(casilla.getFichas()[1] == fichaDos);
		assertTrue(casilla.getFichas()[2] == fichaTres);
		assertTrue(casilla.getFichas()[3] == fichaCuatro);

	}

}
