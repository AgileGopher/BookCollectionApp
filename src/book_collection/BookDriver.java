package book_collection;

public class BookDriver {

	public static void main(String[] args) {
		
		LibraryItem b1     = new Book(1001, "Eragon", 2006, "Christhopher Paulini");
		LibraryItem b2     = new Book(1002, "Eldest", 2007, "Christhopher Paulini");
		LibraryItem audio1 = new AudioBook(1001, "Eragon", 2006, "Leanord Nemoy", 180);
		
		System.out.println(b1.getDescription() + "\n");
		System.out.println(b2.getDescription() + "\n");
		System.out.println(audio1.getDescription());
	}

}
