package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Main.Main;
import control.ControleFase;

public class Fase extends JPanel{

	private static final long serialVersionUID = 1L;

	private ControleFase controleFase;

	private boolean host;

	private ArrayList<Point> tirosInimigo;

	private ImageIcon personagemImagem;
	private ImageIcon personagemTiroImagem;
	private ImageIcon inimigoImagem;
	private ImageIcon inimigoTiroImagem;
	private ImageIcon backGroundImagem;

	public Fase(boolean host) {
		this.host = host;
		
		personagemImagem = new ImageIcon(getClass().getResource("/Personagem.png"));
		personagemTiroImagem = new ImageIcon(getClass().getResource("/TiroPersonagem.png"));

		inimigoImagem = new ImageIcon(getClass().getResource("/Inimigo.png"));
		inimigoTiroImagem = new ImageIcon(getClass().getResource("/TiroInimigo.png"));

		backGroundImagem = new ImageIcon(getClass().getResource("/BackGround.png"));

		controleFase = new ControleFase(this);

		setSize(1124,358);
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		
		/**
		 * Desenha BackGround
		 */
		
		g.drawImage(backGroundImagem.getImage(), 0, 0, this);
		
		/**
		 * Desenho do Personagem (Tank Verde)
		 */

		g.drawImage(personagemImagem.getImage(),Main.personagem.getX(), Main.personagem.getY(),null);

		for(Point ponto : Main.personagem.getTirosUsuario()){
			g.drawImage(personagemTiroImagem.getImage(),ponto.x, ponto.y,null);
		}

		/**
		 * Desenho do Inimigo(Tank Azul)
		 */

		g.drawImage(inimigoImagem.getImage(),Main.inimigo.getX(), Main.inimigo.getY(),null);

		for(Point ponto : Main.inimigo.getTirosInimigo()){
			g.drawImage(inimigoTiroImagem.getImage(),ponto.x, ponto.y,null);
		}
	}

	/**
	 * Gets
	 */
	
	public ControleFase getControleFase() {
		return controleFase;
	}

	public boolean isHost() {
		return host;
	}

	public ArrayList<Point> getTirosInimigo() {
		return tirosInimigo;
	}

}