package book_collection;

public class Book extends LibraryItem {
	
	// class fields
	private String author;


	
	// constructor	
	public Book(final int id, String title, int yearPublished, String author) {
		super(id, title, yearPublished);
		validateString(author);
		this.author = author;
	}

	
	
	// getters
	public String getAuthor() {
		return author;
	}

		
	
	// class methods
	public String getDescription() {
		return super.getBasicInfo() + " by " + author;
	}


}
