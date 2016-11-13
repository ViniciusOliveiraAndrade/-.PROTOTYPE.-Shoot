package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import Main.Main;
import connection.Server;
import model.Personagem;

public class ControlePersonagem extends KeyAdapter implements ActionListener{

	private Personagem personagem;
	private Timer time;
	public ControlePersonagem(Personagem personagem) {
		this.personagem = personagem;
		time = new Timer(10, this);
		time.start();
	}

	public void checarDano(){
		try {
			for(int i = 0 ; i < Main.inimigo.getTirosInimigo().size();i++){
				if(personagem.getArea().intersects(Main.inimigo.getTirosInimigo().get(i).getX(),Main.inimigo.getTirosInimigo().get(i).getY(),10,10) ){
					Main.inimigo.getTirosInimigo().remove(i);
					
					personagem.dano();
					
					System.out.println("Vermelho Acertou");
					
					Server.enviarPersonagem();
				}
			}
		} catch (Exception e) {}
	}

	public void checarDanoInimigo(){
		try {
			for(int i = 0 ; i < personagem.getTirosUsuario().size();i++){
				if(Main.inimigo.getArea().intersects(personagem.getTirosUsuario().get(i).getX(),personagem.getTirosUsuario().get(i).getY(),10,10)){
					personagem.getTirosUsuario().remove(i);		
					System.out.println("Azul Acertou");
					Server.enviarPersonagem();
				
				}
			}
		} catch (Exception e) {}
		
	}
	
	public void moverTiros(){
		/**
		 * Move os tiros do Personagem (bloco Azul)
		 */
		if (personagem.getTirosUsuario()!=null){
			try {
				for(Point pontos : personagem.getTirosUsuario()){
					pontos.x=pontos.x + 4;
				}
				
			} catch (Exception e) {
				moverTiros();
			}
			Server.enviarPersonagem();
			try {
				for(int i = 0 ; i < personagem.getTirosUsuario().size();i++){
					//Era x >= 1110
					if(personagem.getTirosUsuario().get(i).x>=1110 ){
						personagem.getTirosUsuario().remove(i);
						Server.enviarPersonagem();
					}
				}
			} catch (Exception e) {
			}
		}

		/**
		 * Move os tiros do inimigo (Bloco Vermelho)
		 */
//		if (Main.inimigo.getTirosInimigo()!=null){
//			try {
//				for(Point pontos : Main.inimigo.getTirosInimigo()){
//					pontos.x=pontos.x - 4;
//				}
//			} catch (Exception e) {
//				moverTiros();
//			}
//
//			try {
//				for(int i = 0 ; i < Main.inimigo.getTirosInimigo().size();i++){
//					if(Main.inimigo.getTirosInimigo().get(i).x<=0 ){
//						Main.inimigo.getTirosInimigo().remove(i);
//					}
//				}
//			} catch (Exception e) {
//			}
//		}
		
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_DOWN){
			personagem.setY(personagem.getY()+4);

			if(personagem.getY()>314){
				personagem.setY(personagem.getY()-4);
			}

			Server.enviarPersonagem();
		}

		if (e.getKeyCode()==KeyEvent.VK_UP){
			personagem.setY(personagem.getY()-4);

			if(personagem.getY()<5){
				personagem.setY(personagem.getY()+4);
			}
			Server.enviarPersonagem();
		}
	}

	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			personagem.getTirosUsuario().add(new Point(personagem.getX()+40, personagem.getY()+14));

			Server.enviarPersonagem();
		}
	}

	public void actionPerformed(ActionEvent e) {
		checarDanoInimigo();
		moverTiros();
		checarDano();
	}
}
