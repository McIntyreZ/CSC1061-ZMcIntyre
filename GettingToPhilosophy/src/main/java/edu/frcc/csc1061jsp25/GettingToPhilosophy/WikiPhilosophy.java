package edu.frcc.csc1061jsp25.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
    	Scanner scnr = new Scanner(System.in); // For keyboard input 
        String destination = "https://en.wikipedia.org/wiki/Philosophy"; // Getting to philosophy page 
        String source = null;

        // Welcome message 
        System.out.println("Hello, this program will count the amount of links clicked to get to Philosophy"); 
        
        while (true) { // Will loop until user quits 
        	System.out.println("Enter a wikipedia link (type \"quit\" to quit): ");
        	source = scnr.nextLine(); 
        	// If statement ensures there is no small difference for quitting 
            if (source.toLowerCase().replaceAll(" ", "").equals("quit")) {
            	break; 
            }
        	
            testConjecture(destination, source, 20);
        } 
        scnr.close();
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    @SuppressWarnings("unlikely-arg-type")
	public static void testConjecture(String destination, String source, int limit) throws IOException {
    	// Base case 
    	if (destination.equals(source) || source.equals("https://en.wikipedia.org/wiki/Philosophical")) {
    		System.out.println("Philosophy has been found, the number of pages visited is: " + (20 - limit));
    		return; 
    	}
    	
    	// Prevents infinite loop
    	if (limit == 0) {
    		System.out.println("The destination could not be found. Exiting..."); 
    		System.exit(-1);
    	}
    	
        Document doc = null;
        Connection conn = Jsoup.connect(source);
        try 
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // Selects the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");
        boolean found1 = false; 

        for (Element para : paragraphs) {
        	if (!found1) { // Allows the program to escape nested loops if destination
        		Iterable<Node> iter = new WikiNodeIterable(para);		   // is found 
                ArrayDeque<String> stack = new ArrayDeque<>(); // Keeps track of parentheses
                boolean found2 = false; // Second escape from nested loop
                for (Node node : iter) { 
                	if (!found2) {
                		if (node instanceof TextNode) { // Parentheses will be in the text nodes
                    		String temp = ((TextNode) node).getWholeText(); 
                    		for (int i = 0; i < temp.length(); i++) { // Iterates to 
                    			if (temp.charAt(i) == '(') {		  // find any opening 
                    				stack.push("("); 				  // parentheses
                    			}
                    			if (temp.charAt(i) == ')') {
                    				stack.pop(); // Removes a parentheses from arrayDeque
                    			}
                    		}
                    	}
                    	
                    	if (node instanceof Element) { 
                    		if (stack.isEmpty()) { // Ensures link is not in parentheses
                    			if (node.nodeName().equals("a")) { 
                    				String temp2 = node.attr("href"); // Ensures has link
                    				if ((!temp2.equals("") && (!(temp2.charAt(0) == '#')) && temp2 != null)) {
                    					if (temp2.contains("/wiki/") && !temp2.contains("/wiki/Help") && !temp2.contains("/wiki/File")) {
                    						if (!temp2.contains("https:")) {
                        						temp2 = "https://en.wikipedia.org" + temp2; 
                        					}
                    						// Recursive call
                        					testConjecture(destination, temp2, limit - 1);
                        					// Escapes from loops
                        					found1 = true; 
                        					found2 = true;
                    					}
                    				}
                    			}
                    		}
                    	}
                	}
                }
            }
        }
    }
}
