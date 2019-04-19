package view;

import javax.swing.*;

import model.Jugador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJugador extends JPanel implements ActionListener{

	
	private PanelParques parques;
	private Jugador jugador;
	private JLabel labInfoJugador;
	private JButton butLanzarDados;
	private JButton butCarcel;

	public PanelJugador(PanelParques parques, Jugador jugador) {

		this.parques = parques;
		
		this.jugador = jugador;

		setLayout(null);
		
		init();
		
		add(labInfoJugador);
		add(butLanzarDados);
		add(butCarcel);

	}

	public void init() {

		Font font = new Font("Century Gothic", 1, 24);
		
		labInfoJugador = new JLabel(jugador.getNombre() + " #" + jugador.getNumero());
		labInfoJugador.setFont(font);
		labInfoJugador.setBounds(0,0,400,80);
		
		butLanzarDados = new JButton("LANZAR DADOS");
		butLanzarDados.setFont(font);
		butLanzarDados.setBounds(10, 265, 450, 50);
		
		butCarcel = new JButton();
		butCarcel.setBounds(15, 100, 435, 60);
		butCarcel.setLayout(new GridLayout(1, 4));

		for (int i = 0; i < 4; i++) {

			butCarcel.add(new JButton());

		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

	}

	public PanelParques getParques() {
		return parques;
	}

	public void setParques(PanelParques parques) {
		this.parques = parques;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public JLabel getLabInfoJugador() {
		return labInfoJugador;
	}

	public void setLabInfoJugador(JLabel labInfoJugador) {
		this.labInfoJugador = labInfoJugador;
	}

	public JButton getButLanzarDados() {
		return butLanzarDados;
	}

	public void setButLanzarDados(JButton butLanzarDados) {
		this.butLanzarDados = butLanzarDados;
	}

	public JButton getButCarcel() {
		return butCarcel;
	}

	public void setButCarcel(JButton butCarcel) {
		this.butCarcel = butCarcel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
