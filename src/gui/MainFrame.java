package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.AudioBook;
import data.Book;
import management.LibraryManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	LibraryManager manager = new LibraryManager();
	private FormPanel formPanel;
	private OutputPanel outputPanel;
	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1450, 800);
		setLocationRelativeTo(null);
		setResizable(false);
				
		manager     = new LibraryManager();
		formPanel   = new FormPanel();
		outputPanel = new OutputPanel();
		
		setLayout(new BorderLayout());
		add(formPanel, BorderLayout.NORTH);
		add(outputPanel, BorderLayout.CENTER);
		
		wireEvents();
	}
	
	
	
	private void wireEvents() {
		
		formPanel.addBookListener(e -> {
			try {
				Book book = new Book(
					formPanel.getId(),
					formPanel.getTitleField(),
					formPanel.getYearField(),
					formPanel.getAuthorField()
				);	
				manager.addItem(book);
				outputPanel.displayItems(manager.getItems());
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		});
		
		
		formPanel.addAudioListener(e -> {
			try {
				AudioBook audio = new AudioBook(
						formPanel.getId(),
						formPanel.getTitleField(),
						formPanel.getYearField(),
						formPanel.getNarratorField(),
						formPanel.getDurationField()
				);
				manager.addItem(audio);
				outputPanel.displayItems(manager.getItems());
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			}	
		});
	}

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
