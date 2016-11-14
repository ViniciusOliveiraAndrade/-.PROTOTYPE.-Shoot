package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class TelaInfo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField serverIpField;
	private JTextField portField;

	private JTextArea areaInfo;
	
	public TelaInfo(String ip, int port) {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JPanel painelStatos = new JPanel();
		painelStatos.setBorder(new LineBorder(Color.LIGHT_GRAY));
		painelStatos.setBounds(10, 11, 424, 44);
		getContentPane().add(painelStatos);
		painelStatos.setLayout(null);
		
		JLabel lblServerIp = new JLabel("Server IP:");
		lblServerIp.setBounds(10, 11, 55, 14);
		painelStatos.add(lblServerIp);
		
		serverIpField = new JTextField();
		serverIpField.setEditable(false);
		serverIpField.setBounds(69, 8, 109, 20);
		painelStatos.add(serverIpField);
		serverIpField.setColumns(10);
		serverIpField.setText(ip);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(236, 14, 46, 14);
		painelStatos.add(lblPort);
		
		portField = new JTextField();
		portField.setEditable(false);
		portField.setBounds(265, 11, 69, 20);
		painelStatos.add(portField);
		portField.setColumns(10);
		portField.setText(""+port);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 66, 424, 185);
		getContentPane().add(scrollPane);
		
		areaInfo = new JTextArea();
		areaInfo.setEditable(false);
		areaInfo.setBackground(Color.BLACK);
		areaInfo.setForeground(Color.GREEN);
		scrollPane.setViewportView(areaInfo);
		
		setTitle("Server Information");
		setSize(450,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	
	}

	public void trocaVisibilidade(){
		setVisible(!isVisible());
	}
	
	public void setServerIpField(String serverIpField) {
		this.serverIpField.setText(serverIpField);
	}

	public void setPortField(String portField) {
		this.portField.setText(portField);
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo.append("\n"+areaInfo);
	}
	
	
}
