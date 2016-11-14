package view;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import control.ControleTelaHost;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaHost extends JFrame{
	private static final long serialVersionUID = 1L;

	private String ip = "";
	
	private JTextField portField;
	
	private JLabel portLabel;
	
	private JButton connectButton;
	private JButton backButton;
	
	private ControleTelaHost controleTelaHost;
	
	public TelaHost() {

		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Não há conexão com a internet ou não foi possivel encontrar o IP");
		} 
		
		
	setTitle("Servidor - "+ ip);
	getContentPane().setLayout(null);
	
	portLabel = new JLabel("Port:");
	portLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	portLabel.setBounds(10, 11, 38, 23);
	getContentPane().add(portLabel);
	
	portField = new JTextField();
	portField.addKeyListener(new KeyAdapter() {
        public void keyTyped(KeyEvent ev) {
            String caracteres = "0987654321";
            if (!caracteres.contains(ev.getKeyChar() + "")) {
                ev.consume();
            }
        }
    });
	portField.setBounds(47, 14, 109, 20);
	getContentPane().add(portField);
	portField.setColumns(10);
	portField.setText("25255");
	
	connectButton = new JButton("Connect");
	connectButton.setBounds(166, 13, 89, 23);
	getContentPane().add(connectButton);
	
	backButton = new JButton("Back");
	backButton.setBounds(265, 13, 69, 23);
	getContentPane().add(backButton);
	
	controleTelaHost = new ControleTelaHost(this);
	
	connectButton.addActionListener(controleTelaHost);
	backButton.addActionListener(controleTelaHost);
	
	
	setSize(360,85);
	setIconImage(new ImageIcon(getClass().getResource("/Icon.png")).getImage());
	setResizable(false);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	setUndecorated(true);
	setVisible(true);
	
	}

	public int getPortField() {
		return Integer.parseInt(portField.getText());
	}

	public void setPortField(JTextField portField) {
		this.portField = portField;
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public JButton getBackButton() {
		return backButton;
	}

	public String getIp() {
		return ip;
	}
	
	
	
	
	
}
