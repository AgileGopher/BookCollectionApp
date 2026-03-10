package book_collection;

public class AudioBook extends LibraryItem {
	
	// class fields
	private String narrator;
	private int durationMinutes;
	
	
	
	// symbolic constants
	private static final int MIN_DURATION_MINUTES = 1;
	private static final int MAX_DURATION_MINUTES = 1000;
	
	
	
	// constructor
	public AudioBook(final int id, String title, int yearPublished, String narrator, int durationMinutes) {
		super(id, title, yearPublished);
		validateString(narrator);
		this.narrator = narrator;
		validateDuration(durationMinutes);
		this.durationMinutes = durationMinutes;
	}
	
	
	
	// validations
	private static void validateDuration(int duration) {
		if(duration < MIN_DURATION_MINUTES || duration > MAX_DURATION_MINUTES) {
			throw new IllegalArgumentException("Error!..  Invalid duration: " + duration);
		}
	}
	
	
	
	// getters
	public String getNarrator() {
		return narrator;
	}


	public int getDurationMinutes() {
		return durationMinutes;
	}


	
	@Override
	public String getDescription() {
		return super.getBasicInfo() + " narrated by " + narrator + " (" + durationMinutes + " minutes)";
	}

}
