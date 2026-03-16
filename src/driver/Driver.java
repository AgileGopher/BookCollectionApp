package driver;

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
	
	
	
	// method to initialize program
	private void init() {
		manager.loadLibrary("library.txt");
		runMainMenu();
	}
	
	
	
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
			         + "6. Load\n"
			         + "7. Exit\n");
			
			choice = kb.readInteger(promptMsg, errorMsg, 1, 7);
			
			switch(choice) {
			
				case 1:
					//TODO addBook();
					System.out.println("1");
					break;
					
				case 2:
					//TODO addAudiobook();
					System.out.println("2");
					break;
					
				case 3:
					//TODO
					String keyword = "";
					manager.searchByKeyword(keyword);
					break;
					
				case 4:
					manager.printLibrary();
					break;
					
				case 5:
					String saveFile      = null;
					String savePromptMsg = "enter filename to be saved: \n";
					String saveErrorMsg  = "Invalid filename";
					saveFile = kb.readString(savePromptMsg, saveErrorMsg);
					manager.saveLibrary(saveFile);
					break;
					
				case 6:
					// TODO
					String loadFile = "";
					manager.loadLibrary(loadFile);
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

	
	private void addBook() {
		
	}
	
	
	// main method
	public static void main(String[] args) {

		Driver driver = new Driver();
		driver.init();
	}
	
	
	
}



// things to learn further
// interfaces, lambda expressions, comparator