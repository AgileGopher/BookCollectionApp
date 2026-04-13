package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Book;
import data.LibraryItem;
import management.LibraryManager;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	LibraryManager manager = new LibraryManager();
	

	public static void main(String[] args) {
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);

	}

	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1450, 800);
		setLocationRelativeTo(null);
		setResizable(false);
				
		JPanel panel = new JPanel();
		
		JTextField titleField = new JTextField(20);
		JButton addButton     = new JButton("Add Book");
		JTextArea outputArea  = new JTextArea(10, 30);
		
		panel.add(titleField);
		panel.add(addButton);
		outputArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputArea);
		panel.add(scrollPane);
		add(panel);
		
		addButton.addActionListener(e -> {
			String title = titleField.getText();
			if(title == null || title.isBlank()) {
				JOptionPane.showMessageDialog(null, "Please choose!");
			}
			else {
				Book book = new Book(1001, title, 2000, "Unknown");
				manager.addItem(book);
			}
			outputArea.setText("");
			for(LibraryItem item : manager.getItems()) {
				outputArea.append(item.getDescription() + "\n");
			}
		});
	}
	
	
}
