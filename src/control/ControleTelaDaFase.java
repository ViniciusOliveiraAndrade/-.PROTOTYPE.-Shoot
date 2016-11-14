package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Timer;

import Main.Main;
import connection.Cliente;
import connection.Server;
import view.TelaDaFase;

public class ControleTelaDaFase implements ActionListener, WindowListener{

	private TelaDaFase telaDaFase;
	private Timer time;

	public ControleTelaDaFase(TelaDaFase telaDaFase) {
		this.telaDaFase = telaDaFase;
		time = new Timer(10, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		telaDaFase.getPainelUsuario().setHp(Main.personagem.getHp());
		telaDaFase.getPainelInimigo().setHp(Main.inimigo.getHp());
	}

	public void windowActivated(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {
		try {
//			Server.fecharConexao();
			System.exit(0);
		} catch (Exception e2) {
//			Cliente.fecharConexao();
			System.exit(0);
		}
		System.exit(0);
	}

	public void windowClosing(WindowEvent e) {
		try {
//			Server.fecharConexao();
			System.exit(0);
		} catch (Exception e2) {
//			Cliente.fecharConexao();
			System.exit(0);
		}
		System.exit(0);
	
	}

	public void windowDeactivated(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowOpened(WindowEvent e) {}

}
