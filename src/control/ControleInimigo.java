package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import model.Inimigo;

public class ControleInimigo extends KeyAdapter implements ActionListener{

	private Inimigo inimigo;
	private Timer time;
	public ControleInimigo(Inimigo inimigo) {
		this.inimigo = inimigo;
		time = new Timer(10, this);
		time.start();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			inimigo.setY(inimigo.getY()+4);

			if(inimigo.getY()>314){
				inimigo.setY(inimigo.getY()-4);
			}
		}

		if (e.getKeyCode()==KeyEvent.VK_UP){
			inimigo.setY(inimigo.getY()-4);
			if(inimigo.getY()<5){
				inimigo.setY(inimigo.getY()+4);
			}
		}
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			inimigo.getTirosInimigo().add(new Point(inimigo.getX()-10, inimigo.getY()+14));
		}
	}

	public void moverTiros(){

		if (inimigo.getTirosInimigo()!=null){
			try {
				for(Point pontos : inimigo.getTirosInimigo()){
					pontos.x=pontos.x - 4;
				}
			} catch (Exception e) {
				moverTiros();
			}

			try {
				for(int i = 0 ; i < inimigo.getTirosInimigo().size();i++){
					if(inimigo.getTirosInimigo().get(i).x<=0 ){
						inimigo.getTirosInimigo().remove(i);
					}
				}
			} catch (Exception e) {
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		moverTiros();
	}
}
