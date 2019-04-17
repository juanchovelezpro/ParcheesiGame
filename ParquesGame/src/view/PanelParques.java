package view;

import javax.swing.*;

import model.Casilla;

import java.awt.*;

public class PanelParques extends JPanel {

	private PanelInicio inicio;

	private JButton[][] zonaUnoBut;
	private JButton[][] zonaDosBut;
	private JButton[][] zonaTresBut;
	private JButton[][] zonaCuatroBut;

	private JPanel panelZonaUno;
	private JPanel panelZonaDos;
	private JPanel panelZonaTres;
	private JPanel panelZonaCuatro;

	public PanelParques(PanelInicio inicio) {

		this.inicio = inicio;

		setLayout(new GridLayout(3, 3));

		zonaUnoBut = new JButton[3][8];
		zonaDosBut = new JButton[8][3];
		zonaTresBut = new JButton[3][8];
		zonaCuatroBut = new JButton[8][3];
		
		panelZonaUno = new JPanel();
		panelZonaDos = new JPanel();
		panelZonaTres = new JPanel();
		panelZonaCuatro = new JPanel();

		panelZonaUno.setLayout(new GridLayout(3, 8));
		panelZonaDos.setLayout(new GridLayout(8, 3));
		panelZonaTres.setLayout(new GridLayout(3, 8));
		panelZonaCuatro.setLayout(new GridLayout(8, 3));
		
		refillZonas();

		add(new JLabel());
		add(panelZonaCuatro);
		add(new JLabel());
		add(panelZonaUno);
		add(new JLabel());
		add(panelZonaTres);
		add(new JLabel());
		add(panelZonaDos);
		add(new JLabel());

	}

	public void refillZonas() {
		
	refillZonaUno_ZonaTres();
	refillZonaDos_Cuatro();
		
	}
	
	public void refillZonaUno_ZonaTres() {

		Casilla[][] zonaUno = inicio.getWindow().getParquesGame().getZonaUno();
		Casilla[][] zonaTres = inicio.getWindow().getParquesGame().getZonaTres();

		for (int i = 0; i < zonaUno.length; i++) {

			for (int j = 0; j < zonaUno[0].length; j++) {

				zonaUnoBut[i][j] = new JButton();
				zonaUnoBut[i][j].setLayout(new GridLayout(4, 2));

				zonaTresBut[i][j] = new JButton();
				zonaTresBut[i][j].setLayout(new GridLayout(4, 2));

				for (int k = 0; k < 8; k++) {

					zonaUnoBut[i][j].add(new JButton());
					zonaTresBut[i][j].add(new JButton());

				}

				zonaUnoBut[i][j].setOpaque(true);
				zonaTresBut[i][j].setOpaque(true);

				panelZonaUno.add(zonaUnoBut[i][j]);
				panelZonaTres.add(zonaTresBut[i][j]);

			}

		}

	}

	public void refillZonaDos_Cuatro() {

		Casilla[][] zonaDos = inicio.getWindow().getParquesGame().getZonaDos();
		Casilla[][] zonaCuatro = inicio.getWindow().getParquesGame().getZonaCuatro();

		for (int i = 0; i < zonaDos.length; i++) {

			for (int j = 0; j < zonaDos[0].length; j++) {

				zonaDosBut[i][j] = new JButton();
				zonaDosBut[i][j].setLayout(new GridLayout(2, 4));

				zonaCuatroBut[i][j] = new JButton();
				zonaCuatroBut[i][j].setLayout(new GridLayout(2, 4));

				for (int k = 0; k < 8; k++) {

					zonaDosBut[i][j].add(new JButton());
					zonaCuatroBut[i][j].add(new JButton());

				}

				zonaDosBut[i][j].setOpaque(true);
				zonaCuatroBut[i][j].setOpaque(true);

				panelZonaDos.add(zonaDosBut[i][j]);
				panelZonaCuatro.add(zonaCuatroBut[i][j]);

			}

		}

	}

	public JPanel getPanelZonaUno() {
		return panelZonaUno;
	}

	public void setPanelZonaUno(JPanel panelZonaUno) {
		this.panelZonaUno = panelZonaUno;
	}

	public JPanel getPanelZonaDos() {
		return panelZonaDos;
	}

	public void setPanelZonaDos(JPanel panelZonaDos) {
		this.panelZonaDos = panelZonaDos;
	}

	public JPanel getPanelZonaTres() {
		return panelZonaTres;
	}

	public void setPanelZonaTres(JPanel panelZonaTres) {
		this.panelZonaTres = panelZonaTres;
	}

	public JPanel getPanelZonaCuatro() {
		return panelZonaCuatro;
	}

	public void setPanelZonaCuatro(JPanel panelZonaCuatro) {
		this.panelZonaCuatro = panelZonaCuatro;
	}

	public PanelInicio getInicio() {
		return inicio;
	}

	public void setInicio(PanelInicio inicio) {
		this.inicio = inicio;
	}

	public JButton[][] getZonaUnoBut() {
		return zonaUnoBut;
	}

	public void setZonaUnoBut(JButton[][] zonaUnoBut) {
		this.zonaUnoBut = zonaUnoBut;
	}

	public JButton[][] getZonaDosBut() {
		return zonaDosBut;
	}

	public void setZonaDosBut(JButton[][] zonaDosBut) {
		this.zonaDosBut = zonaDosBut;
	}

	public JButton[][] getZonaTresBut() {
		return zonaTresBut;
	}

	public void setZonaTresBut(JButton[][] zonaTresBut) {
		this.zonaTresBut = zonaTresBut;
	}

	public JButton[][] getZonaCuatroBut() {
		return zonaCuatroBut;
	}

	public void setZonaCuatroBut(JButton[][] zonaCuatroBut) {
		this.zonaCuatroBut = zonaCuatroBut;
	}
}
