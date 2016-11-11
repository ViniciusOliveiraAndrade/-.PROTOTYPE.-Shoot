package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import Main.Main;
import view.FaseHost;
import view.FaseJoin;


public class ControleDasFasesHJ  implements ActionListener{

	private FaseJoin faseJoin;
	private FaseHost faseHost;
	private Timer time;

	public ControleDasFasesHJ(FaseJoin faseJoin) {
		this.faseJoin = faseJoin;
		time = new Timer(10, this);
		time.start();
	}

	public ControleDasFasesHJ(FaseHost faseHost) {
		this.faseHost = faseHost;
		time = new Timer(10, this);
		time.start();
	}

	public void checarAcerto(){
		try {

			for(int i = 0 ; i < Main.personagem.getTirosUsuario().size();i++){
				if(Main.inimigo.getArea().intersects(Main.personagem.getTirosUsuario().get(i).getX(),Main.personagem.getTirosUsuario().get(i).getY(),10,10)){
					Main.personagem.getTirosUsuario().remove(i);
					Main.inimigo.dano();
					System.out.println("Usuario Acertou");
				}
			}
			for(int i = 0 ; i < Main.inimigo.getTirosInimigo().size();i++){
				if(Main.personagem.getArea().intersects(Main.inimigo.getTirosInimigo().get(i).getX(),Main.inimigo.getTirosInimigo().get(i).getY(),10,10) ){
					Main.inimigo.getTirosInimigo().remove(i);
					Main.personagem.dano();
					System.out.println("Inimigo Acertou");
				}
			}

		} catch (Exception e) {
			checarAcerto();
			System.out.println("erro");
		}

	}

	public void checarVencedor(){
		if(Main.inimigo.getHp()<=0){JOptionPane.showMessageDialog(faseJoin, "Usuario Venceu");System.exit(0);}
		if(Main.personagem.getHp()<=0){JOptionPane.showMessageDialog(faseJoin, "Inimigo Venceu");System.exit(0);}
	}


	public void actionPerformed(ActionEvent e) {
		checarAcerto();
		checarVencedor();

		if(faseJoin != null){
			faseJoin.repaint();
		}else {
			faseHost.repaint();
		}

	}

}
