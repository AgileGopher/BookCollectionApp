package driver;

import data.AudioBook;
import data.Book;
import data.LibraryItem;
import management.LibraryManager;

public class BookDriver {

	public static void main(String[] args) {
		
		LibraryItem b1     = new Book(1001, "Eragon", 2006, "Christhopher Paulini");
		LibraryItem b2     = new Book(1002, "Eldest", 2007, "Christhopher Paulini");
		LibraryItem audio1 = new AudioBook(1004, "Eragon", 2008, "Leanord Nemoy", 960);
		

		LibraryManager manager = new LibraryManager();
		manager.addItem(b1);
		manager.addItem(b2);
		manager.addItem(audio1);
		
		//manager.saveLibrary("library.txt");
		
		LibraryManager manager2 = new LibraryManager();
		
		manager2.loadLibrary("library.txt");
		manager2.sortByYear();
		manager2.printLibrary();
	}
}



// things to learn further
// interfaces, lambda expressions, comparator