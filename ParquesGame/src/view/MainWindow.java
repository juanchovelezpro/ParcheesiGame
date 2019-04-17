package view;


import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

	public MainWindow() {
		
	setTitle("Parques Game");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(1250, 780);
	
	
		
	}

	public static void main(String[] args) {
		
		MainWindow game = new MainWindow();
		
		game.setVisible(true);

	}

}
