package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import Main.Main;
import model.Inimigo;
import model.Personagem;
import view.TelaDaFase;

public class Cliente extends Thread{

	private static Socket socket;

	private static ObjectOutputStream objectOutPS;

	private static ObjectInputStream objectInPS;

	private int port;

	private String ip;

	public Cliente(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}


	public void run() {
		try {
			socket = new Socket(ip, port);
			System.out.println("foi_1");
			objectOutPS = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("foi_2");
			objectInPS = new ObjectInputStream(socket.getInputStream());
			System.out.println("foi_3");


		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Completo");

		new TelaDaFase(false);
		Loop loop = new Loop();
		loop.start();

		super.run();
	}


	public class Loop extends Thread{
		@Override
		public void run() {
			while (true){
				try {
					if(socket.isConnected()){
						Personagem personagemRecebido = (Personagem) objectInPS.readObject();
						if(personagemRecebido!=null){
							Main.personagem = personagemRecebido;
							System.out.println("---------------------------------------------------------------------");
							System.out.println("PERSONAGEM RECEBIDO");
							System.out.println("X :"+personagemRecebido.getX());
							System.out.println("Y :"+personagemRecebido.getY());
							System.out.println("HP :"+personagemRecebido.getHp());
							System.out.println("---------------------------------------------------------------------"+"\n\n");
						}
					}else{
						Main.telaInfo.setAreaInfo("Adversario Desconectado");
						JOptionPane.showMessageDialog(null, "Adversario Desconectado");
//						fecharConexao();
						System.exit(0);
					}

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
//					fecharConexao();
				}
			}
		}
	}

	public static void enviarInimigo(){
		Inimigo inimigoEnviar = Main.inimigo;
		System.out.println("---------------------------------------------------------------------");
		System.out.println("INIMIGO ENVIAR");
		System.out.println("X :"+inimigoEnviar.getX());
		System.out.println("Y :"+inimigoEnviar.getY());
		System.out.println("HP :" +inimigoEnviar.getHp());
		System.out.println("---------------------------------------------------------------------"+"\n\n");
		try {
			objectOutPS.writeObject(inimigoEnviar);
			objectOutPS.flush();
			objectOutPS.reset();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Não foi possivel enviar o inimigo");
//			fecharConexao();
		}
	}

//	public static void fecharConexao(){
//
//		try {
//			socket.close();
//			objectOutPS.close();
//			objectInPS.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public ObjectOutputStream getDataOutPS() {
		return objectOutPS;
	}

	public ObjectInputStream getDataInPS() {
		return objectInPS;
	}
}