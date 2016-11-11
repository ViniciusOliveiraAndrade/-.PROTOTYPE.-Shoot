package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Main.Main;
import view.TelaFaseHost;

public class ControleTelaFaseHost implements ActionListener{

	private TelaFaseHost telaFaseHost;
	private Timer time;
	
	public ControleTelaFaseHost(TelaFaseHost telaFaseHost) {
		this.telaFaseHost = telaFaseHost;
		time = new Timer(10, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		telaFaseHost.getPainelUsuario().setHp(Main.personagem.getHp());
		telaFaseHost.getPainelInimigo().setHp(Main.inimigo.getHp());
	}

}
