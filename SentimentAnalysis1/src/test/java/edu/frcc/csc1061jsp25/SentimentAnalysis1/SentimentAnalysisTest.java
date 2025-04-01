package edu.frcc.csc1061jsp25.SentimentAnalysis1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SentimentAnalysisTest {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in) ;
		Map<String, Integer> map = new MyHashMap<>(); 

		File readFile = new File("sentiments.txt");
		Scanner input = null;
		try {
			input = new Scanner(readFile);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while(input.hasNextLine()) {
			String[] line = input.nextLine().split(",");
			if (line[1].contains("-")) {
				map.put(line[0], -Integer.parseInt(line[1]));
			}
			map.put(line[0], Integer.parseInt(line[1])); 
		}
		input.close();
		
		System.out.println("Enter feedback (type \"END\" when finished): ");
		String line = null; 
		int sentiment = 0; 
		int count = 0; 
		boolean verdict = true; 
		String prevWord = null; 
		while (verdict) {
			line = scnr.nextLine(); 
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			for (String word : words) {
				if (word.trim().equals("end")) {
					verdict = false; 
					break; 
				}
				if (map.containsKey(prevWord + " " + word)) {
					sentiment += map.get(prevWord + " " + word); 
				}
				if (map.get(word) != null) {
					sentiment += map.get(word);
				}
				prevWord = word; 
				++count; 
			}	
		} 
		System.out.println("\nWord count: " + count);
		System.out.println("The overall sentiment of the response was : " + sentiment); 
		System.out.print("The average sentiment was: "); 
		System.out.printf("%.2f", (sentiment / (double)count));
	}
}
