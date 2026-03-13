package validations;

import java.util.Scanner;

public class Keyboard {

	
	// fields
	private static Scanner input;
	
	
	
	// constructor
	public Keyboard() {
		super();
		input = new Scanner(System.in);
	}
	
	
	
	// input validation methods
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
		}
	}
	
	
	
}
