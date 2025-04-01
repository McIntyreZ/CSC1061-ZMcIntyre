package edu.frcc.csc1061jsp25.SentimentAnalysis1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SentimentAnalysisTest {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in) ; // For keyboard input
		Map<String, Integer> map = new MyHashMap<>(); 

		// Opens sentiments.txt and parses through contents 
		File readFile = new File("sentiments.txt");
		Scanner input = null;
		try {
			input = new Scanner(readFile);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		// Loop reads each line and stores the word with its corresponding value
		// in the hashmap previously created (map) 
		while(input.hasNextLine()) {
			String[] line = input.nextLine().split(",");
			if (line[1].contains("-")) {
				// The program keeps track of the negative values 
				map.put(line[0], -Integer.parseInt(line[1]));
			}
			map.put(line[0], Integer.parseInt(line[1])); 
		}
		input.close();
		
		// The user now puts in the response ending with "END"
		System.out.println("Enter feedback (type \"END\" when finished): ");
		String line = null; 
		int sentiment = 0;      // Keeps track of the total sentiment 
		int count = 0;          // Counts the words (excluding "END") for the response 
		boolean verdict = true; // Condition for the while loop 
		String prevWord = null; // For two word phrases like "fed up" 
		while (verdict) {
			line = scnr.nextLine(); // The program can read multiple lines 
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for (String word : words) {
				if (word.trim().equals("end")) { // Indicates the end of the user message
					verdict = false; 
					break; 
				}
				if (map.containsKey(prevWord + " " + word)) { // Two word phrase check
					sentiment += map.get(prevWord + " " + word); 
				}
				if (map.get(word) != null) { // If word has a value then it will be 
											 // Added in sentiment 
					sentiment += map.get(word);
				}
				prevWord = word; // Passes the current word so program can check a 
								 // Two word phrase with the next word 
				++count;  		 // Increments the word count 
			}	
		} 
		
		// Report of the user message 
		System.out.println("\nWord count: " + count);
		System.out.println("The overall sentiment of the response was : " + sentiment); 
		System.out.print("The average sentiment was: "); 
		System.out.printf("%.2f", (sentiment / (double)count));
	}
}
