package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel implements ActionListener {

	private MainWindow window;
	private JButton butJugar;
	private PanelParques parques;

	public PanelInicio(MainWindow window) {

		this.window = window;

		setLayout(new BorderLayout());

		butJugar = new JButton("JUGAR");
		butJugar.addActionListener(this);

		add(butJugar, BorderLayout.SOUTH);

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
	
		if(e.getSource().equals(butJugar)) {
			
		parques = new PanelParques(this);	
			
		window.remove(this);
		window.add(parques);
		window.setSize(1400,1000);
		window.refresh();
			
		}
		
		
	}

}
