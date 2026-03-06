package book_collection;


public class Book {
	
	// class fields
	private int id;
	private String title;
	private String author;
	private int yearPublished;
	
	
	// symbolic constants 
	private static final int MIN_YEAR_PUBLISHED = 1450;
	private static final int MAX_YEAR_PUBLISHED = 2026;
	
	
	// constructor	
	public Book(final int id, String title, String author, int yearPublished) {
		super();
		this.id = id;
		validateTitle(title);
		this.title = title;
		validateAuthor(author);
		this.author = author;
		validateYear(yearPublished);
		this.yearPublished = yearPublished;
	}
	
	
	// validations
	private static void validateTitle(String title) {
		if(title == null || title.isBlank()) {
			throw new IllegalArgumentException("Error!..  Invalid title: " + title);
		}
	}
	
	// would of just make validateString for title and author but need different error messages
	private static void validateAuthor(String author) {
		if(author == null || author.isBlank()) {
			throw new IllegalArgumentException("Error!..  Invalid author: " + author);   
		}
	}
	
	private static void validateYear(int year) {
		if(year < MIN_YEAR_PUBLISHED || year > MAX_YEAR_PUBLISHED) {
			throw new IllegalArgumentException("Error!..  Invalid year published: " + year);
		}
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
	
	
	
	// class methods
	public void getDescription() {
		System.out.println("Book description here...");
	}

	
	
	// toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + "]";
	}
	
	
	
	

}
