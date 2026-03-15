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
		
	}

	
	
	
	
	// main method
	public static void main(String[] args) {

		Driver driver = new Driver();
		driver.init();
	}
	
	
	
}



// things to learn further
// interfaces, lambda expressions, comparator