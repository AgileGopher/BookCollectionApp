package management;

import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import data.LibraryItem;
import interfaces.Searchable;

public class LibraryManager {
	
	// class fields
	private List<LibraryItem> items;
	
	
	
	// constructor
	public LibraryManager() {
		items = new ArrayList<>();
	}
	
	
	
	// validations
	private static void validateItem(LibraryItem item) {
		if(item == null) {
			throw new IllegalArgumentException("Error!..  cannot add item: " + item);
		}
	}
	
	
	
	// getters
	public List<LibraryItem> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	
	
	// class methods
	
	// stores item in items
	public void addItem(LibraryItem item) {
		validateItem(item);
		items.add(item);
		System.out.println("Item added: " + item.getDescription());
	}
	
	
	
	// count items
	public int countItems() {
		return items.size();
	}
	
	
	
	// sort items by year
	public void sortByYear() {
		items.sort(Comparator.comparingInt(LibraryItem::getYearPublished));
	}
	
	

	// prints contents of Library
	public void printLibrary() {
		for(LibraryItem item : items) {
			System.out.println(item.getDescription() + "\n");
		}
	}

	

	// remove item by id
	public boolean removeItemById(int id) {
		LibraryItem.validateID(id);
		for(int i = 0; i < items.size(); i ++) {
			if(items.get(i).getId() == id) {
				LibraryItem removed = items.remove(i);
				System.out.println("Item removed: " + removed.getBasicInfo());
				return true;
			}
		}
		return false;
	}
	
	
	
	// find item by id
	public LibraryItem findItemByID(int id) {
		LibraryItem.validateID(id);
		return items.stream()
				.filter(item -> item.getId() == id)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No LibraryItem found with that id: " + id)); 
	}
	
	

	// search item by keyword
	public void searchByKeyword(String keyword) {
		LibraryItem.validateString(keyword);
		for(LibraryItem item : items) {
			if(item instanceof Searchable searchableItem) {
				if(searchableItem.matches(keyword)){
					System.out.println(item.getDescription());
				}
			}
		}
	}
	
	
	
	// saves library to a text file
	public void saveLibrary(String filename) {
		try(PrintWriter writer = new PrintWriter(filename)){
			for(LibraryItem item : items) {
				writer.println(item.serialize());
			}
		}
		catch(Exception e) {
			System.out.println("Error saving library: " + e.getMessage());
		}
	}
	
	
	
	// loads library from a text file
	public void loadLibrary(String filename) {
		try(Scanner scanner = new Scanner(new File(filename))){
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				LibraryItem item = LibraryItemFactory.createItem(line);
				addItem(item);
			}
		}
		catch(Exception e) {
			System.out.println("Error loading library: " + e.getMessage());
		}
	}
	
	
}
