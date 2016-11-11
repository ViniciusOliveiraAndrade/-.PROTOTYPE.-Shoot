package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.CardLayout;

public class PainelInformacao extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel hp;
	
	public PainelInformacao() {
		setLayout(new CardLayout(0, 0));
		
		
		hp = new JLabel("");
		
		add(hp, "name_719582500398");
		
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setSize(1124,171);
	}

	public void setHp(int hp) {
		this.hp.setText(String.valueOf(hp));
	}
	
	
}
