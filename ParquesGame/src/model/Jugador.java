package model;

import java.util.Random;

public class Jugador {

	private String nombre;
	private int numero;
	private Ficha[] fichas;
	private boolean turno;
	private Dado dadoUno;
	private Dado dadoDos;

	public Jugador(String nombre, int numero) {

		this.nombre = nombre;
		this.numero = numero;

		turno = false;

		dadoUno = new Dado();
		dadoDos = new Dado();

		fichas = new Ficha[4];

		generarFichas();

	}

	public int getFichasLibres() {

		int libres = 0;

		for (int i = 0; i < fichas.length; i++) {

			if (!fichas[i].isOut()) {

				if (fichas[i].isLibre()) {

					libres++;

				}

			}

		}

		return libres;

	}

	public int getFichasOut() {

		int out = 0;

		for (int i = 0; i < fichas.length; i++) {

			if (fichas[i].isOut()) {

				out++;

			}

		}

		return out;

	}

	public Dado getDadoUno() {
		return dadoUno;
	}

	public void setDadoUno(Dado dadoUno) {
		this.dadoUno = dadoUno;
	}

	public Dado getDadoDos() {
		return dadoDos;
	}

	public void setDadoDos(Dado dadoDos) {
		this.dadoDos = dadoDos;
	}

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public void generarFichas() {

		for (int i = 0; i < fichas.length; i++) {

			fichas[i] = new Ficha(null, numero);

		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Ficha[] getFichas() {
		return fichas;
	}

	public void setFichas(Ficha[] fichas) {
		this.fichas = fichas;
	}

	public boolean lanzarDadosTresVeces() {

		boolean lanzar = false;

		if (getFichasLibres() != 0) {

			lanzar = true;

		}

		return lanzar;

	}

	public boolean lanzamientoPar() {

		boolean lanzar = false;

		if (dadoUno.getValor() == dadoDos.getValor()) {

			lanzar = true;

		}

		return lanzar;

	}

	public void lanzarDados() {
		
	Random ran = new Random();
	
	dadoUno.setValor(ran.nextInt(6)+1);
	dadoDos.setValor(ran.nextInt(6)+1);
		
		
	}
}
