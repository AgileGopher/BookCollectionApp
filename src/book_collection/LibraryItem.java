package book_collection;

import java.time.Year;

public abstract class LibraryItem {

	// class fields
	private final int id;
	private String title;
	private int yearPublished;
	
	
	
	// symbolic constants 
	private static final int MIN_YEAR_PUBLISHED = 1450;
	private static final int MAX_YEAR_PUBLISHED = Year.now().getValue();
	private static final int MAX_INPUT_LENGTH   = 30; 
	
	
	
	// constructor
	public LibraryItem(int id, String title, int yearPublished) {
		super();
		validateID(id);
		this.id = id;
		validateString(title);
		this.title = title;
		validateYear(yearPublished);
		this.yearPublished = yearPublished;
	}
	
	
	
	// validations
	private static void validateID(int id) {
		if(id < 1000 || id > 2000) {
			throw new IllegalArgumentException("Error!..  Invalid id: " + id);
		}
	}
	
	protected static void validateString(String string) {
		if(string == null || string.isBlank() || string.length() > MAX_INPUT_LENGTH) {
			throw new IllegalArgumentException("Error!..  Invalid input: " + string);
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

	public int getYearPublished() {
		return yearPublished;
	}
	

	
	// class methods
	public String getBasicInfo() {
		return title + " (" + yearPublished + ")";
	}
	
	
	
	// abstract methods
	public abstract String getDescription();
	
	
	
	// toString
	@Override
	public String toString() {
		return "LibraryItem [id=" + id + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}
	
}
