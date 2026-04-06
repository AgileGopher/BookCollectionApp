package driver;

import data.AudioBook;
import data.Book;
import management.LibraryItemFactory;
import management.LibraryManager;
import validations.Keyboard;

public class Driver {
	
	// fields
	private static LibraryManager manager;
	private static Keyboard kb;
	

	
	// constructor
	public Driver() {
		super();
		manager = new LibraryManager();
		kb      = new Keyboard();
	}
	
	
	
	// method to run main menu
	private void runMainMenu() {
		int choice;
		boolean proceed = true;
		
		String promptMsg = "Make a selection: \n";
		String errorMsg  = "Invalid entry, enter an intger value in the range (1-7): \n";
		
		while(proceed) {	
			
			System.out.println("------ Library Management System ------\n\n"
			         + "-------------- Main Menu --------------\n"
			         + "1. Add book\n"
			         + "2. Add Audiobook\n"
			         + "3. Search\n"
			         + "4. Print Library\n"
			         + "5. Save\n"
			         + "6. load\n"
			         + "7. Exit\n");
			
			choice = kb.readInteger(promptMsg, errorMsg, 1, 7);
			
			switch(choice) {
			
				case 1: 
					createBook();
					break;
					
				case 2: 
					createAudiobook();
					break;
					
				case 3: 
					searchKeyword();
					break;
					
				case 4: 
					manager.printLibrary();
					break;
					
				case 5: 
					saveAll();
					break;
					
				case 6:
					loadAll();
					break;
					
				case 7:
					System.out.println("Bye for now!");
					proceed = false;
					break;
					
				default:
					System.out.println(errorMsg + ":  " + choice);
			}
		}
	}

	
	
	// method to create new Book object from user input
	private void createBook() {
		int id            = kb.readInteger("enter book id (1000–2000): \n", "Invalid id, try again.. \n");
		String title      = kb.readString("enter title: \n", "Invalid title, try again.. \n");
		int yearPublished = kb.readInteger("enter year published: \n", "Invalid year, try again.. \n");
		String author     = kb.readString("enter author: \n", "Invalid author, try again.. \n");
		Book book = new Book(id,title,yearPublished,author);
		manager.addItem(book);
	}
	
	
	
	// method to create new AudioBook object from user input
	private void createAudiobook() {
		try {
			int id            = kb.readInteger("enter book id: \n", "Invalid id, try again.. \n");
			String title      = kb.readString("enter title: \n", "Invalid title, try again.. \n");
			int yearPublished = kb.readInteger("enter year published: \n", "Invalid year, try again.. \n");
			String narrator   = kb.readString("enter narrator: \n", "Invalid narrator, try again.. \n");
			int duration      = kb.readInteger("enter duration: \n", "Invalid duration, try again.. \n");
			AudioBook audioBook = new AudioBook(id,title,yearPublished,narrator,duration);
			manager.addItem(audioBook);
		}
		catch(IllegalArgumentException e) {
			System.out.println("error, try again..");
		}
	}
	
	
	
	// method to search library by keyword
	private void searchKeyword() {
		String keyword = kb.readString("enter keyword to search: \n", "Invalid keyword");
		manager.searchByKeyword(keyword);
	}
	
	
	
	private void loadAll(){
		String loadFile = kb.readString("enter filename to be loaded: \n", "Invalid filename");
		manager.loadLibrary(loadFile);
	}
	
	
	
	// method to save file
	private void saveAll() {
		String saveFile = kb.readString("enter filename to be saved: \n", "Invalid filename");
		manager.saveLibrary(saveFile);
	}
	
	
	
	// method to initialize program
	private void init() {
		runMainMenu();
	}
	
	
	
	// main method
	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			LibraryItemFactory.createItem("BOOK|1009|1984|1949|George Orwell");
			driver.init();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
}

