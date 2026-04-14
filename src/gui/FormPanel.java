package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	

	private JTextField titleField;
	private JButton addBookButton;
	
	
	
	/**
	 * Create the panel.
	 */
	public FormPanel() {
		titleField = new JTextField(15);
		addBookButton = new JButton("Add Book");
		
		add(titleField);
		add(addBookButton);		
	}
	
	
	
	public String getTitleInput() {
		return titleField.getText();
	}
	
	
	
	public void addAddBookListener(ActionListener listener) {
		addBookButton.addActionListener(listener);
	}

}
