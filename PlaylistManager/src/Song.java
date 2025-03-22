
public class Song {
	// Data Members
	private String songName;
	private String artist;
	
	// Constructors
	public Song() {
		songName = "noName";
		artist = "nobody"; 
	} 
	// This constructor is only used for the remove action; the program only needs 
	// the name of the song that will be removed 
	public Song(String songName) {
		this.songName = songName;
	}
	
	public Song(String songName, String artist) {
		this.songName = songName;
		this.artist = artist;
	}

	// Getters and Setters 
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// Other Methods 
	// Method allows program to compare to objects to see if they are the same, based on
	// the name of the song 
	@Override
	public boolean equals(Object o) {
		Song song2 = (Song)o; 
		if (songName.trim().equals(song2.songName.trim())) {
			return true;
		}
		return false; 
	}
	
	// Method formats how the data will be stored in the file 
	@Override
	public String toString() {
		return songName + "-" + artist;
	} 
	
	
}
