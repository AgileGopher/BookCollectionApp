package book_collection;

public class Book {
	
	// class fields
	private int id;
	private String title;
	private String author;
	private int yearPublished;
	
	
	// constructor
	public Book() {
		super();
	}
	
	public Book(final int id, String title, String author, int yearPublished) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
	}
	
	
	// validations
	private static void validateTitle() {
		
	}
	
	private static void validateAuthor() {
		
	}
	
	private static void yearPublished() {
		
	}

	
	
	// getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	
	
	// toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + "]";
	}
	
	
	
	

}
