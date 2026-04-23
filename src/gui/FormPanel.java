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
	
	
	
	// getters
	public int getId() {
		// TODO validation
		return Integer.parseInt(idField.getText());
	}

	
	public String getTitleField() {
		return titleField.getText();
	}

	
	public int getYearField() {
		// TODO validation
		return Integer.parseInt(yearField.getText());
	}

	
	public String getAuthorField() {
		return authorField.getText();
	}


	public String getNarratorField() {
		return narratorField.getText();
	}
	

	public int getDurationField() {
		// TODO validation
		return Integer.parseInt(durationField.getText());
	}


	public String getSearchField() {
		return searchField.getText();
	}


	
	
	public void addBookListener(ActionListener listener) {
		addBookButton.addActionListener(listener);
	}
	
	
	public void addAudioListener(ActionListener listener) {
		addAudioButton.addActionListener(listener);
	}

	
	public void addSearchListener(ActionListener listener) {
		searchButton.addActionListener(listener);
	}
	
	

}