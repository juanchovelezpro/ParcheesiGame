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

		init();

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

	public void init() {

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

	}

	public void refillZonas() {

		refillZonaUno_ZonaTres();
		refillZonaDos_Cuatro();

	}

	public void refillZonaUno_ZonaTres() {

		Casilla[][] zonaUno = inicio.getWindow().getParquesGame().getZonaUno();

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

	public void actualizarZonas(Color fichasUno, Color fichasDos, Color fichasTres, Color fichasCuatro) {

		Casilla[][] zonaUno = inicio.getWindow().getParquesGame().getZonaUno();
		Casilla[][] zonaDos = inicio.getWindow().getParquesGame().getZonaDos();
		Casilla[][] zonaTres = inicio.getWindow().getParquesGame().getZonaTres();
		Casilla[][] zonaCuatro = inicio.getWindow().getParquesGame().getZonaCuatro();

		actualizarZona(zonaUno, fichasUno, fichasDos, fichasTres, fichasCuatro);
		actualizarZona(zonaDos, fichasUno, fichasDos, fichasTres, fichasCuatro);
		actualizarZona(zonaTres, fichasUno, fichasDos, fichasTres, fichasCuatro);
		actualizarZona(zonaCuatro, fichasUno, fichasDos, fichasTres, fichasCuatro);

	}

	public void actualizarZona(Casilla[][] zona, Color fichasUno, Color fichasDos, Color fichasTres,
			Color fichasCuatro) {

		boolean isUno = false;
		boolean isDos = false;
		boolean isTres = false;
		boolean isCuatro = false;

		// Para dejar casillas con el color predeterminado
		Color normal = zonaUnoBut[0][0].getComponent(0).getBackground();
		JButton[][] zonaBut = null;

		// Conocer que zona es para actualizar la correspondiente en la interfaz.
		switch (zona[0][0].getPosicion()) {

		case 83:
			zonaBut = zonaUnoBut;
			isUno = true;
			break;

		case 4:
			zonaBut = zonaDosBut;
			isDos = true;
			break;

		case 51:
			zonaBut = zonaTresBut;
			isTres = true;
			break;

		case 68:
			zonaBut = zonaCuatroBut;
			isCuatro = true;
			break;

		}

		for (int i = 0; i < zona.length; i++) {
			for (int j = 0; j < zona[0].length; j++) {
				for (int k = 0; k < zona[i][j].getFichas().length; k++) {

					if (zona[i][j].getFichas()[k] != null) {

						switch (zona[i][j].getFichas()[k].getTipo()) {

						case 1:

							zonaBut[i][j].getComponent(k).setBackground(fichasUno.darker().darker());

							break;

						case 2:

							zonaBut[i][j].getComponent(k).setBackground(fichasDos.darker().darker());

							break;

						case 3:

							zonaBut[i][j].getComponent(k).setBackground(fichasTres.darker().darker());

							break;

						case 4:

							zonaBut[i][j].getComponent(k).setBackground(fichasCuatro.darker().darker());

							break;

						}

					} else {

						zonaBut[i][j].getComponent(k).setBackground(normal);

					}

				}

			}

		}

		// Asignar la auxiliar zonaBut a la zona correspondiente para actualizar la
		// interfaz.
		if (isUno) {

			zonaUnoBut = zonaBut;

		} else if (isDos) {

			zonaDosBut = zonaBut;

		} else if (isTres) {

			zonaTresBut = zonaBut;

		} else if (isCuatro) {

			zonaCuatroBut = zonaBut;

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
