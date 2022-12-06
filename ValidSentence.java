package validSentence;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidSentence {

	/**
	* This function is used to determine if a sentence is valid.
	* @param sentence - This is the String the function will review
	* @return true if the sentence is valid  or false if the sentence is invalid
	*/
	public static boolean validSentence(String sentence) {	     
		int quotationCount = 0;
		String[] numberCheckArray = sentence.split(" "); // The values of numberCheckArray are all the individual words in the sentence
	    ArrayList<Integer> numberArray = new ArrayList<Integer>(); // Creates a new ArrayList called numberArray
	    
		// This if statement is used to check if the first character in the sentence is a capital letter
		if (Character.isUpperCase(sentence.charAt(0)) == false) {
			return false;       
		}	
        	
		char periodCheck = sentence.charAt(sentence.length()-1); // The periodCheck variable stores the final character in the sentence 
		
		// This if statement is used to determine if the final character in the sentence is not a . or ? or !
		if (periodCheck != 63 && periodCheck != 33 && periodCheck != 46) {
			return false;
		}
        
		// This for loop is used to check each individual character in the sentence with the relevant selection statements 
		// 
		for(int i = 0; i < sentence.length(); i++) {
			char sentenceChar = sentence.charAt(i); // finds the value of the character at position i in the sentence 
 
			// This if statement is used to check if the character is a quotation mark
			if (sentenceChar == '"' ) {
				quotationCount++; // Increments quotationCount variable
			}	        	  	        	  	        	        
			
			// This if statement is used to check if a period character is used in the middle of the sentence
			if ((sentenceChar == 63 || sentenceChar == 33 || sentenceChar == 46) && (i + 1 != sentence.length())) {
				return false;
			}
			
		}
	    
	    // This for loop is used to find every integer in the sentence and add it to numberArray
	    for(int i = 0; i < numberCheckArray.length; i++) {
	        String word = numberCheckArray[i]; // This variable stores the value of a single word from the sentence	        
		    Scanner scan = new Scanner(word);
		    scan.useDelimiter("\\D+"); 
		    
		    // This if statement is used to add all of the numbers in the sentence to numberArray
		    if (scan.hasNextInt() == true) {
			    int number = scan.nextInt();
			    word = String.valueOf(number);
			    numberArray.add(number);
		    }

	    }
	    
	    // This for loop is used to check if all of the numbers in the sentence are greater than 12
	    for(int number: numberArray) {	        
	        if( 0 <= number && number < 13) {	    	
	        	return false;
	        }
	        		
	    }
			
	    // This if statement is used to check if the value of quotationCount is an odd number
		if(quotationCount % 2 != 0) {
			return false;
		}
		
		return true;		
	}
	
	//testing inputs for the method validSentence in the main method
	public static void main(String[] args) {	
		boolean valid = validSentence("B\"hello\"?");
		System.out.println(valid);
		
		valid = validSentence("Are there 11, 12, or 13 lazy dogs?");
		System.out.println(valid);
	}

}
