package view;

import javax.swing.JFrame;

import Main.Main;
import control.ControleInimigo;
import control.ControleTelaFaseJoin;

public class TelaFaseJoin extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private FaseJoin faseJoin;
	
	private PainelInformacao painelUsuario;
	private PainelInformacao painelInimigo;
	
	private ControleInimigo controleInimigo;
	
	private ControleTelaFaseJoin controleTelaFaseJoin;
	
	private boolean host;
	
	public TelaFaseJoin(boolean host) {
		getContentPane().setLayout(null);
		
		painelUsuario = new PainelInformacao();
		painelUsuario.setLocation(0, 0);
		
		faseJoin = new FaseJoin();
		faseJoin.setLocation(0, 171);
		
		controleInimigo = new ControleInimigo(Main.inimigo);

		painelInimigo = new PainelInformacao();
		painelInimigo.setLocation(0, 529);
		
		controleTelaFaseJoin = new ControleTelaFaseJoin(this);
		
		getContentPane().add(painelUsuario);
		getContentPane().add(faseJoin);
		getContentPane().add(painelInimigo);
		
		addKeyListener(controleInimigo);
		
		setSize(1124,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		
	}

	public ControleTelaFaseJoin getControleTelaFaseJoin() {
		return controleTelaFaseJoin;
	}

	public FaseJoin getFase() {
		return faseJoin;
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
