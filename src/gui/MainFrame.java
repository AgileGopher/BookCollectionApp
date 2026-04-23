package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
			
			String title = formPanel.getTitleField();
			
			if(title == null || title.isBlank()) {
				JOptionPane.showMessageDialog(this, "Enter a title");
				return;
			}
			
			Book book = new Book(1001, title, 2000, "Unknown");
			manager.addItem(book);
			
			outputPanel.displayItems(manager.getItems());
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
