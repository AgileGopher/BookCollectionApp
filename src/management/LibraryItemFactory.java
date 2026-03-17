package management;

import java.util.HashMap;
import java.util.Map;

import data.AudioBook;
import data.Book;
import data.LibraryItem;
import interfaces.ItemCreator;

public class LibraryItemFactory {
	
	// fields
	private static final Map<String, ItemCreator> creators = new HashMap<>();
	
	
	
	static {
		
		creators.put("BOOK", parts -> {
			int id        = Integer.parseInt(parts[1]);
			String title  = parts[2];
			int year      = Integer.parseInt(parts[3]);
			String author = parts[4];
			
			return new Book(id,title,year,author);
		});
		
		
		creators.put("AUDIOBOOK", parts -> {
			int id          = Integer.parseInt(parts[1]);
			String title    = parts[2];
			int year        = Integer.parseInt(parts[3]);
			String narrator = parts[4];
			int duration    = Integer.parseInt(parts[5]);
			
			return new AudioBook(id,title,year,narrator,duration);
		});
		
	}
	
	
	
	public static LibraryItem createItem(String line) {
		
		String[] parts = line.split("\\|");
		String type    = parts[0];
		
		ItemCreator creator = creators.get(type);
		
		if(creator == null) {
			throw new IllegalArgumentException("Unknown item type: " + type);
		}
		return creator.create(parts);
	}
	
	
}
