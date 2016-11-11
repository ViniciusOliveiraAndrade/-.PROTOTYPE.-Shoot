package view;

import javax.swing.JFrame;

import Main.Main;
import control.ControlePersonagem;
import control.ControleTelaFaseHost;

public class TelaFaseHost extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private FaseHost faseHost;
	
	private PainelInformacao painelUsuario;
	private PainelInformacao painelInimigo;
	
	private ControlePersonagem controlePersonagem;
	
	private ControleTelaFaseHost controleTelaFaseHost;
	
	private boolean host;
	
	public ControleTelaFaseHost getControleTelaFaseHost() {
		return controleTelaFaseHost;
	}

	public TelaFaseHost(boolean host) {
		getContentPane().setLayout(null);
		
		painelUsuario = new PainelInformacao();
		painelUsuario.setLocation(0, 0);
		
		faseHost = new FaseHost();
		faseHost.setLocation(0, 171);
		
		controlePersonagem = new ControlePersonagem(Main.personagem);
		addKeyListener(controlePersonagem);
		
		painelInimigo = new PainelInformacao();
		painelInimigo.setLocation(0, 529);
		
		controleTelaFaseHost = new ControleTelaFaseHost(this);
		
		getContentPane().add(painelUsuario);
		getContentPane().add(faseHost);
		getContentPane().add(painelInimigo);
		
		setSize(1124,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		
	}

	public FaseHost getFase() {
		return faseHost;
	}

	public PainelInformacao getPainelUsuario() {
		return painelUsuario;
	}

	public PainelInformacao getPainelInimigo() {
		return painelInimigo;
	}

	public boolean isHost() {
		return host;
	}

}
