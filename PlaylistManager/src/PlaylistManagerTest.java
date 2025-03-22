import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaylistManagerTest {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in) ; // For keyboard input
		// Data Members 
		int choice = 0; // Default value so loop will be entered 
		String songName = "noName";
		String artist = "nobody"; 
		// Create a new playlist; this playlist will record and keep track of all songs
		Playlist playlist = new Playlist(); 
		
		// Playlist.txt records the songs in the playlist
		File readFile = new File("Playlist.txt");
		Scanner input = null;
		try {
			input = new Scanner(readFile);
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		// Loop reads file and converts to songs to input in playlist 
		while(input.hasNextLine()) {
			String[] line = input.nextLine().split("-");
			songName = line[0];
			artist = line[1];
			Song fileSong = new Song(songName, artist); 
			playlist.add(fileSong);
		}
		input.close();
		
		// All user actions are in the loop and repeats until user quits 
		while (choice != 7) {
			menu(); // Greeting and choices
			choice = getChoice(scnr); 
			switch (choice) {
			case 1: // Add song
				System.out.println("Name of song: ");
				songName = scnr.nextLine(); 
				System.out.println("Name of artist"); 
				artist = scnr.nextLine(); 
				Song song = new Song(songName, artist);
				playlist.add(song); 
				break; 
			case 2: // Remove song
				System.out.println("Name of song: ");
				songName = scnr.nextLine();  
				Song rSong = new Song(songName); 
				playlist.remove(rSong);
				break; 
			case 3: // Count the amount of songs in playlist
				playlist.count();
				break; 
			case 4: // "Plays" (prints) playlist
				playlist.printPlaylist();
				break; 
			case 5: // Shuffles the playlist 
				playlist.shuffle(); 
				break;
			case 6: // Reverses the playlist
				playlist.reverse();
				break; 
			}
			playlist.printToFile(); // Saves all changes in the file 
		}
	}

	// Welcome message and shows user options 
	public static void menu() {
		System.out.println("This program is designed to showcase the functions of a "
				+ "LinkedList. The program will create a LinkedList");
		System.out.println(" playlist which songs can be stored. Enter one of the "
				+ "following prompts");
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Count"); 
		System.out.println("4. Play");
		System.out.println("5. Shuffle");
		System.out.println("6. Reverse");
		System.out.println("7. Quit");
	}
	
	// Sorts and returns the user choice 
	public static int getChoice(Scanner scnr) {
		int verdict = 0; 
		
		System.out.println("Enter selection: "); 
		// Ensures proper user input 
		try { 
			verdict = scnr.nextInt();
			if (verdict > 7 || verdict < 1) {
				System.out.println("Incorrect input, try again"); 
				verdict = getChoice(scnr); 
				scnr.nextLine(); // Gets rid of any extra, unwanted, input 
			}
		}
		catch (InputMismatchException e) {
			scnr.nextLine(); // Gets rid of any extra, unwanted, input 
			System.out.println("Incorrect input, try again");
			verdict = getChoice(scnr); 
		}
		scnr.nextLine(); // Gets rid of any extra, unwanted, input 
		return verdict; 
	}
}
