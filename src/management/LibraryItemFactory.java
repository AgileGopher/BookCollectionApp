package management;

import data.AudioBook;
import data.Book;
import data.LibraryItem;

public class LibraryItemFactory {
	
	public static LibraryItem createItem(String line) {
		
		String[] parts = line.split("\\|");
		String type    = parts[0];
		
		if("BOOK".equals(type)) {
			
			int id        = Integer.parseInt(parts[1]);
			String title  = parts[2];
			int year      = Integer.parseInt(parts[3]);
			String author = parts[4];
			
			return new Book(id,title,year,author);
		}
		else if("AUDIOBOOK".equals(type)) {
			
			int id          = Integer.parseInt(parts[1]);
			String title    = parts[2];
			int year        = Integer.parseInt(parts[3]);
			String narrator = parts[4];
			int duration    = Integer.parseInt(parts[5]);
			
			return new AudioBook(id,title,year,narrator,duration);
		}
		else {
			throw new IllegalArgumentException("Unknown item type: " + type);
		}
	}
	
	
}
