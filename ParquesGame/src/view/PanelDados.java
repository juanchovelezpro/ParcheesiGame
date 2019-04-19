package view;

import javax.swing.*;

import model.Jugador;
import tools.ResourceLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDados extends JPanel implements ActionListener {

	public final static ImageIcon UNO = new ImageIcon(ResourceLoader.loadImage("/uno.png"));
	public final static ImageIcon DOS = new ImageIcon(ResourceLoader.loadImage("/dos.png"));
	public final static ImageIcon TRES = new ImageIcon(ResourceLoader.loadImage("/tres.png"));
	public final static ImageIcon CUATRO = new ImageIcon(ResourceLoader.loadImage("/cuatro.png"));
	public final static ImageIcon CINCO = new ImageIcon(ResourceLoader.loadImage("/cinco.png"));
	public final static ImageIcon SEIS = new ImageIcon(ResourceLoader.loadImage("/seis.png"));

	private PanelParques parques;
	private JButton butDadoUno;
	private JButton butDadoDos;
	private JLabel labTurnoActual;

	public PanelDados(PanelParques parques) {

		this.parques = parques;

		setLayout(null);

		labTurnoActual = new JLabel("Turno Actual: ----");
		labTurnoActual.setBounds(15, 40, 400, 45);
		labTurnoActual.setHorizontalAlignment(SwingConstants.CENTER);
		labTurnoActual.setFont(new Font("Century Gothic", 1, 24));

		butDadoUno = new JButton();
		butDadoUno.setBounds(120, 95, 100, 100);
		butDadoUno.addActionListener(this);

		butDadoDos = new JButton();
		butDadoDos.setBounds(240, 95, 100, 100);
		butDadoDos.addActionListener(this);

		add(labTurnoActual);
		add(butDadoUno);
		add(butDadoDos);

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Jugador turnoActual = parques.getInicio().getWindow().getParquesGame().getTurnoActual();

		if (turnoActual != null) {

			labTurnoActual.setText("Turno actual: " + turnoActual.getNombre());
			setBackground(parques.getInicio().getButsColores()[turnoActual.getNumero() - 1].getBackground());

			if (turnoActual.getDadoUno().getValor() != null) {

				switch (turnoActual.getDadoUno().getValor()) {

				case 1:
					butDadoUno.setIcon(UNO);
					break;

				case 2:
					butDadoUno.setIcon(DOS);
					break;

				case 3:
					butDadoUno.setIcon(TRES);
					break;

				case 4:
					butDadoUno.setIcon(CUATRO);
					break;

				case 5:
					butDadoUno.setIcon(CINCO);
					break;

				case 6:
					butDadoUno.setIcon(SEIS);
					break;

				default:

					butDadoUno.setIcon(null);
					break;
				}

			}else {
				
			butDadoUno.setIcon(null);	
				
			}

			if (turnoActual.getDadoDos().getValor() != null) {

				switch (turnoActual.getDadoDos().getValor()) {

				case 1:
					butDadoDos.setIcon(UNO);
					break;

				case 2:
					butDadoDos.setIcon(DOS);
					break;

				case 3:
					butDadoDos.setIcon(TRES);
					break;

				case 4:
					butDadoDos.setIcon(CUATRO);
					break;

				case 5:
					butDadoDos.setIcon(CINCO);
					break;

				case 6:
					butDadoDos.setIcon(SEIS);
					break;

				default:

					butDadoDos.setIcon(null);
					break;
				}

			}else {
				
			butDadoDos.setIcon(null);	
				
			}

		}
		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(butDadoUno)) {

			System.out.println("Soy el dado uno");

		} else if (e.getSource().equals(butDadoDos)) {

			System.out.println("Soy el dado dos");

		}

	}

	public JButton getButDadoUno() {
		return butDadoUno;
	}

	public void setButDadoUno(JButton butDadoUno) {
		this.butDadoUno = butDadoUno;
	}

	public JButton getButDadoDos() {
		return butDadoDos;
	}

	public void setButDadoDos(JButton butDadoDos) {
		this.butDadoDos = butDadoDos;
	}

	public JLabel getLabTurnoActual() {
		return labTurnoActual;
	}

	public void setLabTurnoActual(JLabel labTurnoActual) {
		this.labTurnoActual = labTurnoActual;
	}
	
	

}
