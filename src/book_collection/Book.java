package book_collection;

import java.time.Year;

public class Book {
	
	// class fields
	private final int id;
	private String title;
	private String author;
	private int yearPublished;
	
	
	// symbolic constants 
	private static final int MIN_YEAR_PUBLISHED = 1450;
	private static final int MAX_YEAR_PUBLISHED = Year.now().getValue();
	private static final int MAX_INPUT_LENGTH   = 30; 
	
	
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
		if(title == null || title.isBlank() || title.length() > MAX_INPUT_LENGTH) {
			throw new IllegalArgumentException("Error!..  Invalid title: " + title);
		}
	}
	
	// would of just make validateString for title and author but need different error messages
	private static void validateAuthor(String author) {
		if(author == null || author.isBlank() || author.length() > MAX_INPUT_LENGTH) {
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
	public String getDescription() {
		return title + " by " + author + " (" + yearPublished + ")";
	}

	
	
	// toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + "]";
	}
	
	
	
	

}
