package edu.frcc.csc1061jsp25.SearchEngine;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.select.Elements;

public class Search {

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		WikiFetcher wf = new WikiFetcher();
		Index index = new Index(); 
		
		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
		index.indexPage(url, paragraphs); 
		
//		index.printIndex(); 
		
		System.out.println("Enter search term: ");
		String term = scnr.next();
		System.out.println(index.get(term)); 
		
		scnr.close();
	}

}
