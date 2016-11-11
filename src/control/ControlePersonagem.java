package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import model.Personagem;

public class ControlePersonagem extends KeyAdapter implements ActionListener{
	
	private Personagem personagem;
	private Timer time;
	public ControlePersonagem(Personagem personagem) {
		this.personagem = personagem;
		time = new Timer(10, this);
		time.start();
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			personagem.setY(personagem.getY()+4);
			
			if(personagem.getY()>314){
				personagem.setY(personagem.getY()-4);
			}
		}
		
		if (e.getKeyCode()==KeyEvent.VK_UP){
			personagem.setY(personagem.getY()-4);
			
			if(personagem.getY()<5){
				personagem.setY(personagem.getY()+4);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			personagem.getTirosUsuario().add(new Point(personagem.getX()+40, personagem.getY()+14));
		}
	}

	public void moverTiros(){
		
		if (personagem.getTirosUsuario()!=null){
			try {
				for(Point pontos : personagem.getTirosUsuario()){
					pontos.x=pontos.x + 4;
				}
			} catch (Exception e) {
				moverTiros();
			}
			
			try {
				for(int i = 0 ; i < personagem.getTirosUsuario().size();i++){
					if(personagem.getTirosUsuario().get(i).x>=1110 ){
						personagem.getTirosUsuario().remove(i);
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
