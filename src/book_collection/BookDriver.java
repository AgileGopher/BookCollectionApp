package book_collection;

public class BookDriver {

	public static void main(String[] args) {
		
		Book book1 = new Book(1000, "Eragon", "Christopher Paulini", 2006);
		Book book2 = new Book(1001, "Eldest", "Christopher Paulini", 2007);
		Book book3 = new Book(1002, "Inheritence", "Christopher Paulini", 2009);
		
		Book book4 = new Book(1000, null, "Christopher Paulini", 2006);
	}

}
