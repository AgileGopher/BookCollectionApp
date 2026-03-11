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
	
	
	
	// stores item in items
	public void addItem(LibraryItem item) {
		if(item == null) {
			throw new IllegalArgumentException("Error!..  cannot add item: " + item);
		}
		items.add(item);
	}
	
	
	
	// prints contents of Library
	public void printLibrary() {
		for(LibraryItem item : items) {
			System.out.println(item.getDescription() + "\n");
		}
	}

	
	
	// find item by id
	public LibraryItem findItemByID(int id) {
		for(LibraryItem item : items) {
			if(item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

}
