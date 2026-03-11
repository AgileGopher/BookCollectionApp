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
	public void additem(LibraryItem item) {
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
	
	
	// retrieve item
	public LibraryItem getItem(LibraryItem item) {
		for(LibraryItem i : items) {
			if(i != item) {
				throw new IllegalArgumentException("Error!.. Item does not exist in library: " + item);
			}
		}
		return item;
	}
	
	
	// find item by id
	public LibraryItem getItemByID(int id) {
		LibraryItem item = null;
		for(LibraryItem i : items) {
			if(i.getId() != id) {
				throw new IllegalArgumentException("Error!.. Item does not exist in library: " + item);
			}
			item = i;
		}
		return item;
	}
	
	
	
	
	
	
	
	
	
	
	

}
