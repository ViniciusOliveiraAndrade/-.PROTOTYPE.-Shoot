package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.ControleTelaJoin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class TelaJoin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField ipField;
	private JTextField portField;
	
	private JLabel ipLabel;
	private JLabel portLabel;
	
	private JButton conectarButton;
	private JButton backButton;
	
	private ControleTelaJoin controleTelaJoin;
	
	public TelaJoin() {
		setTitle("Join");
		getContentPane().setLayout(null);
		
		ipLabel = new JLabel("IP:");
		ipLabel.setBounds(10, 11, 14, 14);
		getContentPane().add(ipLabel);
		
		ipField = new JTextField();
		ipField.setBounds(28, 8, 167, 20);
		getContentPane().add(ipField);
		ipField.setColumns(10);
		
		portLabel = new JLabel("Port:");
		portLabel.setBounds(10, 36, 30, 14);
		getContentPane().add(portLabel);
		
		portField = new JTextField();
		portField.setBounds(40, 33, 86, 20);
		getContentPane().add(portField);
		portField.setColumns(10);
		portField.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent ev) {
	            String caracteres = "0987654321";
	            if (!caracteres.contains(ev.getKeyChar() + "")) {
	                ev.consume();
	            }
	        }
	    });
		
		conectarButton = new JButton("Connect");
		conectarButton.setBounds(104, 78, 89, 23);
		getContentPane().add(conectarButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(10, 78, 89, 23);
		getContentPane().add(backButton);
		
		controleTelaJoin = new ControleTelaJoin(this);
		
		conectarButton.addActionListener(controleTelaJoin);
		backButton.addActionListener(controleTelaJoin);
		
		setSize(220,150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public String getIpField() {
		return ipField.getText();
	}

	public int getPortField() {
		return Integer.parseInt(portField.getText());
	}

	public JButton getConectarButton() {
		return conectarButton;
	}

	public JButton getBackButton() {
		return backButton;
	}
	
	
	
}
