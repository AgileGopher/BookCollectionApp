package management;

import java.util.HashMap;
import java.util.Map;

import data.AudioBook;
import data.Book;
import data.LibraryItem;
import interfaces.ItemCreator;

public class LibraryItemFactory {
	
	// fields
	// TODO change string to enum "BOOK" || "AUDIOBOOK"
	private static final Map<String, ItemCreator> registry = new HashMap<>();
	
	
	
	// static initializer
	static {
		registry.put("BOOK", parts -> {
			// TODO symbolic constants for these int values
			if(parts.length < 5) {
				throw new IllegalArgumentException("Invalid BOOK line (expected 5 parts): " + String.join("|", parts));
			}
			try {
				int id        = Integer.parseInt(parts[1]);
				String title  = parts[2];
				int year      = Integer.parseInt(parts[3]);
				String author = parts[4];
				
				return new Book(id,title,year,author);
			}
			catch(NumberFormatException  e) {
				throw new IllegalArgumentException("Invalid number in BOOK line: " + String.join("|", parts), e);
			}
		});
		
		
		registry.put("AUDIOBOOK", parts -> {
			if(parts.length < 6) {
				throw new IllegalArgumentException("Invalid BOOK line (expected 5 parts): " + String.join("|", parts));
			}
			try {
				int id          = Integer.parseInt(parts[1]);
				String title    = parts[2];
				int year        = Integer.parseInt(parts[3]);
				String narrator = parts[4];
				int duration    = Integer.parseInt(parts[5]);
				
				return new AudioBook(id,title,year,narrator,duration);
			}
			catch(NumberFormatException  e) {
				throw new IllegalArgumentException("Invalid number in AUDIOBOOK  line: " + String.join("|", parts), e);
			}
		});
		
	}
	
	
	
	public static LibraryItem createItem(String line) {
		if(line == null) {
			throw new IllegalArgumentException("Line cannot be null");
		}
		String[] parts = line.split("\\|");
		
		if(parts.length == 0) {
			throw new IllegalArgumentException("Empty line");
		}
		String type = parts[0].trim().toUpperCase();
		
		// lookup the correct creator in the creators map registry
		ItemCreator creator = registry.get(type);
		
		if(creator == null) {
			throw new IllegalArgumentException("Unknown item type: " + type);
		}
		
		// takes in a string array and returns a LibraryItem object
		return creator.create(parts);
	}

	
	
	
	// method to add new object to the registry
	public static void register(String type, ItemCreator creator) {
		registry.put(type.toUpperCase(), creator);
	}
	
	
}
