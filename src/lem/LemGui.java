package lem;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LemGui extends JFrame {

	private JPanel lem;
	
	public LemGui() {
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	
	protected void initComponents() {
		getContentPane().setLayout(null);
		getContentPane().add(getLemPanel());
	}
	
	public void update(int altitude) {
		lem.setLocation(100, 105 - 2*altitude);
	}

	public JPanel getLemPanel() {
		if (lem == null) {
			lem = new JPanel();
			lem.setBackground(Color.green.darker());
			lem.setSize(10, 10);
		}
		return lem;
	}
	
	

}
