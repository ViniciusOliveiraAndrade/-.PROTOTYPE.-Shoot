package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import connection.Server;
import view.TelaHost;
import view.TelaInfo;
import view.TelaInicio;

public class ControleTelaHost implements ActionListener{
	
	private TelaHost telaHost;
	
	public ControleTelaHost(TelaHost telaHost) {
		
		this.telaHost = telaHost;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==telaHost.getConnectButton()){
			
			Main.telaInfo = new TelaInfo(telaHost.getIp(),telaHost.getPortField());
			
			
			Main.server = new Server(telaHost.getPortField());
			Main.server.start();
			
//			new TelaFaseHost(true);
			telaHost.dispose();
			
		}
		if(e.getSource()==telaHost.getBackButton()){
			new TelaInicio();
			telaHost.dispose();
		}
		
	}
}
