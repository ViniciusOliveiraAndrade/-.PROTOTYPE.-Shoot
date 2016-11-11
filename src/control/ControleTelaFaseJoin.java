package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Main.Main;
import view.TelaFaseJoin;

public class ControleTelaFaseJoin implements ActionListener{

		private TelaFaseJoin telaFaseJoin;
		private Timer time;
		
		public ControleTelaFaseJoin(TelaFaseJoin telaFaseJoin) {
			this.telaFaseJoin = telaFaseJoin;
			time = new Timer(10, this);
			time.start();
		}

		public void actionPerformed(ActionEvent e) {
			telaFaseJoin.getPainelUsuario().setHp(Main.personagem.getHp());
			telaFaseJoin.getPainelInimigo().setHp(Main.inimigo.getHp());
		}
}
