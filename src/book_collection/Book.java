package book_collection;

public class Book extends LibraryItem implements Searchable {
	
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



	@Override
	public boolean matches(String keyword) {
		return getTitle().toLowerCase().contains(keyword.toLowerCase());
	}



	@Override
	public String serialize() {
		return "BOOK|" +
				getId() + "|" +
				getTitle() +  "|" +
				getYearPublished() + "|" + 
				author;
	}

}
