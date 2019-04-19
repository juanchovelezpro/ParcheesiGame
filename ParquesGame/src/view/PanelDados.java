package view;

import javax.swing.*;

import tools.ResourceLoader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDados extends JPanel implements ActionListener{

	private PanelParques parques;
	private JButton butDadoUno;
	private JButton butDadoDos;
	
	
	public PanelDados(PanelParques parques) {
		
	this.parques = parques;	
		
	setLayout(null);
	
	butDadoUno = new JButton();
	butDadoUno.setIcon(new ImageIcon(ResourceLoader.loadImage("/uno.png")));
	butDadoUno.setBounds(120, 95, 100, 100);
	
	butDadoDos = new JButton();
	butDadoDos.setIcon(new ImageIcon(ResourceLoader.loadImage("/dos.png")));
	butDadoDos.setBounds(240,95,100,100);
	
	add(butDadoUno);
	add(butDadoDos);
	
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
	super.paintComponent(g);	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}

	
	
	
	
}
