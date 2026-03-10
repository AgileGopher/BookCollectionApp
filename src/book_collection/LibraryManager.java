package book_collection;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
	
	// class fields
	private List<LibraryItem>items;
	
	
	
	// constructor
	public LibraryManager() {
		items = new ArrayList<>();
	}



	// getters
	public List<LibraryItem> getItems() {
		return items;
	}
	
	
	
	// class methods
	public void additem(LibraryItem item) {
		if(item == null) {
			throw new IllegalArgumentException("Error!..  cannot add item: " + item);
		}
		items.add(item);
	}
	
	
	
	public void printLibrary() {
		for(LibraryItem item : items) {
			System.out.println(item.getDescription() + "\n");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
