package model;

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

}
