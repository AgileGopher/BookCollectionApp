package book_collection;

import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	
	
	// sort items by year
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
	
	
	
	// search item by keyword
	public void searchByKeyword(String keyword) {
		for(LibraryItem item : items) {
			if(item instanceof Searchable) {
				Searchable searchable = (Searchable) item;
				if(searchable.matches(keyword)){
					System.out.println(item.getDescription());
				}
			}
		}
	}
	
	
	// saves library to a text file
	public void saveLibrary(String filename) {
		try(PrintWriter writer = new PrintWriter(filename)){
			for(LibraryItem item : items) {
				
				if(item instanceof Book b) {
					writer.println(
						"BOOK|" +
						b.getId() + "|" +
						b.getTitle() + "|" +
						b.getYearPublished() + "|" +
						b.getAuthor()
					);
				}
				
				else if(item instanceof AudioBook a) {
					writer.println(
						"AUDIOBOOK|" +
						a.getId() + "|" +
						a.getTitle() + "|" +
						a.getYearPublished() + "|" +
						a.getNarrator() + "|" + 
						a.getDurationMinutes()
					);
				}
			}
		}catch(Exception e) {
			System.out.println("Error saving library: " + e.getMessage());
		}
	}
	
	
	
	
	// loads library from a text file
	public void loadLibrary(String filename) {
		try(Scanner scanner = new Scanner(new File(filename))){
			
			while(scanner.hasNextLine()) {
				
				String line    = scanner.nextLine();
				String[] parts = line.split("|");
				String type    = parts[0];
				
				if(type.equals("BOOK")) {
					
					int id        = Integer.parseInt(parts[1]);
					String title  = parts[2];
					int year      = Integer.parseInt(parts[3]);
					String author = parts[4];
					
					addItem(new Book(id, title, year, author));
				}	
				else if(type.equals("AUDIOBOOK")) {
					
					int id          = Integer.parseInt(parts[1]);
					String title    = parts[2];
					int year        = Integer.parseInt(parts[3]);
					String narrator = parts[4];
					int duration    = Integer.parseInt(parts[5]);
					
					addItem(new AudioBook(id, title, year, narrator, duration));
				}
			}
		}
		catch(Exception e) {
			System.out.println("Error loading library: " + e.getMessage());
		}
	}
	
	

}
