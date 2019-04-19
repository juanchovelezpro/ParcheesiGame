package view;

import javax.swing.*;

import model.Parques;
import tools.ResourceLoader;

import java.awt.*;

public class MainWindow extends JFrame {

	private Parques parquesGame;
	private PanelInicio inicio;

	public MainWindow() {

		setTitle("Parcheesi Game");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
		setResizable(false);

		setIconImage(ResourceLoader.loadImage("/logo.png"));
		
		parquesGame = new Parques();
		inicio = new PanelInicio(this);

		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception ex) {

			ex.printStackTrace();

		}

		add(inicio, BorderLayout.CENTER);

	}

	public Parques getParquesGame() {
		return parquesGame;
	}

	public void setParquesGame(Parques parquesGame) {
		this.parquesGame = parquesGame;
	}

	public void refresh() {

		invalidate();
		revalidate();
		repaint();

	}

	public static void main(String[] args) {

		MainWindow game = new MainWindow();

		game.setVisible(true);

	}

}
