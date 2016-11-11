package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.Main;
import control.ControleDasFasesHJ;

public class FaseHost extends JPanel{

	private static final long serialVersionUID = 1L;

	private ControleDasFasesHJ controleFaseHost;

	private boolean host;

	private ArrayList<Point> tirosInimigo;

	public FaseHost() {

		controleFaseHost = new ControleDasFasesHJ(this);

		setSize(1124,358);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));

	}

	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLUE);
		g.fillRect(Main.personagem.getX(), Main.personagem.getY(), Main.personagem.getArea().width, Main.personagem.getArea().height);

		for(Point ponto : Main.personagem.getTirosUsuario()){
			g.fillOval(ponto.x, ponto.y, 10, 10);
		}

		g.setColor(Color.RED);
		g.fillRect(Main.inimigo.getX(), Main.inimigo.getY(), Main.inimigo.getArea().width, Main.inimigo.getArea().height);

		for(Point ponto : Main.inimigo.getTirosInimigo()){
			g.fillOval(ponto.x, ponto.y, 10, 10);
		}
	}


	public ControleDasFasesHJ getControleFaseHost() {
		return controleFaseHost;
	}

	public boolean isHost() {
		return host;
	}

	public ArrayList<Point> getTirosInimigo() {
		return tirosInimigo;
	}



}
