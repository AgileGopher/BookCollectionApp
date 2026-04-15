package gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
	private JTextField titleField;
	private JTextField yearField;
	private JTextField authorField;
	private JTextField narratorField;
	private JTextField durationField;
	private JTextField searchField;
	
	private JButton addBookButton;
	private JButton addAudioButton;
	private JButton searchButton;
	
	
	
	/**
	 * Create the panel.
	 */
	public FormPanel() {
		
		setLayout(new GridLayout(0, 2));
		
		idField       = new JTextField();
		titleField    = new JTextField();
		yearField     = new JTextField();
		authorField   = new JTextField();
		narratorField = new JTextField();
		durationField = new JTextField();
		searchField   = new JTextField();
		
		addBookButton  = new JButton("Add Book");
		addAudioButton = new JButton("Add Audiobook");
		searchButton   = new JButton("Search");
		
		add(new JLabel("ID:"));
		add(idField);
		
		add(new JLabel("Title:"));
		add(titleField);
		
		add(new JLabel("Year:"));
		add(yearField);
		
		add(new JLabel("Author:"));
		add(authorField);
		
		add(new JLabel("Narrator:"));
		add(narratorField);
		
		add(new JLabel("Duration:"));
		add(durationField);
		
		add(new JLabel("Search:"));
		add(searchField);
		
		add(addBookButton);
		add(addAudioButton);
		add(searchButton);
	}
	
	
	
	
	public JTextField getIdField() {
		return idField;
	}

	
	public JTextField getTitleField() {
		return titleField;
	}

	
	public JTextField getYearField() {
		return yearField;
	}

	
	public JTextField getAuthorField() {
		return authorField;
	}


	public JTextField getNarratorField() {
		return narratorField;
	}
	

	public JTextField getDurationField() {
		return durationField;
	}


	public JTextField getSearchField() {
		return searchField;
	}


	

	public void addAddBookListener(ActionListener listener) {
		addBookButton.addActionListener(listener);
	}

}
