package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	

	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1450, 800);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	
}
