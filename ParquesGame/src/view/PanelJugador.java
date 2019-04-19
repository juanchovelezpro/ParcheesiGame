package view;

import javax.swing.*;

import model.Jugador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJugador extends JPanel implements ActionListener {

	private PanelParques parques;
	private int id;
	private JLabel labInfoJugador;
	private JButton butLanzarDados;
	private JButton butCarcel;

	public PanelJugador(PanelParques parques, int id) {

		this.parques = parques;
		this.id = id;

		setLayout(null);

		init();

		add(labInfoJugador);
		add(butLanzarDados);
		add(butCarcel);

	}

	public void init() {

		Jugador[] jugadores = parques.getInicio().getWindow().getParquesGame().getJugadores();

		Font font = new Font("Century Gothic", 1, 24);

		labInfoJugador = new JLabel(jugadores[id - 1].getNombre() + "- Player #" + jugadores[id - 1].getNumero());
		labInfoJugador.setFont(font);
		labInfoJugador.setBounds(25, 0, 400, 80);
		labInfoJugador.setHorizontalAlignment(SwingConstants.CENTER);

		butLanzarDados = new JButton("LANZAR DADOS");
		butLanzarDados.setFont(font);
		butLanzarDados.setBounds(10, 265, 450, 50);
		butLanzarDados.addActionListener(this);

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

		Jugador[] jugadores = parques.getInicio().getWindow().getParquesGame().getJugadores();

		for (int i = 0; i < jugadores[id - 1].getFichas().length; i++) {

			if (!jugadores[id - 1].getFichas()[i].isLibre()) {

				butCarcel.getComponent(i).setBackground(parques.getInicio().getButsColores()[id - 1].getBackground());

			}

		}

	}

	public PanelParques getParques() {
		return parques;
	}

	public void setParques(PanelParques parques) {
		this.parques = parques;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

		if (e.getSource().equals(butLanzarDados)) {

			System.out.println("Lanzando dados - Player#" + id);

		}

	}

}
