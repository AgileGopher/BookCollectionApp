package book_collection;

public class BookDriver {

	public static void main(String[] args) {
		
		LibraryItem b1     = new Book(1001, "Eragon", 2006, "Christhopher Paulini");
		LibraryItem b2     = new Book(1002, "Eldest", 2007, "Christhopher Paulini");
		LibraryItem audio1 = new AudioBook(1004, "Eragon", 2006, "Leanord Nemoy", 960);
		

		LibraryManager manager = new LibraryManager();
		manager.additem(b1);
		manager.additem(b2);
		manager.additem(audio1);
		
		
		manager.printLibrary();
		
		LibraryItem found = manager.findItemByID(1007);

		if(found != null)
		    System.out.println("Found: " + found.getDescription());
		else
		    System.out.println("Item not found.");
		
		
	}
	

}
