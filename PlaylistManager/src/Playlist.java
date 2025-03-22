import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.random.*;

// Class reroutes all user actions to the DoubleLinkedList
public class Playlist {
	// Data Member
	private MyDoubleLinkedList<Song> list; 
	
	public Playlist() {
		list = new MyDoubleLinkedList<Song>(); 
	}

	public void printPlaylist() {
		list.printList();
	}
	
	public void add(Song song) {
		list.add(song);
	}
	
	public void remove(Song rSong) {
		list.remove(rSong); 
	}
	
	public void count() {
		System.out.println(list.size());
	}
	
	public void reverse() {
		list = list.reverse(); 
	}
	
	public void shuffle() {
		list = list.shuffle();
	}
	
	public void printToFile() {
		list.printToFile();  
	}
}
