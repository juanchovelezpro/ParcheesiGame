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

		for (int i = 1; i < 5; i++) {

			butsColores[i - 1] = new JButton("COLOR");
			butsColores[i - 1].setFont(new Font("Garamond", 1, 20));
			butsColores[i - 1].addActionListener(this);

			labsJugadores[i - 1] = new JLabel("Jugador #" + i);
			labsJugadores[i - 1].setFont(new Font("Garamond", 1, 20));
			labsJugadores[i - 1].setHorizontalAlignment(SwingConstants.CENTER);

			txtNombres[i - 1] = new JTextField();
			coloresJugadores[i - 1] = new JColorChooser();
			dialogsColores[i - 1] = new JDialog(window, "Escoge un color");

			dialogsColores[i - 1].add(coloresJugadores[i - 1]);
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

			if (coloresJugadores[i].getColor() != null) {

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

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(butJugar)) {

			parques = new PanelParques(this);

			window.remove(this);
			window.add(parques);
			window.setSize(1400, 1000);
			window.refresh();

		} else if (e.getSource().equals(butsColores[0])) {

			dialogsColores[0].setVisible(true);

		} else if (e.getSource().equals(butsColores[1])) {

			dialogsColores[1].setVisible(true);

		} else if (e.getSource().equals(butsColores[2])) {

			dialogsColores[2].setVisible(true);

		} else if (e.getSource().equals(butsColores[3])) {

			dialogsColores[3].setVisible(true);

		}

	}

}
