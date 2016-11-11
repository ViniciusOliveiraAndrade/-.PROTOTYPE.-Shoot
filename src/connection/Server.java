package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Main.Main;
import model.Inimigo;
import model.Personagem;
import view.TelaFaseHost;

public class Server extends Thread{

	private ServerSocket serverSocket;

	private Socket socket;

	private static ObjectOutputStream objectOutPS = null;

	private static ObjectInputStream objectInPS = null;

	private int port;

	public Server(int port) {
		this.port = port;
	}

	public void run() {
		try {

			serverSocket = new ServerSocket(port);

			Main.telaInfo.setAreaInfo("Server Criado");

		} catch (IOException e) {
			e.printStackTrace();

		}

		Main.telaInfo.setAreaInfo("Esperando Adiversário");

		try {

			socket = serverSocket.accept();

			Main.telaInfo.setAreaInfo("Conectando com: " +socket.getLocalAddress().getHostAddress());
			Main.telaInfo.setAreaInfo("Adversario Conectado com sucesso;");

			new TelaFaseHost(true);


		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			objectInPS = new ObjectInputStream(socket.getInputStream());
			objectOutPS = new ObjectOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		Loop loop = new Loop();
		loop.start();
		
		super.run();
	}

	public ObjectOutputStream getObjectOutPS() {
		return objectOutPS;
	}

	public ObjectInputStream getObjectInPS() {
		return objectInPS;
	}

	public class Loop extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					
					Inimigo inimigoRecebido = (Inimigo) objectInPS.readObject();
					
					if(inimigoRecebido!=null){
						Main.inimigo = inimigoRecebido;
						System.out.println("INIMIGO RECEBIDO");
						System.out.println("inimigo Y :"+inimigoRecebido.getY()+"\n");
					}else {System.out.println("INIMIGO NÃO RECEBIDO\n\n");}
					
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

					Personagem personagemEnviar = Main.personagem;
					System.out.println("Personagem Enviar Tem Posição Y Igual a ="+personagemEnviar.getY()+"\n\n" );

					objectOutPS.writeObject(personagemEnviar);
					objectOutPS.flush();
					objectOutPS.reset();
					
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void atualizarDadosServer(Personagem personagem){
		try {
			
		Inimigo inimigoRecebido = (Inimigo) objectInPS.readObject();
		
		if(inimigoRecebido!=null){
			Main.inimigo = inimigoRecebido;
			System.out.println("INIMIGO RECEBIDO");
			System.out.println("inimigo Y :"+inimigoRecebido.getY()+"\n");
		}else {System.out.println("INIMIGO NÃO RECEBIDO\n\n");}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Personagem personagemEnviar = personagem;
		System.out.println("Personagem Enviar Tem Posição Y Igual a ="+personagemEnviar.getY()+"\n\n" );

		objectOutPS.writeObject(personagemEnviar);
		objectOutPS.flush();
		objectOutPS.reset();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
