package view;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel implements ActionListener {

	private MainWindow window;
	private JButton butJugar;
	private PanelParques parques;
	private JLabel[] labsJugadores;
	private JTextField[] txtNombres;
	private JButton[] butsColores;
	private JDialog[] dialogsColores;
	private JButton[] butsEscogerColor;
	private JColorChooser[] coloresJugadores;
	private JPanel auxPanel;

	public PanelInicio(MainWindow window) {

		this.window = window;

		setLayout(new BorderLayout());

		init();

		add(butJugar, BorderLayout.SOUTH);
		add(auxPanel, BorderLayout.CENTER);

	}

	public void init() {

		butJugar = new JButton("JUGAR");
		butJugar.addActionListener(this);

		auxPanel = new JPanel();
		auxPanel.setLayout(new GridLayout(4, 3));

		butsColores = new JButton[4];
		labsJugadores = new JLabel[4];
		coloresJugadores = new JColorChooser[4];
		txtNombres = new JTextField[4];
		dialogsColores = new JDialog[4];
		butsEscogerColor = new JButton[4];

		for (int i = 1; i < 5; i++) {

			butsColores[i - 1] = new JButton("COLOR");
			butsColores[i - 1].setFont(new Font("Garamond", 1, 20));
			butsColores[i - 1].addActionListener(this);

			labsJugadores[i - 1] = new JLabel("Jugador #" + i);
			labsJugadores[i - 1].setFont(new Font("Garamond", 1, 20));
			labsJugadores[i - 1].setHorizontalAlignment(SwingConstants.CENTER);

			butsEscogerColor[i - 1] = new JButton("ESCOGER");
			butsEscogerColor[i - 1].addActionListener(this);

			txtNombres[i - 1] = new JTextField();
			coloresJugadores[i - 1] = new JColorChooser();
			dialogsColores[i - 1] = new JDialog(window, "Escoge un color");
			dialogsColores[i - 1].setLayout(new BorderLayout());
			dialogsColores[i - 1].add(coloresJugadores[i - 1], BorderLayout.CENTER);
			dialogsColores[i - 1].add(butsEscogerColor[i - 1], BorderLayout.SOUTH);
			dialogsColores[i - 1].pack();

			auxPanel.add(labsJugadores[i - 1]);
			auxPanel.add(txtNombres[i - 1]);
			auxPanel.add(butsColores[i - 1]);

		}

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		for (int i = 0; i < butsColores.length; i++) {

			if (coloresJugadores[i].getColor() != Color.WHITE) {

				butsColores[i].setBackground(coloresJugadores[i].getColor());

			}

		}
		repaint();

	}

	public MainWindow getWindow() {
		return window;
	}

	public void setWindow(MainWindow window) {
		this.window = window;
	}

	public JButton getButJugar() {
		return butJugar;
	}

	public void setButJugar(JButton butJugar) {
		this.butJugar = butJugar;
	}

	public void personalizarParques(Color uno, Color dos, Color tres, Color cuatro) {

		// Se pintan las casillas casa para cada equipo

		for (int k = 0; k < parques.getZonaUnoBut()[0].length; k++) {

			parques.getZonaUnoBut()[1][k].setBackground(uno);

		}

		for (int k = 0; k < parques.getZonaDosBut().length; k++) {

			parques.getZonaDosBut()[k][1].setBackground(dos);

		}

		for (int k = 0; k < parques.getZonaTresBut()[0].length; k++) {

			parques.getZonaTresBut()[1][k].setBackground(tres);

		}

		for (int k = 0; k < parques.getZonaCuatroBut().length; k++) {

			parques.getZonaCuatroBut()[k][1].setBackground(cuatro);

		}

		// Casillas Seguro

		parques.getZonaUnoBut()[1][0].setBackground(Color.DARK_GRAY);

		parques.getZonaUnoBut()[0][4].setBackground(Color.DARK_GRAY);

		parques.getZonaDosBut()[3][0].setBackground(Color.DARK_GRAY);

		parques.getZonaDosBut()[7][1].setBackground(Color.DARK_GRAY);

		parques.getZonaTresBut()[1][7].setBackground(Color.DARK_GRAY);

		parques.getZonaTresBut()[2][3].setBackground(Color.DARK_GRAY);

		parques.getZonaCuatroBut()[0][1].setBackground(Color.DARK_GRAY);

		parques.getZonaCuatroBut()[4][2].setBackground(Color.DARK_GRAY);

		// Fin Casillas Seguro

		// Se pintan las casillas salida de los equipos

		parques.getZonaUnoBut()[2][4].setBackground(uno);

		parques.getZonaDosBut()[3][2].setBackground(dos);

		parques.getZonaTresBut()[0][3].setBackground(tres);

		parques.getZonaCuatroBut()[4][0].setBackground(cuatro);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(butJugar)) {

			parques = new PanelParques(this);

			if (coloresJugadores[0].getColor() != Color.WHITE && coloresJugadores[1].getColor() != Color.WHITE
					&& coloresJugadores[2].getColor() != Color.WHITE && coloresJugadores[3].getColor() != Color.WHITE) {

				personalizarParques(butsColores[0].getBackground(), butsColores[1].getBackground(),
						butsColores[2].getBackground(), butsColores[3].getBackground());

				window.remove(this);
				window.add(parques);
				window.setSize(1400, 1000);
				window.refresh();

			} else {

				JOptionPane.showMessageDialog(null, "Todos los jugadores deben escoger un color", "Error",
						JOptionPane.ERROR_MESSAGE);

			}

		} else if (e.getSource().equals(butsColores[0])) {

			dialogsColores[0].setVisible(true);

		} else if (e.getSource().equals(butsColores[1])) {

			dialogsColores[1].setVisible(true);

		} else if (e.getSource().equals(butsColores[2])) {

			dialogsColores[2].setVisible(true);

		} else if (e.getSource().equals(butsColores[3])) {

			dialogsColores[3].setVisible(true);

		} else if (e.getSource().equals(butsEscogerColor[0])) {

			dialogsColores[0].dispose();

		} else if (e.getSource().equals(butsEscogerColor[1])) {

			dialogsColores[1].dispose();

		} else if (e.getSource().equals(butsEscogerColor[2])) {

			dialogsColores[2].dispose();

		} else if (e.getSource().equals(butsEscogerColor[3])) {

			dialogsColores[3].dispose();

		}

	}
}
