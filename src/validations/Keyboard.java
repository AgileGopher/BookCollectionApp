package validations;

import java.util.Scanner;

public class Keyboard {

	
	// fields
	private final Scanner input;
	
	
	
	// constructor
	public Keyboard() {
		super();
		input = new Scanner(System.in);
	}
	
	
	
	// method to validate user input for integer within a given range
	public int readInteger(String promptMsg, String errorMsg, int low, int high) {
		
		int num = 0;
		boolean valid = false;
		String strInput;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				if(num >= low && num <= high) {
					valid = true;
					break;
				}
				else {
					System.out.println(errorMsg + "\n");
				}
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg + "\n");
			}
		}
		return num;
	}
	
	
	
	// method to validate user input for integer
	public int readInteger(String promptMsg, String errorMsg) {
		
		int num = 0;
		boolean valid = false;
		String strInput;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				valid = true;
				break;
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg + "\n");
			}
		}
		return num;
	}
	
	
	
	// method to validate user input for valid string
	public String readString(String promptMsg, String errorMsg) {
		
		String strInput = null;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				if(strInput != null && !strInput.isBlank() && strInput.matches("^[a-z A-Z 0-9]*$")) {
					valid = true;
					break;
				}
				else {
					System.out.println(errorMsg + "\n");
				}
			}
			catch(RuntimeException e) {
				System.out.println(errorMsg);
			}
		}
		return strInput;
	}
	
	
}
