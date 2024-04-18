package springidol;

public class Song {
	private String title;
	private String artist;

	public Song() {
	}

	public Song(String title,String artist){
		this.title=title;
		this.artist=artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
}
