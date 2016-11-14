package view;

import javax.swing.JFrame;

import control.ControleTelaInicio;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class TelaInicio extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton hostButton;
	private JButton joinButton;
	private JButton exitButton;
	
	private ControleTelaInicio controleTelaInicio;
	
	public TelaInicio() {
		
		setResizable(false);
		setSize(130,122);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		hostButton = new JButton("Host");
		hostButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(hostButton);
		
		joinButton = new JButton("Join");
		joinButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(joinButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(exitButton);
		
		controleTelaInicio = new ControleTelaInicio(this);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
	}

	public JButton getHostButton() {
		return hostButton;
	}

	public JButton getJoinButton() {
		return joinButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public ControleTelaInicio getControleTelaInicio() {
		return controleTelaInicio;
	}
	
	
}
