package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import Main.Main;
import connection.Cliente;
import connection.Server;
import view.Fase;


public class ControleFase  implements ActionListener{

	private Fase fase;
	private Timer time;

	public ControleFase(Fase fase) {
		this.fase = fase;
		time = new Timer(10, this);
		time.start();
	}

	public void checarVencedor(){

		if(Main.inimigo.getHp()<=0){
			if(fase.isHost()){
				Server.enviarPersonagem();
				Server.fecharConexao();
				Main.telaInfo.setAreaInfo("Tank Verde Venceu");
			}else{
				Cliente.enviarInimigo();
//				Cliente.fecharConexao();
				Main.telaInfo.setAreaInfo("Tank Verde Venceu");
			}

			JOptionPane.showMessageDialog(fase, "Tank Verde Venceu");
			if(fase.isHost()){Server.enviarPersonagem();}else{Cliente.enviarInimigo();}
			System.exit(0);
		}


		if(Main.personagem.getHp()<=0){
			if(fase.isHost()){
				Server.enviarPersonagem();
				Server.fecharConexao();
				Main.telaInfo.setAreaInfo("Tank Azul Venceu");
			}else{
				Cliente.enviarInimigo();
//				Cliente.fecharConexao();
				Main.telaInfo.setAreaInfo("Tank Azul Venceu");
			}

			JOptionPane.showMessageDialog(fase, "Tank Azul Venceu");
			if(fase.isHost()){Server.enviarPersonagem();}else{Cliente.enviarInimigo();}
			System.exit(0);
		}
	}

	public void actionPerformed(ActionEvent e) {
		checarVencedor();
		fase.repaint();
	}

}