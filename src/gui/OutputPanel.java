package gui;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import data.LibraryItem;

public class OutputPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea outputArea;
	
	

	/**
	 * Create the panel.
	 */
	public OutputPanel() {
		outputArea = new JTextArea(20, 50);
		outputArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(outputArea);
		
		add(scrollPane);
	}
	
	
	
	public void displayItems(List<LibraryItem> items) {
		outputArea.setText("");
		for(LibraryItem item : items) {
			outputArea.append(item.getDescription() + "\n");
		}
	}
	
	
}
