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
	private JPanel panelAuxFichasLibres;
	private JPanel panelAuxFichasCarcel;
	private JButton[] butsFichasLibres;
	private JButton[] butsFichasCarcel;
	private JLabel labCarcel;
	private JLabel labLibres;

	public PanelJugador(PanelParques parques, int id) {

		this.parques = parques;
		this.id = id;

		setLayout(null);

		init();

		add(labCarcel);
		add(labLibres);
		add(labInfoJugador);
		add(butLanzarDados);
		add(panelAuxFichasCarcel);
		add(panelAuxFichasLibres);

	}

	public void init() {

		Jugador[] jugadores = parques.getInicio().getWindow().getParquesGame().getJugadores();

		Font font = new Font("Century Gothic", 1, 24);

		labInfoJugador = new JLabel(jugadores[id - 1].getNombre() + "- Player #" + jugadores[id - 1].getNumero());
		labInfoJugador.setFont(font);
		labInfoJugador.setBounds(25, 0, 400, 80);
		labInfoJugador.setHorizontalAlignment(SwingConstants.CENTER);

		labCarcel = new JLabel("CARCEL");
		labCarcel.setFont(font);
		labCarcel.setBounds(90, 60, 100, 25);

		labLibres = new JLabel("LIBRES");
		labLibres.setFont(font);
		labLibres.setBounds(310, 60, 100, 25);

		butLanzarDados = new JButton("LANZAR DADOS");
		butLanzarDados.setFont(font);
		butLanzarDados.setBackground(parques.getInicio().getButsColores()[id - 1].getBackground());
		butLanzarDados.setBounds(10, 265, 450, 50);
		butLanzarDados.addActionListener(this);

		panelAuxFichasCarcel = new JPanel();
		panelAuxFichasCarcel.setBounds(45, 85, 180, 180);
		panelAuxFichasCarcel.setLayout(new GridLayout(2, 2));

		panelAuxFichasLibres = new JPanel();
		panelAuxFichasLibres.setLayout(new GridLayout(2, 2));
		panelAuxFichasLibres.setBounds(250, 85, 180, 180);

		butsFichasLibres = new JButton[4];
		butsFichasCarcel = new JButton[4];

		for (int i = 0; i < 4; i++) {

			int ficha = i + 1;

			butsFichasLibres[i] = new JButton("" + ficha);
			butsFichasLibres[i].setFont(font);
			butsFichasLibres[i].addActionListener(this);

			butsFichasCarcel[i] = new JButton("" + ficha);
			butsFichasCarcel[i].setFont(font);
			butsFichasCarcel[i].addActionListener(this);

			panelAuxFichasCarcel.add(butsFichasCarcel[i]);
			panelAuxFichasLibres.add(butsFichasLibres[i]);

		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Color c = parques.getZonaUnoBut()[0][0].getBackground();

		Jugador[] jugadores = parques.getInicio().getWindow().getParquesGame().getJugadores();

		for (int i = 0; i < jugadores[id - 1].getFichas().length; i++) {

			if (!jugadores[id - 1].getFichas()[i].isLibre()) {

				butsFichasCarcel[i].setBackground(parques.getInicio().getButsColores()[id - 1].getBackground());
				butsFichasCarcel[i].setEnabled(true);
				butsFichasLibres[i].setBackground(c);
				butsFichasLibres[i].setEnabled(false);

			} else {

				butsFichasCarcel[i].setBackground(c);
				butsFichasCarcel[i].setEnabled(false);
				butsFichasLibres[i].setBackground(parques.getInicio().getButsColores()[id - 1].getBackground());
				butsFichasLibres[i].setEnabled(true);

			}

		}

		if (jugadores[id - 1].isTurno()) {

			butLanzarDados.setEnabled(true);

		} else {

			butLanzarDados.setEnabled(false);

		}

		repaint();

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

			Jugador[] jugadores = parques.getInicio().getWindow().getParquesGame().getJugadores();

			jugadores[id - 1].lanzarDados();	
			
			
			

		} else if (e.getSource().equals(butsFichasLibres[0])) {

			System.out.println("Soy la ficha 1 del jugador " + id);

		} else if (e.getSource().equals(butsFichasLibres[1])) {

			System.out.println("Soy la ficha 2 del jugador " + id);

		} else if (e.getSource().equals(butsFichasLibres[2])) {

			System.out.println("Soy la ficha 3 del jugador " + id);

		} else if (e.getSource().equals(butsFichasLibres[3])) {

			System.out.println("Soy la ficha 4 del jugador " + id);

		} else if (e.getSource().equals(butsFichasCarcel[0])) {

			System.out.println("Soy la ficha carcel 1 del jugador " + id);

		} else if (e.getSource().equals(butsFichasCarcel[1])) {

			System.out.println("Soy la ficha carcel 2 del jugador " + id);

		} else if (e.getSource().equals(butsFichasCarcel[2])) {

			System.out.println("Soy la ficha carcel 3 del jugador " + id);

		} else if (e.getSource().equals(butsFichasCarcel[3])) {

			System.out.println("Soy la ficha carcel 4 del jugador " + id);

		}

	}

}
