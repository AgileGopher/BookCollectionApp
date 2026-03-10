package book_collection;

public class BookDriver {

	public static void main(String[] args) {
		
		LibraryItem b1     = new Book(1001, "Eragon", 2006, "Christhopher Paulini");
		LibraryItem b2     = new Book(1002, "Eldest", 2007, "Christhopher Paulini");
		LibraryItem audio1 = new AudioBook(1001, "Eragon", 2006, "Leanord Nemoy", 960);
		
		System.out.println(b1.getDescription() + "\n");
		System.out.println(b2.getDescription() + "\n");
		System.out.println(audio1.getDescription() + "\n\n");
		
		LibraryItem item = new Book(1003, "Inheritence", 2011, "Christhopher Paulini");
		System.out.println(item.getDescription());
		
		/*
		 * the book version of getDiescription() runs becuase thats the one that got called.
		 * the getDescription() in LibraryItem is simply a contract that any class extending LibraryItem
		 * is obligated to fill. Now when item get instanitaed from the call stack and created as a book on the 
		 * heap the books getDescription() is called 
		 */
		
		
	}
	

}
