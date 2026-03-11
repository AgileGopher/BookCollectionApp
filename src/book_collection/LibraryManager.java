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
	
	
	
	// remove item by id
	public boolean removeItemById(int id) {
		boolean isRemoved = false;
		while(isRemoved == false) {
			for(LibraryItem item : items) {
				if(item.getId() == id) {
					items.remove(item);
					isRemoved = true;
					System.out.println("Item removed: " + item.getBasicInfo());
				}
			}
		}
		return isRemoved;
	}
	
	
	
	// count items
	public int countItems() {
		return items.size();
	}
	
	
	
	// sort by year
	public void sortByYear() {
		items.sort((a,b) -> a.getYearPublished() - b.getYearPublished());
		System.out.println(items);
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
